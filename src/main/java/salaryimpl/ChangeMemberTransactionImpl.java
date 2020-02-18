package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 19:30
 */
public class ChangeMemberTransactionImpl extends ChangeAffiliationTransactionImpl implements ChangeMemberTransaction {
    protected int memberId;
    protected double dues;

    public ChangeMemberTransactionImpl(int empId, int memberId, double dues) {
        super(empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    public void execute() {

    }

    @Override
    public Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    public void recordMembership(Employee e) {
        PayrollDatabaseImpl.instance.addUnionMember(memberId, e);
    }

    @Override
    public void change(Employee e) {

    }
}
