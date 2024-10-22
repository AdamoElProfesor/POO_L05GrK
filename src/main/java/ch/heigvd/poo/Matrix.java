package ch.heigvd.poo;

public class Matrix {
    private int N;
    private int M;
    private int mod;
    private int[][] values;

    public Matrix( int N, int M, int mod ) {
    }
    public Matrix(int[][] values, int mod) {
    }

    @Override
    public String toString() {
        return "Method toString from matrix called";
    }

    public Matrix addition(Matrix other){
        return null;
    }

    public Matrix subtraction(Matrix other){
        return null;
    }

    public Matrix componentProduct(Matrix other){
        return null;
    }

    private boolean areModsEqual(int otherMod){
        return false;
    }
}
