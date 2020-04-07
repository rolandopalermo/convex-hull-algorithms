package com.rolandopalermo.algorithms.convexhull.common;

public interface ConvexHull<P extends Point> {

    P[] getVertices(P[] points);

}