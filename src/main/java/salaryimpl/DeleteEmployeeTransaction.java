package salaryimpl;

import lombok.Data;
import salaryimpl.database.PayrollDatabase;
import salaryimpl.database.PayrollDatabaseImpl;

/**
 * @author wusd
 * @date 2020/2/16 1:02
 */
@Data
public class DeleteEmployeeTransaction implements Transaction {
    protected int empId;

    public DeleteEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        PayrollDatabase payrollDatabase = PayrollDatabaseImpl.getInstance();
        payrollDatabase.deleteEmployee(empId);
    }
}
