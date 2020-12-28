package command;

import java.util.LinkedList;

/**
 * @author wusd
 * @date 2020/1/18 15:12
 */
public class ActiveObjectEngine {
    LinkedList<Command> itsCommands = new LinkedList<>();
    public void addCommand(Command c) {
        itsCommands.add(c);
    }
    public void run() throws Exception {
        while (!itsCommands.isEmpty()) {
            Command command = itsCommands.pop();
            command.execute();
        }
    }
}
interface Command {
    void execute() throws Exception;
}
