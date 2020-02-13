package singleton;

/**
 * @author wusd
 * @date 2020/2/13 20:40
 */
public class Singleton {
    private static Singleton theInstance = null;
    private Singleton() {}
    public static Singleton instance() {
        if (theInstance == null)
            theInstance = new Singleton();
        return theInstance;
    }
}
