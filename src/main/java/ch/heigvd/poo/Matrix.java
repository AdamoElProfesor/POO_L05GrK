package ch.heigvd.poo;
import ch.heigvd.poo.operators.Operator;

public class Matrix {
    static final int SEED = 1;
    private int N;
    private int M;
    private int mod;
    private int[][] values;

    public Matrix(int N, int M, int mod) {
        this.N = N;
        this.M = M;
        this.mod = mod;
        this.values = new int[N][M];

        java.util.Random random = new java.util.Random(SEED);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.values[i][j] = values[i][j] % mod;
            }
        }
    }

    public Matrix(int N, int M, int mod, int[][] values) {
        // Check if matrix given is null ?
        this.N = N;
        this.M = M;
        this.mod = mod;
        this.values = new int[N][M];

        int currentValuesN = values.length;
        int currentValuesM = values[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < currentValuesN && j < currentValuesM) this.values[i][j] = values[i][j] % mod;
                else this.values[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                str.append(values[i][j]).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public Matrix performOperation(Matrix other, Operator operator) {
        try {
            checkIfModsEquals(other);
            int biggestN = Math.max(this.N, other.N);
            int biggestM = Math.max(this.M, other.M);

            Matrix tempMatrix = new Matrix(biggestN, biggestM, mod, this.values);
            Matrix tempMatrix2 = new Matrix(biggestN, biggestM, mod, other.values);

            for (int i = 0; i < biggestN; i++) {
                for (int j = 0; j < biggestM; j++) {
                    tempMatrix.values[i][j] = Math.floorMod(operator.doOperation(tempMatrix.values[i][j], tempMatrix2.values[i][j]), mod);
                }
            }

            return tempMatrix;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void checkIfModsEquals(Matrix other) {
        if (this.mod != other.mod) {
            throw new RuntimeException("the modulus are not equal");
        }
    }
}
