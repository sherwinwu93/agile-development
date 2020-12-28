package ocp.order;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wusd
 * @date 2020/1/15 20:43
 */
public abstract class Shape {
    public abstract void draw();

    public abstract boolean precedes(Shape shape);

    public static void drawAllShapes(List<Shape> list) {
        list = list.stream().sorted(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                boolean precedes = o1.precedes(o2);
                if (precedes) return 0;
                else return -1;
            }
        }).collect(Collectors.toList());
        list.stream().forEach(Shape::draw);
    }
}

class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public boolean precedes(Shape shape) {
        if (shape instanceof Square) return true;
        else return false;
    }
}

class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public boolean precedes(Shape shape) {
        if (shape instanceof Circle) return true;
        else return false;
    }
}
