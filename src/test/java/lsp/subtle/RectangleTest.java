package lsp.subtle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wusd
 * @date 2020/1/15 23:35
 */
public class RectangleTest {

    @Test
    public void area() {
        Rectangle rectangle = new Rectangle();
        g(rectangle);
        Rectangle rectangle2 = new Square();
        g(rectangle2);
    }

    /**
     * Square 不能够替换 Rectangle,因此Square和Rectangle之间的关系是违反LSP的.
     * 有人认为g()不能假设宽和长是独立变化的.然后g()的编写者不会同意这种说法的.
     * 真正有趣的是,Square的编写者没有违反正方形的不变性.由于让Square从Rectangle派生,Square的编写者违反了Rectangle的不变性.
     * @param r
     */
    void g(Rectangle r) {
        r.setItsWidth(5);
        r.setItsHeight(4);
        assertEquals(20.0, r.area(), 0.1);
    }
}