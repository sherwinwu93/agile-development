package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/17 15:02
 */
public class ServiceChargeTransactionImpl implements ServiceChargeTransaction {
    protected int memberId;
    protected DateTime date;
    private double charge;

    public ServiceChargeTransactionImpl(int memberId, DateTime date, double charge) {
        this.memberId = memberId;
        this.date = date;
        this.charge = charge;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabaseImpl.instance.getUnionMember(memberId);
        Affiliation af = e.getAffiliation();
        if (af instanceof UnionAffiliation) {
            UnionAffiliation uaf = (UnionAffiliation) af;
            uaf.addServiceCharge(date, charge);
        }
    }
}
