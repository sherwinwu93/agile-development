package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/15 23:47
 */
public class MonthlySchedule implements PaymentSchedule {
    public boolean isLastDayOfMonth(DateTime date) {
        int m1 = date.getMonthOfYear();
        int m2 = date.plusDays(1).getMonthOfYear();
        return m1 != m2;
    }

    public boolean isPayDate(DateTime date) {
        return isLastDayOfMonth(date);
    }

    @Override
    public DateTime getPayPeriodStartDate(DateTime payPeriodEndDate) {
        return null;
    }
}
