package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Map;
import java.util.Set;

/**
 * 钟点工支付类别
 * 用来确定TimeCards和SalesReceipts是否在支付期间的两个函数已经被合入基类PaymentClassification
 * @author wusd
 * @date 2020/2/16 0:29
 */
@Data
public class HourlyClassificationImpl implements HourlyClassification {
    protected Double hourlyRate;
    protected Map<DateTime, TimeCard> timeCards;

    public HourlyClassificationImpl(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void addTimeCard(TimeCard timeCard) {
    }
    public TimeCard getTimeCard(DateTime date) {
        return null;
    }

    /**
     * 简单的遍历每个事件卡,检查是否在支付期内.若是,就计算所代表的薪水
     * @param pc
     * @return
     */
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
        return totalPay;
    }

    /**
     * 在支付周期内
     * @param tc
     * @param payPeriod
     * @return
     */
    public boolean isInPayPeriod(TimeCard tc, DateTime payPeriod) {
        DateTime payPeriodEndDate = payPeriod;
        DateTime payPeriodStartDate = payPeriod.plusDays(-5);
        DateTime timeCardDate = tc.getDate();
        return timeCardDate.compareTo(payPeriodStartDate) >= 0 && timeCardDate.compareTo(payPeriodEndDate) <= 0;
    }
    private double calculatePayForTimeCard(TimeCard tc) {
        double hours = tc.getHours();
        double overtime = Math.max(0.0, hours - 8.0);
        double straightTime = hours - overtime;
        return straightTime * hourlyRate + overtime * hourlyRate * 1.5;
    }
}
