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
    public Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    /**
     * 把memberId和Employee实例绑定起来,
     * 在changeUnaffiliatedTransaction清楚成员关系
     */
    @Override
    public void recordMembership(Employee e) {
        PayrollDatabaseImpl.instance.addUnionMember(memberId, e);
    }
}
