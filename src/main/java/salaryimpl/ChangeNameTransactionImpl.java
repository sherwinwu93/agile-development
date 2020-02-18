package salaryimpl;

import lombok.Data;

/**
 * @author wusd
 * @date 2020/2/18 13:21
 */
public class ChangeNameTransactionImpl extends ChangeEmployeeTransactionImpl implements ChangeNameTransaction {
    protected String name;

    public ChangeNameTransactionImpl(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    public void change(Employee e) {
        e.setName(name);
    }
}
