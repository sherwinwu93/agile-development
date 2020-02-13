package singleton.monostate.usage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author wusd
 * @date 2020/2/14 0:42
 */
public class TurnstileTest {
    @Before
    public void setUp() {
        Turnstile t = new Turnstile();
        t.reset();
    }

    @Test
    public void init() {
        Turnstile t = new Turnstile();
        assertTrue(t.locked());
        assertTrue(!t.alarm());
    }

    @Test
    public void coin() {
        Turnstile t = new Turnstile();
        t.coin();
        Turnstile t1 = new Turnstile();
        assertTrue(!t1.locked());
        assertTrue(!t1.alarm());
        assertEquals(1, t1.coins());
    }

    @Test
    public void coinAndPass() {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();

        Turnstile t1 = new Turnstile();
        assertTrue(t1.locked());
        assertTrue(!t1.alarm());
        assertEquals("coins", 1, t1.coins());
    }

    @Test
    public void twoCoins() {
        Turnstile t = new Turnstile();
        t.coin();
        t.coin();

        Turnstile t1 = new Turnstile();
        assertTrue("unlocked", !t1.locked());
        assertEquals("coins", 1, t1.coins());
        assertEquals("refunds", 1, t1.refunds());
        assertTrue(!t1.alarm());
    }

    @Test
    public void pass() {
        Turnstile t = new Turnstile();
        t.pass();
        Turnstile t1 = new Turnstile();
        assertTrue("alarm", t1.alarm());
        assertTrue("locked", t1.locked());
    }

    @Test
    public void cancelAlarm() {
        Turnstile t = new Turnstile();
        t.pass();
        t.coin();
        Turnstile t1 = new Turnstile();
        assertTrue("alarm", !t1.alarm());
        assertTrue("locked", !t1.locked());
        assertEquals("coin", 1, t1.coins());
        assertEquals("refund", 0, t1.refunds());
    }

    @Test
    public void twoOperations() {
        Turnstile t = new Turnstile();
        t.coin();
        t.pass();
        t.coin();
        assertTrue("unlocked", !t.locked());
        assertEquals("coins", 2, t.coins());
        t.pass();
        assertTrue("locked", t.locked());
    }

}