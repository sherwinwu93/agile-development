package salaryimpl;

/**
 * 支付类别
 * @author wusd
 * @date 2020/2/15 22:50
 */
public interface PaymentClassification {
    /**
     * 计算薪水
     * @param pc
     * @return
     */
    double calculatePay(Paycheck pc);
}
