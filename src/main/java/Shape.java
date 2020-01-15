import java.awt.*;
import java.util.List;

/**
 * @author wusd
 * @date 2020/1/15 19:33
 */
public class Shape {
    ShapeType itsType;

    public static void main(String[] args) {

    }

    public static void drawAllShapes(List<Shape> list, int n) {
        for (int i = 0; i < n; i++) {
            Shape s = list.get(i);
            switch (s.itsType) {
                case square:
                    drawSquare((Square) s);
                    break;
                case circle:
                    drawCircle((Circle) s);
                    break;
            }
        }
    }

    public static void drawSquare(Square square) {
    }

    public static void drawCircle(Circle circle) {
    }
}

enum ShapeType {
    circle, square
}

class Circle extends Shape {
    ShapeType itsType;
    double itsRadius;
    Point itsCenter;
}

class Square extends Shape {
    ShapeType itsType;
    double itsSide;
    Point itsTopLeft;
}
