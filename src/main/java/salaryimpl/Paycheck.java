package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * 把用于计算支付期间的日期放在Paycheck对象中.
 * 目前仅仅包含支付期间的终止日期,还需要能够从Paycheck中获取起始日期.
 * @author wusd
 * @date 2020/2/19 12:11
 */
@Data
public class Paycheck {
    protected DateTime payDate;
    protected double grossPay;
    protected double deductions;
    protected double netPay;
    protected DateTime payPeriodStartDate;
    protected DateTime payPeriodEndDate;

    public Paycheck(DateTime payDate) {
        this.payDate = payDate;
    }

    public Paycheck(DateTime payPeriodEndDate, DateTime payDate) {
        this.payPeriodEndDate = payPeriodEndDate;
        this.payDate = payDate;
    }

    public String getField(String str) {
        return null;
    }
}
