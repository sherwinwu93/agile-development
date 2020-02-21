package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 13:27
 */
public abstract class ChangeEmployeeTransactionImpl implements ChangeEmployeeTransaction {
    protected int empId;

    public ChangeEmployeeTransactionImpl(int empId) {
        this.empId = empId;
    }

    /**
     * template method模式的结构
     * 对于所有的更改操作,都必须要从payrollDatabase中取出Employee对象.
     * 因此,获取这个对象,然后调用change(e).
     */
    @Override
    public void execute() {
        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        if (e != null) change(e);
    }
}
