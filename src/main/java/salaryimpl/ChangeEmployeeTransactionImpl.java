package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 13:27
 */
public class ChangeEmployeeTransactionImpl implements ChangeEmployeeTransaction {
    protected int empId;

    public ChangeEmployeeTransactionImpl(int empId) {
        this.empId = empId;
    }

    @Override
    public void change(Employee e) {

    }

    @Override
    public void execute() {
        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        if (e != null) change(e);
    }
}
