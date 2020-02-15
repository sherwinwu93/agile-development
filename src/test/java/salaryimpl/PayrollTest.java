package salaryimpl;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import salaryimpl.commissioned.AddCommissionedEmployee;
import salaryimpl.commissioned.AddCommissionedEmployeeImpl;
import salaryimpl.commissioned.BlweeklySchedule;
import salaryimpl.commissioned.CommissionedClassification;
import salaryimpl.database.PayrollDatabase;
import salaryimpl.database.PayrollDatabaseImpl;
import salaryimpl.hourly.AddHourlyEmployee;
import salaryimpl.hourly.AddHourlyEmployeeImpl;
import salaryimpl.hourly.HourlyClassification;
import salaryimpl.hourly.WeeklySchedule;
import salaryimpl.salaried.AddSalariedEmployee;
import salaryimpl.salaried.AddSalariedEmployeeImpl;
import salaryimpl.salaried.MonthlySchedule;
import salaryimpl.salaried.SalariedClassification;

import static org.junit.Assert.*;

/**
 * @author wusd
 * @date 2020/2/15 21:50
 */
public class PayrollTest {
    PayrollDatabase payrollDatabase = PayrollDatabaseImpl.getInstance();
    @Test
    public void addSalariedEmployee() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployeeImpl(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertTrue(StringUtils.equals("Bob", e.getName()));

        PaymentClassification pc = e.getClassification();
        assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;

        assertEquals(1000.00, sc.getSalary(), .001);
        PaymentSchedule ps = e.getSchedule();
        assertTrue(ps instanceof MonthlySchedule);
        MonthlySchedule ms = (MonthlySchedule) ps;

        PaymentMethod pm = e.getMethod();
        assertTrue(pm instanceof HoldMethod);
        HoldMethod hm = (HoldMethod) pm;
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
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployeeImpl(empId, "Jack", "City",
                1.0, 3.0);
        t.execute();

        Employee e = payrollDatabase.getEmployee(empId);
        assertTrue(e != null);

        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();

        e = payrollDatabase.getEmployee(empId);
        assertTrue(e == null);
    }
}