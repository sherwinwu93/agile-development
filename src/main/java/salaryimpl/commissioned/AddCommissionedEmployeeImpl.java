package salaryimpl.commissioned;

import salaryimpl.AddEmployeeTransaction;
import salaryimpl.AddEmployeeTransactionImpl;
import salaryimpl.PaymentClassification;
import salaryimpl.PaymentSchedule;

/**
 * @author wusd
 * @date 2020/2/16 0:39
 */
public class AddCommissionedEmployeeImpl extends AddEmployeeTransactionImpl implements AddCommissionedEmployee {
    protected Double salary;
    protected Double commissionRate;

    public AddCommissionedEmployeeImpl(int empId, String name, String address, Double salary, Double commissionRate) {
        super(empId, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BlweeklySchedule();
    }
}
