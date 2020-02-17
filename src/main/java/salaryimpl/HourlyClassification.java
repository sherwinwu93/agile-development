package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/16 0:29
 */
@Data
public class HourlyClassification implements PaymentClassification {
    protected Double hourlyRate;

    public HourlyClassification(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void addTimeCard(TimeCard timeCard) {
    }
    public TimeCard getTimeCard(DateTime date) {
        return null;
    }
}
