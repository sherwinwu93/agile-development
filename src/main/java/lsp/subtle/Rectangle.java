package lsp.subtle;

import lombok.Data;
import lsp.Point;

/**
 * @author wusd
 * @date 2020/1/15 23:25
 */
public class Rectangle {
    private Point itsTopLeft;
    private double itsWidth;
    private double itsHeight;

    public double getItsWidth() {
        return itsWidth;
    }

    public void setItsWidth(double itsWidth) {
        this.itsWidth = itsWidth;
    }

    public double getItsHeight() {
        return itsHeight;
    }

    public void setItsHeight(double itsHeight) {
        this.itsHeight = itsHeight;
    }
    public double area() {
        return this.itsWidth * this.itsHeight;
    }
}
