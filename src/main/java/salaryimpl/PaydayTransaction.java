package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/19 12:07
 */
public interface PaydayTransaction extends Transaction {
    Paycheck getPaycheck(int empId);
}
