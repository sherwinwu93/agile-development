package salaryimpl;

/**
 * @author wusd
 * @date 2020/2/18 19:46
 */
public interface ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    Affiliation getAffiliation();
    void recordMembership(Employee e);
}
