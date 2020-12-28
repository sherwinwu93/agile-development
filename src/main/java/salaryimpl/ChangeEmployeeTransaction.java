package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 13:26
 */
public interface ChangeEmployeeTransaction extends Transaction {
    void change(Employee e);
}
