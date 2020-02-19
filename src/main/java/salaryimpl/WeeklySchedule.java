package salaryimpl;

import org.joda.time.DateTime;
import salaryimpl.PaymentSchedule;

/**
 * @author wusd
 * @date 2020/2/16 0:35
 */
public class WeeklySchedule implements PaymentSchedule {
    public boolean isPayDate(DateTime date) {
        return date.getDayOfWeek() == 5;
    }

    @Override
    public DateTime getPayPeriodStartDate(DateTime payPeriodEndDate) {
        return null;
    }
}
