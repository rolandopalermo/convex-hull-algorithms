package com.rolandopalermo.algorithms.convexhull.graphics2D;

import com.rolandopalermo.algorithms.convexhull.common.Point2D;
import com.rolandopalermo.algorithms.convexhull.common.Turn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import static com.rolandopalermo.algorithms.convexhull.graphics2D.Utils.getTurn;
import static com.rolandopalermo.algorithms.convexhull.graphics2D.Utils.lowestPoint;
import static com.rolandopalermo.algorithms.convexhull.graphics2D.Utils.swap;

public class GrahamScan implements ConvexHull<Point2D> {

    @Override
    public Point2D[] getVertices(Point2D[] points) {
        Stack<Point2D> verticesList = new Stack<>();

        points = swap(points, 0, lowestPoint(points));
        final Point2D lowestPoint = points[0];

        List<Point2D> pointsList = Arrays.asList(points);
        Collections.sort(pointsList, Comparator.comparingDouble(p -> p.angle(lowestPoint)));
        points = pointsList.stream().toArray(Point2D[]::new);

        verticesList.push(points[0]);
        verticesList.push(points[1]);
        verticesList.push(points[2]);

        int index = 3;

        while (index < points.length) {
            Point2D pop = verticesList.pop();
            if (getTurn(verticesList.peek(), pop, points[index]) == Turn.COUNTER_CLOCKWISE) {
                verticesList.push(pop);
                verticesList.push(points[index]);
                index++;
            }
        }

        return verticesList.stream().toArray(Point2D[]::new);
    }

}