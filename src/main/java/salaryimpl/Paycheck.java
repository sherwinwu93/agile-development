package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

/**
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
