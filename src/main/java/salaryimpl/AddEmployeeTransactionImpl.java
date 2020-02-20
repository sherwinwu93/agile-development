package salaryimpl;

/**
 * 增加雇员抽象类
 * @author wusd
 * @date 2020/2/15 22:48
 */
public abstract class AddEmployeeTransactionImpl implements AddEmployeeTransaction {
    protected int empId;
    protected String name;
    protected String address;

    public AddEmployeeTransactionImpl() {
    }

    public AddEmployeeTransactionImpl(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    /**
     * 使用Template Method方法
     * 调用抽象方法.
     */
    @Override
    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(empId, name, address);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        PayrollDatabaseImpl.instance.addEmployee(empId, e);
    }
}
