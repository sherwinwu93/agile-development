package lsp.geometry;

import lsp.Point;

/**
 * @author wusd
 * @date 2020/1/16 23:07
 */
public abstract class LinearObject {
    private Point itsP1;
    private Point itsP2;
    public LinearObject(Point p1, Point p2) {
        itsP1 = p1;
        itsP2 = p2;
    }
    abstract double getSlope();
    abstract double getIntercept();

    abstract boolean isOn(Point p);

    public Point getItsP1() {
        return itsP1;
    }

    public Point getItsP2() {
        return itsP2;
    }
}

abstract class Line extends LinearObject {

    public Line(Point p1, Point p2) {
        super(p1, p2);
    }
    abstract boolean isOn(Point point);
}
abstract class LineSegment extends LinearObject {

    public LineSegment(Point p1, Point p2) {
        super(p1, p2);
    }
    abstract double getLength();
    abstract boolean isOn(Point point);
}
abstract class Ray extends LinearObject {

    public Ray(Point p1, Point p2) {
        super(p1, p2);
    }
    abstract boolean isOn(Point point);
}