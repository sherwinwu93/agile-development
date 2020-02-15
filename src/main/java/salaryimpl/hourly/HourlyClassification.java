package salaryimpl.hourly;

import lombok.Data;
import salaryimpl.PaymentClassification;

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
}
