package com.rolandopalermo.algorithms.convexhull.graphics2D;

import com.rolandopalermo.algorithms.convexhull.common.ConvexHull;
import com.rolandopalermo.algorithms.convexhull.common.Point2D;

import java.util.Stack;

public class GiftWrapping implements ConvexHull<Point2D> {

    public Point2D[] getVertices(Point2D[] points) {
        Point2D p, q;
        Stack<Point2D> verticesList = new Stack<>();

        points = swap(points, 0, lowestPoint(points));
        points = swap(points, 1, lowestPolarAngle(points, points[0]));

        p = points[0];
        q = points[1];

        verticesList.push(p);

        int index = 0;

        while (!points[0].equals(q)) {
            verticesList.push(q);
            double minorPolarAngle = 180D;
            for (int i = 0; i < points.length; i++) {
                if (!points[i].equals(q)) {
                    double angle = 180D - q.angle(p, points[i]);
                    if (angle < minorPolarAngle) {
                        minorPolarAngle = angle;
                        index = i;
                    }
                }
            }
            p = q;
            q = points[index];
        }

        return verticesList.stream().toArray(Point2D[]::new);
    }

    private int lowestPolarAngle(Point2D[] points, Point2D lowestPoint) {
        int index = 0;
        double minorPolarAngle = 180D;
        for (int i = 1; i < points.length; i++) {
            double angle = lowestPoint.angle(points[i]);
            if (angle < minorPolarAngle) {
                minorPolarAngle = angle;
                index = i;
            }
        }
        return index;
    }

    private int lowestPoint(Point2D[] points) {
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

    private Point2D[] swap(Point2D[] points, int index0, int index1) {
        Point2D temp = points[index0];
        points[index0] = points[index1];
        points[index1] = temp;
        return points;
    }

}