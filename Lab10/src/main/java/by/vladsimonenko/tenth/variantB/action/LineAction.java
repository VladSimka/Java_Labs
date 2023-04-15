package by.vladsimonenko.tenth.variantB.action;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Class - action for line
 */
public class LineAction {

    /**
     * Method that finds intersection point of two lines
     * @param line1 first line
     * @param line2 second line
     * @return intersection point
     */
    public Optional<Point2D> getIntersectionPoint(Line2D line1, Line2D line2) {
        if (!line1.intersectsLine(line2)) {
            return Optional.empty();
        }

        double a1 = line1.getY2() - line1.getY1();
        double b1 = line1.getX1() - line1.getX2();
        double c1 = a1 * line1.getX1() + b1 * line1.getY1();

        double a2 = line2.getY2() - line2.getY1();
        double b2 = line2.getX1() - line2.getX2();
        double c2 = a2 * line2.getX1() + b2 * line2.getY1();

        double det = a1 * b2 - a2 * b1;

        if (det == 0) {
            return Optional.empty();
        }

        double x = (b2 * c1 - b1 * c2) / det;
        double y = (a1 * c2 - a2 * c1) / det;

        Point2D.Double intersection = new Point2D.Double(x, y);


        return Optional.of(intersection);

    }

    /**
     * Method that help to enter lines
     * @param count count of lines
     * @return list of lines
     */
    public List<Line2D> enterLines(int count) {
        List<Line2D> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            System.out.println("Введите точки, задающие отрезок №" + (i + 1));
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            result.add(new Line2D.Double(x1,y1,x2,y2));
        }
        return result;
    }


}
