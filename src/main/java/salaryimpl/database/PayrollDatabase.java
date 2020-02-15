package salaryimpl.database;

import salaryimpl.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wusd
 * @date 2020/2/15 22:04
 */
public abstract class PayrollDatabase {
    public abstract Employee getEmployee(int empId);
    public abstract void addEmployee(int empId, Employee employee);
    public abstract void deleteEmployee(int empId);
    public void clear() {
        employeeMap.clear();
    }
    protected static Map<Integer, Employee> employeeMap = new HashMap<>();
}
