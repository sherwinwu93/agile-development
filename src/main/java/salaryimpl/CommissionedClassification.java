package salaryimpl;

import lombok.Data;
import salaryimpl.PaymentClassification;

/**
 * @author wusd
 * @date 2020/2/16 0:41
 */
@Data
public class CommissionedClassification implements PaymentClassification {
    protected Double salary;
    protected Double commissionRate;

    public CommissionedClassification(Double salary, Double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        return 0;
    }
}
