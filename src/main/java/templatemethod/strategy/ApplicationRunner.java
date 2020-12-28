package templatemethod.strategy;

/**
 * @author wusd
 * @date 2020/2/10 21:56
 */
public class ApplicationRunner {
    private Application itsApplcaition = null;
    public ApplicationRunner(Application app) {
        itsApplcaition = app;
    }

    public void run() {
        itsApplcaition.init();
        while (!itsApplcaition.done())
            itsApplcaition.idle();
        itsApplcaition.cleanup();
    }
}
