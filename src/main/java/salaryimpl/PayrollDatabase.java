package salaryimpl;

import java.util.List;
import java.util.Set;

/**
 * 数据库是实现细节.尽可能地推迟有关这些细节的决策
 * @author wusd
 * @date 2020/2/15 22:04
 */
public interface PayrollDatabase {
    Employee getEmployee(int empId);
    void addEmployee(int empId, Employee employee);
    void deleteEmployee(int empId);
    void addUnionMember(int empId, Employee employee);
    void removeUnionMember(int empId);
    Employee getUnionMember(int empId);
    List<Integer> getAllEmployeeIds(List<Integer> empIds);
    void clear();
}
