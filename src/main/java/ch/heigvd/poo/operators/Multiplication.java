package ch.heigvd.poo.operators;

/**
 * @author Gruber Adam
 * @author Pittet Axel
 * Multiplication class implementing the Operator interface.
 * Provides a multiplication operation between two integers.
 */
public class Multiplication implements Operator {
    /**
     * Multiplies two integer operands.
     *
     * @param x First operand.
     * @param y Second operand.
     * @return Product of x and y.
     */
    @Override
    public int doOperation(int x, int y) {
        return x * y;
    }
}
