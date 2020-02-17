package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/17 15:06
 */
@Data
public class ServiceCharge {
    private DateTime date;
    private double amount;

    public ServiceCharge(DateTime date) {
        this.date = date;
    }
}
