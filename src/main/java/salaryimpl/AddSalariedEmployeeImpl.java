package salaryimpl;

/**
 * 增加月薪员工具体实现类
 * @author wusd
 * @date 2020/2/15 23:53
 */
public class AddSalariedEmployeeImpl extends AddEmployeeTransactionImpl implements AddSalariedEmployee {
    protected Double salary;

    public AddSalariedEmployeeImpl(int empId, String name, String address, Double salary) {
        super(empId, name, address);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
