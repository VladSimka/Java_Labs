package by.vladsimonenko.tenth.variantB._main;


import by.vladsimonenko.tenth.variantB.action.LineAction;
import by.vladsimonenko.tenth.variantB.action.PointAction;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class with main method for variant B
 */
public class LineMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointAction pointAction = new PointAction();
        LineAction lineAction = new LineAction();
        List<Line2D> list = new ArrayList<>();
        int count = 0;
        while (true) {
            System.out.println("Введите количество отрезков:");
            count = scanner.nextInt();
            if (count > 0) {
                break;
            }
        }

        list = lineAction.enterLines(count);
        pointAction.findMinIntersectionPoint(list);
    }
}
