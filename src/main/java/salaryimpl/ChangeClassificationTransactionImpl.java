package salaryimpl;

/**
 * template method
 * @author wusd
 * @date 2020/2/18 14:31
 */
public abstract class ChangeClassificationTransactionImpl extends ChangeEmployeeTransactionImpl implements ChangeClassificationTransaction {
    protected int empId;

    public ChangeClassificationTransactionImpl(int empId) {
        super(empId);
    }

    @Override
    public void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
    }
}
