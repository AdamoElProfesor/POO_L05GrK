package ch.heigvd.poo.operators;

/**
 * @author Gruber Adam
 * @author Pittet Axel
 * Subtraction class implementing the Operator interface.
 * Provides a subtraction operation between two integers.
 */
public class Subtraction implements Operator {
    /**
     * Subtracts the second operand from the first operand.
     *
     * @param x First operand.
     * @param y Second operand.
     * @return Difference between x and y.
     */
    @Override
    public int doOperation(int x, int y) {
        return x - y;
    }
}
