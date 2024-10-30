package ch.heigvd.poo.operators;

/**
 * Addition class implementing the Operator interface.
 * Provides an addition operation between two integers.
 */
public class Addition implements Operator {
    /**
     * Adds two integer operands.
     *
     * @param x First operand.
     * @param y Second operand.
     * @return Sum of x and y.
     */
    @Override
    public int doOperation(int x, int y) {
        return x + y;
    }
}
