package salaryimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wusd
 * @date 2020/2/15 22:09
 */
public class PayrollDatabaseImpl implements PayrollDatabase {
    protected static Map<Integer, Employee> employees = new HashMap<>();
    protected static Map<Integer, Integer> empIds = new HashMap<>();
    // 使用singleton和monostate具有不必要复杂性的臭味
    public static PayrollDatabase instance = new PayrollDatabaseImpl();

    private PayrollDatabaseImpl() {
    }

    @Override
    public Employee getEmployee(int empId) {
        return employees.get(empId);
    }

    @Override
    public void addEmployee(int empId, Employee employee) {
        employees.put(empId, employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        employees.remove(empId);
    }

    @Override
    public void addUnionMember(int empId, Employee employee) {

    }

    @Override
    public void removeUnionMember(int empId) {

    }

    @Override
    public Employee getUnionMember(int empId) {
        return null;
    }

    @Override
    public List<Integer> getAllEmployeeIds(List<Integer> empIds) {
        return null;
    }

    @Override
    public void clear() {
        employees.clear();
    }
}
