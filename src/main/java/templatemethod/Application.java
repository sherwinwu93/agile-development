package templatemethod;

/**
 * @author wusd
 * @date 2020/1/19 23:51
 */
public abstract class Application {
    private boolean isDone = false;
    protected abstract void init();
    protected abstract void idle();
    protected abstract void cleanUp();

    protected void setDone() {
        isDone = true;
    }
    protected boolean done() {
        return isDone;
    }
    public void run() {
        init();
        while (!done())
            idle();
        cleanUp();
    }
}
