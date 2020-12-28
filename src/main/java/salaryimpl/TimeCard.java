package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * 时间登记卡类
 * 只是一个数据类
 *
 * todo 考虑一下允许周末登记时间卡,并正确计算加班时间的情况
 * @author wusd
 * @date 2020/2/17 13:50
 */
@Data
public class TimeCard {
    //请注意,由于java类库的便利.实际上应该先采用基本类型代替
    private DateTime date;
    private double hours;

    public TimeCard(DateTime date, double hours) {
        this.date = date;
        this.hours = hours;
    }
}
