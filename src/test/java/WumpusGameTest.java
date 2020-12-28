import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 有意图的编程
 * @author wusd
 * @date 2020/1/13 23:55
 */
public class WumpusGameTest {

    @Test
    public void move() {
        WumpusGame g = new WumpusGame();
        g.connect(4.5, "E");
        g.setPlayerRoom(4);
        g.east();
        assertEquals(5, g.getPlayerRoom());
    }
}