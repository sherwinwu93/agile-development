package templateMethod.strategy;

/**
 * @author wusd
 * @date 2020/2/10 22:02
 */
public interface Application {
    void init();

    void idle();

    void cleanup();

    boolean done();
}
