package by.vladsimonenko.tenth.variantB.action;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

/**
 * Class - action for points
 */
public class PointAction {

    /**
     * Method that helps to find intersection point with minimal x
     * @param lines list of lines
     */
    public void findMinIntersectionPoint(List<Line2D> lines) {
        TreeMap<Double, Point2D> intersections = new TreeMap<>();

        LineAction action = new LineAction();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                Line2D line1 = lines.get(i);
                Line2D line2 = lines.get(j);

                Optional<Point2D> intersectionPoint = action.getIntersectionPoint(line1, line2);
                intersectionPoint.ifPresent(point2D -> intersections.put(point2D.getX(), point2D));
            }
        }

        if (intersections.isEmpty()) {
            System.out.println("Точек пересечения не обнаружено");
        } else {
            Point2D minAbscissaIntersection = intersections.firstEntry().getValue();
            double xResult = minAbscissaIntersection.getX();
            double yResult = minAbscissaIntersection.getY();
            System.out.printf("Точка пересечения с минимальной абсциссой: (%.2f, %.2f)%n",
                    xResult, yResult);
        }


    }
}
