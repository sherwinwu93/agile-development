package salaryimpl;

import salaryimpl.database.PayrollDatabase;
import salaryimpl.database.PayrollDatabaseImpl;

/**
 * @author wusd
 * @date 2020/2/15 22:48
 */
public abstract class AddEmployeeTransactionImpl implements AddEmployeeTransaction {
    protected int empId;
    protected String name;
    protected String address;
    public PayrollDatabase payrollDatabase = PayrollDatabaseImpl.getInstance();

    public AddEmployeeTransactionImpl() {
    }

    public AddEmployeeTransactionImpl(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    @Override
    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(empId, name, address);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        payrollDatabase.addEmployee(empId, e);
    }
}
