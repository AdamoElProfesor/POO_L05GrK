package ch.heigvd.poo;
import java.util.Random;

public class Matrix {
    private int N;
    private int M;
    private int mod;
    private int[][] values;

    public Matrix( int N, int M, int mod ) {
        this.N = N;
        this.M = M;
        this.mod = mod;
        this.values = new int[N][M];

        java.util.Random random = new java.util.Random();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                this.values[i][j] = random.nextInt(mod);
            }
        }
    }
    public Matrix(int[][] values, int mod) {
        // Check if matrix given is null ?
        this.N = values.length;
        this.M = values[0].length;
        this.mod = mod;
        this.values = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                this.values[i][j] = values[i][j] % mod;
            }
        }
    }

    @Override
    public String toString() {
        String str = new String("");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                str += values[i][j] + " ";
            }
            str += "\n";
        }
        return str;
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
