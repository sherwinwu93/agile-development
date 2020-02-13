package singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * @author wusd
 * @date 2020/2/13 20:39
 */
public class TestSimpleSingleton {
    @Test
    public void testCreateSingleton() {
        Singleton s = Singleton.instance();
        Singleton s2 = Singleton.instance();
        assertSame(s, s2);
    }

    @Test
    public void testNoPublicConstructors() throws Exception {
        Class clazz = Class.forName("singleton.Singleton");
        Constructor[] constructors = clazz.getConstructors();
        assertEquals("Singleton has public constructors.", 0, constructors.length);
    }
}
