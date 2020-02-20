package salaryimpl;

/**
 * 更改从属关系事务抽象类.
 * @author wusd
 * @date 2020/2/18 19:48
 */
public abstract class ChangeAffiliationTransactionImpl extends ChangeEmployeeTransactionImpl implements ChangeAffiliationTransaction{
    public ChangeAffiliationTransactionImpl(int empId) {
        super(empId);
    }
    @Override
    public void change(Employee e) {
        recordMembership(e);
        e.setAffiliation(getAffiliation());
    }
}
