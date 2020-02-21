package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @author wusd
 * @date 2020/2/15 22:51
 */
@Data
public class Employee {
    private int empId;
    private String name;
    private String address;
    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;
    //无法识别从属关系的明确种类.多态解决了这个两难问题.
//    private List<Affiliation> affiliations;
    private Affiliation affiliation;
    private DateTime payDate;

    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }
    public boolean isPayDate(DateTime payDate) {
        return schedule.isPayDate(payDate);
    }

    /**
     * 计算并发送所有雇员支付信息的通用算法.
     * 其中大量使用了Strategy模式.所有的计算细节都被推迟到所包含的策略类:classification,affiliation以及method中
     * @param pc: 薪水
     */
    public void payday(Paycheck pc) {
//        DateTime payDate = pc.getPayPeriodEndDate();
        double grossPay = classification.calculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;
        //工资总额
        pc.setGrossPay(grossPay);
        //减去金额
        pc.setDeductions(deductions);
        //实付金额
        pc.setNetPay(netPay);
        method.pay(pc);
    }
    public DateTime getPayPeriodStartDate(DateTime payPeriodEndDate) {
        return schedule.getPayPeriodStartDate(payPeriodEndDate);
    }
}
