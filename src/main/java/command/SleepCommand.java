package command;

/**
 * @author wusd
 * @date 2020/1/18 15:20
 */
public class SleepCommand implements Command {
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    @Override
    public void execute() throws Exception {
    }
}
