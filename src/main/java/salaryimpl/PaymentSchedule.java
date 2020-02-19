package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/15 22:50
 */
public interface PaymentSchedule {
    boolean isPayDate(DateTime date);
    DateTime getPayPeriodStartDate(DateTime payPeriodEndDate);
}
