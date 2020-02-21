package salaryimpl;

import org.joda.time.DateTime;

/**
 * 登记timeCard事务类
 * @author wusd
 * @date 2020/2/17 14:24
 */
public class TimeCardTransactionImpl implements TimeCardTransaction {
    //使用长整数代替,等需要时,再使用好的类库代替
    protected DateTime date;
    protected double hours;
    protected int empId;

    public TimeCardTransactionImpl(DateTime date, double hours, int empId) {
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    /**
     * 获取employee->类别->将TimeCard登记进入类别中
     */
    @Override
    public void execute() {
        Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
        if (e != null) {
            PaymentClassification pc = e.getClassification();
            if (pc instanceof HourlyClassificationImpl) {
                HourlyClassificationImpl hc = (HourlyClassificationImpl) pc;
                hc.addTimeCard(new TimeCard(date, hours));
            } else {
                //开始只使用简单的RuntimeException.在对实际异常有一定了解后.再回来创建有意义的异常类.
                throw new RuntimeException("not hourlyClassification");
            }
        } else {
            throw new RuntimeException("No such employee");
        }
    }
}
