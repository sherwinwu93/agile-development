package salaryimpl;

import org.joda.time.DateTime;

/**
 * @author wusd
 * @date 2020/2/17 14:24
 */
public class TimeCardTransactionImpl implements TimeCardTransaction {
    protected DateTime date;
    protected double hours;
    private int empId;

    public TimeCardTransactionImpl(DateTime date, double hours, int empId) {
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        if (e != null) {
            PaymentClassification pc = e.getClassification();
            if (pc instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(date, hours));
            } else {
                System.err.println("not hourlyClassification");
            }
        } else {
            System.err.println("No such employee");
        }
    }
}
