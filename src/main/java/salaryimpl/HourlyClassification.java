package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/21 11:23
 */
public interface HourlyClassification extends PaymentClassification {
    void addTimeCard(TimeCard tc);
    double calculatePay(Paycheck pc);
    TimeCard getTimeCard(DateTime date);

    /**
     * 需要知道支付期的起始和终止日期
     * @param tc
     * @param date
     * @return
     */
    boolean isInPayPeriod(TimeCard tc, DateTime date);
}
