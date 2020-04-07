package com.rolandopalermo.algorithms.convexhull;

import com.rolandopalermo.algorithms.convexhull.common.ConvexHull;
import com.rolandopalermo.algorithms.convexhull.common.Point2D;
import com.rolandopalermo.algorithms.convexhull.graphics2D.GiftWrapping;

public class Main {

    public static void main(String[] args) {
        int length = 5;
        Point2D[] points = new Point2D[length];

        points[0] = new Point2D(3, 4);
        points[1] = new Point2D(5, 2);
        points[2] = new Point2D(4, 4);
        points[3] = new Point2D(2, 1);
        points[4] = new Point2D(5, 5);

        ConvexHull<Point2D> ch = new GiftWrapping();
        Point2D[] vertices = ch.getVertices(points);

        for (int i = 0; i < vertices.length; i++) {
            System.out.println(vertices[i]);
        }
    }

}