package lsp;
/**
 * @author wusd
 * @date 2020/1/15 23:06
 */
public class Shape {
    enum ShapeType {
        square, circle
    }
    ShapeType itsType;
    Shape(ShapeType itsType) {
        this.itsType = itsType;
    }

    /**
     * 违反了OCP.它必须知道Shape类所有的派生类,并且每次创建一个从Shape类派生的新类时都必须要更改它,
     * 甚至很多人肯定地认为这种函数结构简直是对良好设计的诅咒.
     * @param shape
     */
    static void drawSahpe(Shape shape) {
        if (shape.itsType == ShapeType.square)
            ((Square)shape).draw();
        else if (shape.itsType == ShapeType.circle)
            ((Circle)shape).draw();
    }
}
abstract class Circle extends Shape {
    Point itsCenter;
    double itsRadius;

    Circle() {
        super(ShapeType.circle);
    }
    abstract void draw();
}
abstract class Square extends Shape {
    Point itsTopLeft;
    double itsSide;

    Square() {
        super(ShapeType.square);
    }
    abstract void draw();
}
