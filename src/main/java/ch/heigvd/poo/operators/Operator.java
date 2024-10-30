package ch.heigvd.poo.operators;

/**
 * Operator interface for defining a mathematical operation between two integers.
 */
public interface Operator {
    /**
     * Executes a specific operation on two integer operands.
     *
     * @param x First operand.
     * @param y Second operand.
     * @return Result of the operation between x and y.
     */
    int doOperation(int x, int y);
}
