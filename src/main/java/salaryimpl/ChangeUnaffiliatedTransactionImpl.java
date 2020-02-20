package salaryimpl;

/**
 * ChangeUnaffiliatedTransaction必须知道UnionAffiliation是讨厌的事情.
 * 如果在Affiliation中放入抽象方法recordMembership和eraseMembership就可以解决这个问题.
 * 会迫使UnionAffiliation和NoAffiliation要知道PayrollDatabase.同样不能令我满意.
 *
 * todo ??? 只是轻微地违反了OCP.系统中只有极少模块知道ChangeUnaffiliatedTransactionImpl.
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

    /**
     * 清楚成员关系
     * 判断雇员是否是协会成员.
     * 如果是:那么它就从UnionAffiliation中获取memberId,并清楚成员关系记录.
     */
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
