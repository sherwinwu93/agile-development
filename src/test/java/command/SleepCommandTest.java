package command;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wusd
 * @date 2020/1/18 15:20
 */
public class SleepCommandTest {
    private boolean commandExecuted = false;

    /**
     * 创建SleepCommand对象,向SleepCommand构造函数中传1000ms的延迟,接着把SleepCommand对象放入ActiveObjectEngine中.
     * 调用run()后,它等待指定数目的毫秒
     */
    //todo debug
    @Test
    public void sleep() throws Exception {
        Command wakeup = new Command() {
            @Override
            public void execute() throws Exception {
                commandExecuted = true;
            }
        };
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = stop - start;
        assertTrue(String.format("SleepTime %d expected > 1000", sleepTime), sleepTime > 1000);
        assertTrue(String.format("SleepTime %d expected < 1100", sleepTime), sleepTime < 1100);
        assertTrue("Command Executed", commandExecuted);
    }
}