package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/15 23:47
 */
public class MonthlySchedule implements PaymentSchedule {
    /**
     * 如果没有一个好的Date类,进行这种简单的日期计算是非常困难的
     * @param date
     * @return
     */
    public boolean isLastDayOfMonth(DateTime date) {
        int m1 = date.getMonthOfYear();
        int m2 = date.plusDays(1).getMonthOfYear();
        return m1 != m2;
    }

    /**
     * 仅当日期参数是当月最后一天时,才返回true
     * @param date
     * @return
     */
    public boolean isPayDate(DateTime date) {
        return isLastDayOfMonth(date);
    }

    @Override
    public DateTime getPayPeriodStartDate(DateTime payPeriodEndDate) {
        return null;
    }
}
