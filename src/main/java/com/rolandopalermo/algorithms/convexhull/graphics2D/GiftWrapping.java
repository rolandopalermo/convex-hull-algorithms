package com.rolandopalermo.algorithms.convexhull.graphics2D;

import com.rolandopalermo.algorithms.convexhull.common.Point2D;

import java.util.Stack;

import static com.rolandopalermo.algorithms.convexhull.graphics2D.Utils.lowestPoint;
import static com.rolandopalermo.algorithms.convexhull.graphics2D.Utils.swap;

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

}