package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 14:30
 */
public interface ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    //支付类别
    PaymentClassification getClassification();
    //支付计划
    PaymentSchedule getSchedule();
}
