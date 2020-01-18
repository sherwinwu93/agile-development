package command;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wusd
 * @date 2020/1/18 15:20
 */
public class SleepCommandTest {
    private boolean commandExecuted = false;

    @Test
    public void execute() {
        Command wakeup = new Command() {
            @Override
            public void execute() throws Exception {
                commandExecuted = true;
            }
        };
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand();
        e.addCommand(c);
    }
}