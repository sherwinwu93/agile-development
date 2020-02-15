package salaryimpl.hourly;

import salaryimpl.AddEmployeeTransactionImpl;
import salaryimpl.PaymentClassification;
import salaryimpl.PaymentSchedule;

/**
 * @author wusd
 * @date 2020/2/16 0:24
 */
public class AddHourlyEmployeeImpl extends AddEmployeeTransactionImpl implements AddHourlyEmployee {
    private Double hourlyRate;

    public AddHourlyEmployeeImpl(int empId, String name, String address, Double hourlyRate) {
        super(empId, name, address);
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
