package com.rolandopalermo.algorithms.convexhull.graphics2D;

import com.rolandopalermo.algorithms.convexhull.common.Point;

public interface ConvexHull<P extends Point> {

    P[] getVertices(P[] points);

}