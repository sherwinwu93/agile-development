package lsp;

/**
 * @author wusd
 * @date 2020/1/16 22:56
 */
public abstract class Line {
    private Point itsP1;
    private Point itsP2;

    public Line(Point itsP1, Point itsP2) {
        this.itsP1 = itsP1;
        this.itsP2 = itsP2;
    }
    public abstract double getSlope();
    public abstract double getIntercept();

    public abstract boolean isOn(Point p);

    public Point getItsP1() {
        return itsP1;
    }

    public Point getItsP2() {
        return itsP2;
    }
}
abstract class LineSegment extends Line {

    public LineSegment(Point itsP1, Point itsP2) {
        super(itsP1, itsP2);
    }
    public abstract double getLength();
    public abstract boolean isOn(Point p);
}
