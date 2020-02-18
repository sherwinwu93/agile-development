package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 22:17
 */
public class ChangeUnaffiliatedTransactionImpl extends ChangeAffiliationTransactionImpl implements ChangeUnaffiliatedTransaction {
    public ChangeUnaffiliatedTransactionImpl(int empId) {
        super(empId);
    }

    @Override
    public Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    public void recordMembership(Employee e) {
        Affiliation af = e.getAffiliation();
        if (af instanceof UnionAffiliation) {
            UnionAffiliation uf = (UnionAffiliation) af;
            int memberId = uf.getMemberId();
            PayrollDatabaseImpl.instance.removeUnionMember(memberId);
        }
    }
}
