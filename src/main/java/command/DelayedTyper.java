package command;

/**
 * 延时类型
 * @author wusd
 * @date 2020/1/19 23:03
 */
public class DelayedTyper implements Command {
    private long itsDelay;
    private char itsChar;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;

    public DelayedTyper(long itsDelay, char itsChar) {
        this.itsDelay = itsDelay;
        this.itsChar = itsChar;
    }

    @Override
    public void execute() throws Exception {
        System.out.print(itsChar);
        if (!stop)
            delayAndRepeat();
    }
    private void delayAndRepeat() throws CloneNotSupportedException {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }

    public static void main(String[] args) throws Exception {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));
        Command stopCommand = new Command() {
            @Override
            public void execute() throws Exception {
                stop = true;
            }
        };
        engine.addCommand(new SleepCommand(20000, engine, stopCommand));
        engine.run();
    }
}
