package command;

/**
 * @author wusd
 * @date 2020/1/18 15:20
 */
public class SleepCommand implements Command {
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;
    private ActiveObjectEngine engine = null;
    private Command wakeupCommand = null;

    public SleepCommand(long sleepTime, ActiveObjectEngine engine, Command wakeupCommand) {
        this.sleepTime = sleepTime;
        this.engine = engine;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (!started) {//检查之前是否已经执行,如果没有,就记录下开始时间.
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if (currentTime - startTime < sleepTime) {//如果没有过延迟时间,就把自己再加到ActiveObjectEngine
            engine.addCommand(this);
        } else {//如果过了延迟时间,就把wakeup命令对象加到ActiveObjectEngine中
            engine.addCommand(wakeupCommand);
        }
    }
}
