package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/19 21:24
 */
public class DateUtils {
    public static boolean isBetween(DateTime theDate, DateTime startDate, DateTime endDate) {
        return theDate.compareTo(startDate) >= 0 && theDate.compareTo(endDate) <= 0;
    }
}
