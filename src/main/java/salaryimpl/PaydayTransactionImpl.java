package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * 发薪日事务类
 * @author wusd
 * @date 2020/2/19 12:07
 */
@Data
public class PaydayTransactionImpl implements PaydayTransaction {
    protected DateTime date;

    public PaydayTransactionImpl(DateTime date) {
        this.date = date;
    }

    @Override
    public void execute() {
        List<Integer> empIds = new ArrayList<>();
        PayrollDatabaseImpl.instance.getAllEmployeeIds(empIds);

        for (int i = 0; i < empIds.size(); i++) {
            int empId = empIds.get(i);
            Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
            if (e != null) {
                if (e.isPayDate(e.getPayDate())) {
//                    Paycheck pc = new Paycheck(e.getPayDate());
                    Paycheck pc = new Paycheck(e.getPayPeriodStartDate(date), date);
                    e.payday(pc);
                }
            }
        }

    }

    @Override
    public Paycheck getPaycheck(int empId) {
        return null;
    }
}
