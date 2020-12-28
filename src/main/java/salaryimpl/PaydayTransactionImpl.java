package salaryimpl;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 发薪日事务类
 * @author wusd
 * @date 2020/2/19 12:07
 */
@Data
public class PaydayTransactionImpl implements PaydayTransaction {
    protected DateTime date;
    protected Map<Integer, Paycheck> paychecks;

    public PaydayTransactionImpl(DateTime date) {
        this.date = date;
    }

    /**
     * 考虑登记的概念.计算出支付数额会登记支付消息.
     * 但是开发人员不应做商务决策
     *
     * 遍历了数据库中所有的Employee对象,询问每一个Employee对象本次操作中指定的日期是否为它的支付日期.
     * 如果是,就为该Employee对象创建一个新的支付支票并让Employee对象去填写该支付支票.
     */
    @Override
    public void execute() {
        List<Integer> empIds = new ArrayList<>();
        empIds = PayrollDatabaseImpl.instance.getAllEmployeeIds(empIds);

        for (int i = 0; i < empIds.size(); i++) {
            int empId = empIds.get(i);
            Employee e = PayrollDatabaseImpl.instance.getEmployee(empId);
            if (e != null) {
                if (e.isPayDate(e.getPayDate())) {
//                    Paycheck pc = new Paycheck(e.getPayDate());
                    Paycheck pc = new Paycheck(e.getPayPeriodStartDate(date), date);
                    paychecks.put(empId, pc);
                    e.payday(pc);
                }
            }
        }

    }

    @Override
    public Paycheck getPaycheck(int empId) {
        return paychecks.get(empId);
    }
}
