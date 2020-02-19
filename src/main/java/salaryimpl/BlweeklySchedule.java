package salaryimpl;

import org.joda.time.DateTime;
import salaryimpl.PaymentSchedule;

/**
 * @author wusd
 * @date 2020/2/16 0:42
 */
public class BlweeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(DateTime date) {
        return false;
    }

    @Override
    public DateTime getPayPeriodStartDate(DateTime payPeriodEndDate) {
        return null;
    }
}
