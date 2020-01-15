package ocp.order;

/**
 * @author wusd
 * @date 2020/1/15 20:43
 */
public abstract class Shape {
    public abstract void draw();
    public abstract boolean precedes(Shape shape);
    public boolean operatorLess(Shape shape) {
        return precedes(shape);
    }
}
class Lessp {
    public boolean operator(Shape p, Shape q) {
        return p.operatorLess(q);
    }
    public void drawAllShapes(Li)
}
