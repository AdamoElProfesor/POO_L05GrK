package ch.heigvd.poo.operators;

public class Multiplication implements Operator {
    @Override
    public int doOperation(int x, int y) {
        return x * y;
    }
}
