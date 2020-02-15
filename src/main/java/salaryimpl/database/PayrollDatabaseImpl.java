package salaryimpl.database;

import salaryimpl.Employee;

/**
 * @author wusd
 * @date 2020/2/15 22:09
 */
public class PayrollDatabaseImpl extends PayrollDatabase {
    public static PayrollDatabase payrollDatabase = null;
    public static PayrollDatabase getInstance() {
        if (payrollDatabase == null) {
            payrollDatabase = new PayrollDatabaseImpl();
        }
        return payrollDatabase;
    }
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
}
