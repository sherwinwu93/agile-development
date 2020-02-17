package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/15 22:43
 */
public interface AddEmployeeTransaction extends Transaction {
    PaymentClassification getClassification();
    PaymentSchedule getSchedule();
}
