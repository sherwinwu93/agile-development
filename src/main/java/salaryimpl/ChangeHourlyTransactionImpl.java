package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 14:13
 */
public class ChangeHourlyTransactionImpl extends ChangeClassificationTransactionImpl implements ChangeHourlyTransaction {
    protected double hourlyRate;

    public ChangeHourlyTransactionImpl(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
