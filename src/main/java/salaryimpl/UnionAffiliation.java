package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/17 14:57
 */
@Data
public class UnionAffiliation implements Affiliation {
    protected int memberId;
    protected double charge;
    protected ServiceCharge serviceCharge;
    protected double dues;

    public UnionAffiliation(int memberId, double charge) {
        this.memberId = memberId;
        this.charge = charge;
    }

    public ServiceCharge getServiceCharge(DateTime date) {
        return null;
    }
    public void addServiceCharge(DateTime date, double charge) {

    }
}
