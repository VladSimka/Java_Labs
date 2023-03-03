package by.vladsimonenko.fourthlab.variantA.entity;

import java.util.Objects;

/**
 * Class that represent the simple fraction entity
 */
public class SimpleFraction {


    private Number numerator;
    private Number denominator;

    public SimpleFraction(int numerator, int denominator) {
        this.numerator = new Number(numerator);
        this.denominator = new Number(denominator);
    }

    public SimpleFraction() {
        super();
    }

    public int getNumerator() {
        return numerator.getNumber();
    }

    public int getDenominator() {
        return denominator.getNumber();
    }

    public void setNumerator(int numerator) {
        this.numerator.setNumber(numerator);
    }

    public void setDenominator(int denominator) {
        this.denominator.setNumber(denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleFraction that = (SimpleFraction) o;

        if (!Objects.equals(numerator, that.numerator)) return false;
        return Objects.equals(denominator, that.denominator);
    }


    @Override
    public int hashCode() {
        int result = numerator != null ? numerator.hashCode() : 0;
        result = 31 * result + (denominator != null ? denominator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

