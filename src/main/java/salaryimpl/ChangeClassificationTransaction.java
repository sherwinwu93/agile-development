package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 14:30
 */
public interface ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    PaymentClassification getClassification();
    PaymentSchedule getSchedule();
}
