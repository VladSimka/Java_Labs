package by.vladsimonenko.thirdlab.variantB.action;

import by.vladsimonenko.thirdlab.variantB.entity.Polynom;


/**
 * Class - action that interacts with Polynom
 */
public class PolynomAction {


    /**
     * Method that performs the addition of two polynoms
     *
     * @param p first addend
     * @param q second addend
     * @return result of addition
     */
    public Polynom add(Polynom p, Polynom q) {
        int max = Math.max(p.getDegree(), q.getDegree());


        Polynom result = new Polynom(max);
        for (int i = 0; i < max; i++) {
            result.setCoefficient(Math.ceil((p.getCoefficient(i) + q.getCoefficient(i)) * 10) / 10, i);
        }
        return result;
    }

    /**
     * Method that performs the multiplication of two polynoms
     *
     * @param p first multiplier
     * @param q second multiplier
     * @return result of multiplication
     */
    public Polynom multiply(Polynom p, Polynom q) {

        Polynom result = new Polynom(p.getDegree() + q.getDegree());
        for (int i = 0; i < result.getDegree(); i++) {
            result.setCoefficient(0, i);
        }

        for (int i = 0; i < p.getDegree(); i++) {
            for (int j = 0; j < q.getDegree(); j++) {
                result.addToCoefficient(Math.ceil(p.getCoefficient(i) * q.getCoefficient(j) * 10) / 10, i + j);
            }
        }
        return result;
    }

    /**
     * Method that zeros out a polynom
     *
     * @param p polynom to null
     */
    public void clearPolynom(Polynom p) {
        for (int i = 0; i < p.getDegree(); i++) {
            p.setCoefficient(0, i);
        }
    }

}
