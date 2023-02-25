package by.vladsimonenko.thirdlab.variantB.entity;

import java.util.Arrays;

/**
 * Class - entity that which stores information about the polynom such as coefficients and degree
 */
public class Polynom {
    private int degree;
    private double[] coefficients;

    public Polynom(int degree) {
        this.degree = degree;
        coefficients = new double[degree];
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = Math.ceil((Math.random() * 20 - 10) * 10) / 10;
        }
    }

    public int getDegree() {
        return degree;
    }

    public void setCoefficient(double coefficient, int position) {
        if (position >= 0 && position < degree) {
            this.coefficients[position] = coefficient;
        }
    }

    public void addToCoefficient(double coefficient, int position) {
        if (position >= 0 && position < degree) {
            this.coefficients[position] += coefficient;
        }
    }

    public double getCoefficient(int position) {
        if (position >= 0 && position < degree) {
            return coefficients[position];
        }
        return 0;
    }


    @Override
    public String toString() {
        int numberNotNull = 0;

        StringBuilder result = new StringBuilder();
        for (double coefficient : coefficients) {
            if (coefficient != 0) {
                numberNotNull++;
            }
        }

        if (numberNotNull != 0) {

            if (coefficients[0] != 0) {
                result.append(coefficients[0]);
            }
            for (int i = 1; i < coefficients.length; i++) {
                if (coefficients[i] > 0) {
                    if (coefficients[i] != 1) {
                        result.append("+").append(coefficients[i]).append("X^").append(i);

                    } else {
                        result.append("+X^").append(i);
                    }
                } else if (coefficients[i] != 0) {
                    if (coefficients[i] != -1) {
                        result.append(coefficients[i]).append("X^").append(i);
                    } else {
                        result.append("-X^").append(i);
                    }

                }


            }

            return result.toString();
        } else {
            return "0";
        }
    }
}
