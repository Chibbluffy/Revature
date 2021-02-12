package dev.wan.tdd;

public class GeoCalcImpl implements GeometryCalculator{
    @Override
    public double areaSquare(double length) {
        return length * length;
    }

    @Override
    public double areaCircle(double radius) {
        return radius*radius*Math.PI;
    }

    @Override
    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}
