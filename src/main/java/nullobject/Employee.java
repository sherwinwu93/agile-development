package nullobject;

import java.util.Date;

/**
 * @author wusd
 * @date 2020/2/14 14:25
 */
public interface Employee {
    boolean isTimeToPay(Date payDate);
    void pay();
    public static final Employee NULL = new Employee() {
        @Override
        public boolean isTimeToPay(Date payDate) {
            return false;
        }

        @Override
        public void pay() {

        }
    };
}
