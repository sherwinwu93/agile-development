package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/15 22:43
 */
public interface AddEmployeeTransaction extends Transaction {
    /**
     * 选择合适的类别
     * @return
     */
    PaymentClassification getClassification();

    /**
     * 选择合适的支付计划
     * @return
     */
    PaymentSchedule getSchedule();
}
