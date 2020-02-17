package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/15 22:09
 */
public class PayrollDatabaseImpl extends PayrollDatabase {
    public static PayrollDatabase instance = new PayrollDatabaseImpl();
    private PayrollDatabaseImpl(){}
    @Override
    public Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }

    @Override
    public void addEmployee(int empId, Employee employee) {
        employeeMap.put(empId, employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        employeeMap.remove(empId);
    }

    @Override
    public void addUnionMember(int empId, Employee employee) {

    }

    @Override
    public Employee getUnionMember(int empId) {
        return null;
    }
}
