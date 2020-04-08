package com.rolandopalermo.algorithms.convexhull.graphics2D;

import com.rolandopalermo.algorithms.convexhull.common.Point2D;
import com.rolandopalermo.algorithms.convexhull.common.Turn;

public final class Utils {

    private Utils() {
    }

    public static int lowestPoint(Point2D[] points) {
        Point2D lowest = points[0];
        int index = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].getY() < lowest.getY() || (points[i].getY() == lowest.getY() && points[i].getX() > lowest.getX())) {
                lowest = points[i];
                index = i;
            }
        }
        return index;
    }

    public static Point2D[] swap(Point2D[] points, int index0, int index1) {
        Point2D temp = points[index0];
        points[index0] = points[index1];
        points[index1] = temp;
        return points;
    }

    public static Turn getTurn(Point2D p0, Point2D p1, Point2D p2) {
        double crossProduct = (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY());
        if (crossProduct > 0) {
            return Turn.COUNTER_CLOCKWISE;
        } else if (crossProduct < 0) {
            return Turn.CLOCKWISE;
        } else {
            return Turn.COLLINEAR;
        }
    }

}