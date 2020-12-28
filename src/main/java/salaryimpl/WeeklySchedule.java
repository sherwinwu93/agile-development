package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/16 0:35
 */
public class WeeklySchedule implements PaymentSchedule {
    /**
     * 支付薪水时间是周五
     * @param date
     * @return
     */
    public boolean isPayDate(DateTime date) {
        return date.getDayOfWeek() == 5;
    }

    @Override
    public DateTime getPayPeriodStartDate(DateTime payPeriodEndDate) {
        return null;
    }
}
