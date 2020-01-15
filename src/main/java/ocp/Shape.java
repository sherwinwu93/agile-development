package ocp;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author wusd
 * @date 2020/1/15 19:39
 */
public abstract class Shape {
    public abstract void draw();

    public static void main(String[] args) {

    }
    public static void drawAllShapes(List<Shape> list) {
        Iterator<Shape> iterator = list.iterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            shape.draw();
        }
    }
}
class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }
}
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

