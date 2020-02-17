package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/17 13:31
 */
public class DeleteEmployeeTransactionImpl implements DeleteEmployeeTransaction {
    private int empId;
    public DeleteEmployeeTransactionImpl(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        PayrollDatabaseImpl.instance.deleteEmployee(empId);
    }
}
