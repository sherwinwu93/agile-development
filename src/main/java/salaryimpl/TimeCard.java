package salaryimpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @author wusd
 * @date 2020/2/17 13:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeCard {
    private DateTime date;
    private double hours;
}
