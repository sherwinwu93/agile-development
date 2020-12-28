package nullobject;

/**
 * @author wusd
 * @date 2020/2/14 14:24
 */
public class DB {
    /**
     * 为了测试,getEmployee方法只是返回Employee.NULL
     * @param name
     * @return
     */
    public static Employee getEmployee(String name) {
        return Employee.NULL;
    }
}
