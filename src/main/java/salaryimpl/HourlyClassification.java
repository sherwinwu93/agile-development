package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author wusd
 * @date 2020/2/16 0:29
 */
@Data
public class HourlyClassification implements PaymentClassification {
    protected Double hourlyRate;
    protected Map<DateTime, TimeCard> timeCards;

    public HourlyClassification(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void addTimeCard(TimeCard timeCard) {
    }
    public TimeCard getTimeCard(DateTime date) {
        return null;
    }

    @Override
    public double calculatePay(Paycheck pc) {
        double totalPay = 0;
        DateTime payPeriod = pc.getPayDate();
        Set<DateTime> set = timeCards.keySet();
        for (DateTime date : set) {
            TimeCard tc = timeCards.get(date);
            if (isInPayPeriod(tc, payPeriod))
                totalPay += calculatePayForTimeCard(tc);
        }
        return 0;
    }
    public boolean isInPayPeriod(TimeCard tc, DateTime payPeriod) {
        DateTime payPeriodEndDate = payPeriod;
        DateTime payPeriodStartDate = payPeriod.plusDays(-5);
        DateTime timeCardDate = tc.getDate();
        return timeCardDate.compareTo(payPeriodStartDate) >= 0 && timeCardDate.compareTo(payPeriodEndDate) <= 0;
    }
    public double calculatePayForTimeCard(TimeCard tc) {
        double hours = tc.getHours();
        double overtime = Math.max(0.0, hours - 8.0);
        double straightTime = hours - overtime;
        return straightTime * hourlyRate + overtime * hourlyRate * 1.5;
    }
}
