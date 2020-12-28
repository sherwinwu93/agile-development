package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

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

    /**
     * 计算雇员的会费.
     * @param pc
     * @return
     */
    @Override
    public double calculateDeductions(Paycheck pc) {
        double totalDues = 0;
        int fridays = numberOfFridaysInPayPeriod(pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate());
        totalDues = dues * fridays;
        return totalDues;
    }

    public int numberOfFridaysInPayPeriod(DateTime payPeriodStart, DateTime payPeriodEnd) {
        int fridays = 0;
        for (DateTime day = payPeriodStart ; day.compareTo(payPeriodEnd) <= 0; day = day.plusDays(1)) {
            if (day.getDayOfWeek() == 5) {
                fridays++;
            }
        }
        return fridays;
    }
}
