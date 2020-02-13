package singleton.monostate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author wusd
 * @date 2020/2/14 0:23
 */
public class TestMonostate {
    @Test
    public void testInstance() {
        Monostate m = new Monostate();
        for (int x = 0; x < 10; x++) {
            m.setX(x);
            assertEquals(x, m.getX());
        }
    }
    @Test
    public void testInstancesBehaveAsOne() {
        Monostate m1 = new Monostate();
        Monostate m2 = new Monostate();
        for (int x = 0; x < 10; x++) {
            m1.setX(x);
            assertEquals(x, m2.getX());
        }
    }
}
