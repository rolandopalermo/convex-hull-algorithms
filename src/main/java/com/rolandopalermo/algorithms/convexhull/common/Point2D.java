package com.rolandopalermo.algorithms.convexhull.common;

public class Point2D extends Point {

    private double x;
    private double y;

    public Point2D() {
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double angle(double x, double y) {
        final double ax = getX();
        final double ay = getY();

        final double delta = (ax * x + ay * y) / Math.sqrt((ax * ax + ay * ay) * (x * x + y * y));

        if (delta > 1.0) {
            return 0.0;
        }
        if (delta < -1.0) {
            return 180.0;
        }

        return Math.toDegrees(Math.acos(delta));
    }

    public double angle(Point2D point) {
        return angle(point.getX(), point.getY());
    }

    public double angle(Point2D p1, Point2D p2) {
        final double x = getX();
        final double y = getY();

        final double ax = p1.getX() - x;
        final double ay = p1.getY() - y;
        final double bx = p2.getX() - x;
        final double by = p2.getY() - y;

        final double delta = (ax * bx + ay * by) / Math.sqrt((ax * ax + ay * ay) * (bx * bx + by * by));

        if (delta > 1.0) {
            return 0.0;
        }
        if (delta < -1.0) {
            return 180.0;
        }

        return Math.toDegrees(Math.acos(delta));
    }

    @Override public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Point2D) {
            Point2D other = (Point2D) obj;
            return getX() == other.getX() && getY() == other.getY();
        } else return false;
    }

    @Override public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }

}