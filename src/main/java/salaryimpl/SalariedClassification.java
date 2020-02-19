package salaryimpl;

import lombok.Data;
import salaryimpl.PaymentClassification;

/**
 * @author wusd
 * @date 2020/2/15 23:11
 */
@Data
public class SalariedClassification implements PaymentClassification {
    private Double salary;

    public SalariedClassification() {
    }

    public SalariedClassification(Double salary) {
        this.salary = salary;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        return 0;
    }
}
