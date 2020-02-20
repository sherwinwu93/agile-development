package salaryimpl;

/**
 * 修改单个属性的类,都以empId为参数,所以可以创建更高层次ChangeEmployeeTransactionImpl.
 * @author wusd
 * @date 2020/2/18 13:21
 */
public class ChangeNameTransactionImpl extends ChangeEmployeeTransactionImpl implements ChangeNameTransaction {
    protected String name;

    public ChangeNameTransactionImpl(int empId, String name) {
        super(empId);
        this.name = name;
    }

    /**
     * template method的另一半
     * @param e
     */
    @Override
    public void change(Employee e) {
        e.setName(name);
    }
}
