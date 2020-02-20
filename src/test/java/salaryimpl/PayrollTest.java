package salaryimpl;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author wusd
 * @date 2020/2/15 21:50
 */
public class PayrollTest {
    PayrollDatabase payrollDatabase = PayrollDatabaseImpl.instance;

    @Test
    public void addSalariedEmployee() {
        //增加正式工
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployeeImpl(empId, "Bob", "Home", 1000.00);
        t.execute();

        //从数据库中获取
        Employee e = payrollDatabase.getEmployee(empId);
        assertTrue(StringUtils.equals("Bob", e.getName()));

        //校验雇员类别
        PaymentClassification pc = e.getClassification();
        assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;
        assertEquals(1000.00, sc.getSalary(), .001);

        //校验支付安排
        PaymentSchedule ps = e.getSchedule();
        assertTrue(ps instanceof MonthlySchedule);

        //校验支付方式
        PaymentMethod pm = e.getMethod();
        assertTrue(pm instanceof HoldMethod);
        payrollDatabase.clear();
    }

    @Test
    public void addHourlyEmployee() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "John", "Company", 1.0);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertTrue(StringUtils.equals("John", e.getName()));

        PaymentClassification pc = e.getClassification();
        assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(1.0, hc.getHourlyRate(), .001);

        PaymentSchedule ps = e.getSchedule();
        assertTrue(ps instanceof WeeklySchedule);
        WeeklySchedule hs = (WeeklySchedule) ps;

        PaymentMethod pm = e.getMethod();
        assertTrue(pm instanceof HoldMethod);
        HoldMethod hm = (HoldMethod) pm;

        payrollDatabase.clear();
    }

    @Test
    public void addCommissionedEmployee() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployeeImpl(empId, "Jack", "City",
                1.0, 3.0);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertTrue(StringUtils.equals("Jack", e.getName()));

        PaymentClassification pc = e.getClassification();
        assertTrue(pc instanceof CommissionedClassification);
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(1.0, cc.getSalary(), .001);
        assertEquals(3.0, cc.getCommissionRate(), .001);

        PaymentSchedule ps = e.getSchedule();
        assertTrue(ps instanceof BlweeklySchedule);
        BlweeklySchedule bs = (BlweeklySchedule) ps;

        PaymentMethod pm = e.getMethod();
        assertTrue(pm instanceof HoldMethod);
        HoldMethod hm = (HoldMethod) pm;

        payrollDatabase.clear();
    }

    @Test
    public void deleteEmployee() {
        //增加销售员工
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployeeImpl(empId, "Jack", "City",
                1.0, 3.0);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        DeleteEmployeeTransaction dt = new DeleteEmployeeTransactionImpl(empId);
        dt.execute();

        e = payrollDatabase.getEmployee(empId);
        assertNull(e);
    }

    /**
     * 时间卡
     */
    @Test
    public void timeCardTransaction() {
        DateTime date = DateTime.parse("2001-10-31");

        //增加钟点工
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();

        //时间卡事务
        TimeCardTransaction tct = new TimeCardTransactionImpl(date, 8.0, empId);
        tct.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.getClassification();
        assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        //检查类别中是否有时间卡
        TimeCard tc = hc.getTimeCard(date);
        assertNotNull(tc);
        assertEquals(8.0, tc.getHours(), .001);
    }

    /**
     * 增加服务费用
     */
    @Test
    public void addServiceCharge() {
        //增加钟点工
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertNotNull(e);

        //向钟点工增加协会从属关系
        UnionAffiliation af = new UnionAffiliation(empId, 12.5);
        e.setAffiliation(af);

        //执行服务费用事务.
        int memberId = 86;//MaxwellSmart
        payrollDatabase.addUnionMember(memberId, e);
        ServiceChargeTransaction sct = new ServiceChargeTransactionImpl(memberId,
                DateTime.parse("2001-11-01"), 12.95);
        sct.execute();
        ServiceCharge sc = af.getServiceCharge(DateTime.parse("2001-11-01"));
        assertNotNull(sc);
        //校验是否服务费用加入到协会从属关系中
        assertEquals(12.95, sc.getAmount(), .001);
    }

    @Test
    public void changeNameTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();

        //修改名字事务
        ChangeNameTransaction cnt = new ChangeNameTransactionImpl(empId, "Bob");
        cnt.execute();
        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        assertNotNull(e);
        //校验
        assertEquals("Bob", e.getName());
    }

    @Test
    public void changeHourlyTransaction() {
        //创建销售
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployeeImpl(empId, "Lance", "Home",
                2500.0, 3.2);
        t.execute();
        //修改雇员类别为hourly
        ChangeHourlyTransaction cht = new ChangeHourlyTransactionImpl(empId, 27.52);
        cht.execute();

        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        assertNotNull(e);

        //判读是否修改为类别
        PaymentClassification pc = e.getClassification();
        assertNotNull(pc);
        assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(27.52, hc.getHourlyRate(), .001);
        //是否修改支付安排
        PaymentSchedule ps = e.getSchedule();
        assertTrue(ps instanceof WeeklySchedule);
        WeeklySchedule ws = (WeeklySchedule) ps;
    }

    @Test
    public void changeMemberTransaction() {
        int empId = 2;
        int memberId = 7734;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();

        //修改成员事务, 把该雇员放入协会中
        ChangeMemberTransaction cmt = new ChangeMemberTransactionImpl(empId, memberId, 99.42);
        cmt.execute();
        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        assertNotNull(e);

        //核实是否成员绑定了UnionAffiliation, 该UnionAffiliation具有正确的会费
        Affiliation af = e.getAffiliation();
        assertNotNull(af);
        assertTrue(af instanceof UnionAffiliation);
        UnionAffiliation uf = (UnionAffiliation) af;
        assertEquals(99.42, uf.getDues(), .001);
        Employee member = PayrollDatabaseImpl.instance.getUnionMember(memberId);
        assertNotNull(member);
        assertTrue(e == member);
    }

    @Test
    public void paySingleSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployeeImpl(empId, "Bob", "Home", 1000.00);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-30");
        PaydayTransaction pt = new PaydayTransactionImpl();
        pt.execute();
        Paycheck pc = pt.getPaycheck(empId);
        assertNotNull(pc);
        assertTrue(pc.getPayDate().equals(payDate));
        assertEquals(1000.00, pc.getGrossPay(), .001);
        assertTrue("Hold".equals(pc.getField("Disposition")));
        assertEquals(0.0, pc.getDeductions(), .001);
        assertEquals(1000.00, pc.getNetPay(), .001);
    }

    @Test
    public void paySingleSalariedEmployeeOnWrongDate() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployeeImpl(empId, "Bob", "Home", 1000.00);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-29");
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        Paycheck pc = pt.getPaycheck(empId);
        assertNotNull(pc);
    }

    @Test
    public void paySingleHourlyEmployeeNoTimeCards() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-09");
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        validatePaycheck(pt, empId, payDate, 0.0);
    }

    @Test
    public void paySingleHourlyEmployeeOneTimeCard() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-09");

        TimeCardTransaction tc = new TimeCardTransactionImpl(payDate, 2.0, empId);
        tc.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        validatePaycheck(pt, empId, payDate, 30.5);
    }

    @Test
    public void paySingleHourlyEmployeeOvertimeOneTimeCard() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-09");

        TimeCardTransaction tc = new TimeCardTransactionImpl(payDate, 9.0, empId);
        tc.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        validatePaycheck(pt, empId, payDate, (8 + 1.5) * 15.25);
    }

    @Test
    public void paySingleHourlyEmployeeOnWrongDate() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-08");

        TimeCardTransaction tc = new TimeCardTransactionImpl(payDate, 9.0, empId);
        tc.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();

        Paycheck pc = pt.getPaycheck(empId);
        assertNull(pc);
    }

    @Test
    public void paySingleHourlyEmployeeTwoTimeCards() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-09");

        TimeCardTransaction tc = new TimeCardTransactionImpl(payDate, 2.0, empId);
        tc.execute();
        TimeCardTransaction tc2 = new TimeCardTransactionImpl(DateTime.parse("2001-11-08"), 5.0, empId);
        tc2.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
    }

    @Test
    public void paySingleHourlyEmployeeWithTimeCardsSpanningTwoPayPeriods() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.25);
        t.execute();
        DateTime payDate = DateTime.parse("2001-11-09");
        DateTime dateInPreviousPayPeriod = DateTime.parse("2001-11-02");

        TimeCardTransaction tc = new TimeCardTransactionImpl(payDate, 2.0, empId);
        tc.execute();
        TimeCardTransaction tc2 = new TimeCardTransactionImpl(dateInPreviousPayPeriod, 5.0, empId);
        tc2.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        validatePaycheck(pt, empId, payDate, 2 * 15.25);
    }

    @Test
    public void salariedSalariedUnionMemberDues() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployeeImpl(empId, "Bob", "Home", 1000.00);
        t.execute();
        int memberId = 7734;
        ChangeMemberTransaction cmt = new ChangeMemberTransactionImpl(empId, memberId, 9.42);
        cmt.execute();
        DateTime payDate = DateTime.parse("2001-11-30");
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        validatePaycheck(pt, empId, payDate, 1000.00);
    }

    @Test
    public void hourlyUnionMemberServiceCharge() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.24);
        t.execute();
        int memberId = 7734;
        ChangeMemberTransaction cmt = new ChangeMemberTransactionImpl(empId, memberId, 9.42);
        cmt.execute();
        DateTime payDate = DateTime.parse("2001-11-09");
        ServiceChargeTransaction sct = new ServiceChargeTransactionImpl(memberId, payDate, 19.42);
        sct.execute();
        TimeCardTransaction tct = new TimeCardTransactionImpl(payDate, 8.0, empId);
        tct.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        Paycheck pc = pt.getPaycheck(empId);
        assertNotNull(pc);
        assertEquals(pc.getPayPeriodEndDate(), payDate);
        assertEquals(8 * 15.24, pc.getGrossPay(), .001);
        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(9.42 + 19.42, pc.getDeductions(), .001);
        assertEquals((8 * 15.42) - (9.42 + 19.42), pc.getNetPay(), .001);
    }

    @Test
    public void serviceChargesSpanningMultiplePayPeriods() {
        int empId = 1;
        AddHourlyEmployee t = new AddHourlyEmployeeImpl(empId, "Bill", "Home", 15.24);
        t.execute();
        int memberId = 7734;
        ChangeMemberTransaction cmt = new ChangeMemberTransactionImpl(empId, memberId, 9.42);
        cmt.execute();
        DateTime earlyDate = DateTime.parse("2001-11-02");
        DateTime payDate = DateTime.parse("2001-11-09");
        DateTime lateDate = DateTime.parse("2001-11-16");
        ServiceChargeTransaction sct = new ServiceChargeTransactionImpl(memberId, payDate, 19.42);
        sct.execute();
        ServiceChargeTransaction sctEarly = new ServiceChargeTransactionImpl(memberId, earlyDate, 100.00);
        sctEarly.execute();
        ServiceChargeTransaction sctLate = new ServiceChargeTransactionImpl(memberId, lateDate, 200.00);
        sctLate.execute();
        TimeCardTransaction tct = new TimeCardTransactionImpl(payDate, 8.0, empId);
        tct.execute();
        PaydayTransaction pt = new PaydayTransactionImpl(payDate);
        pt.execute();
        Paycheck pc = pt.getPaycheck(empId);
        assertNotNull(pc);
        assertEquals(pc.getPayPeriodEndDate(), payDate);
        assertEquals(8 * 15.24, pc.getGrossPay(), .001);
        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(9.42 + 19.42, pc.getDeductions(), .001);
        assertEquals((8 * 15.24) - (9.42 + 19.42), pc.getNetPay(), .001);
    }

    public void validatePaycheck(PaydayTransaction pt, int empId, DateTime payDate, double pay) {
        Paycheck pc = pt.getPaycheck(empId);
        assertNotNull(pc);
        assertEquals(pc.getPayPeriodEndDate(), payDate);
        assertEquals(pay, pc.getGrossPay(), .001);
        assertEquals("Hold", pc.getField("Disposition"));
        assertEquals(0.0, pc.getDeductions(), .001);
        assertEquals(pay, pc.getNetPay(), .001);
    }
}