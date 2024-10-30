package ch.heigvd.poo;

import ch.heigvd.poo.operators.Operator;

/**
 * Matrix class for handling matrices with operations constrained by a modulus.
 * Provides methods for creating matrices, displaying them, and performing
 * operations with other matrices.
 */
public class Matrix {
    static final int SEED = 1;
    private int N;
    private int M;
    private int mod;
    private int[][] values;

    /**
     * Constructor that generates a matrix with random values.
     *
     * @param N   Number of rows in the matrix.
     * @param M   Number of columns in the matrix.
     * @param mod Modulus used for constraining values.
     */
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

    /**
     * Constructor that generates a matrix from provided values.
     * Values will be constrained by the modulus.
     *
     * @param N      Number of rows in the matrix.
     * @param M      Number of columns in the matrix.
     * @param mod    Modulus used for constraining values.
     * @param values 2D array of values to initialize the matrix.
     *               If the provided array has fewer rows or columns,
     *               missing values are replaced by 0.
     */
    public Matrix(int N, int M, int mod, int[][] values) {
        this.N = N;
        this.M = M;
        this.mod = mod;
        this.values = new int[N][M];

        int currentValuesN = values.length;

        for (int i = 0; i < N; i++) {

            if (i < currentValuesN) {
                int currentValuesM = values[i].length;
                for (int j = 0; j < M; j++) {

                    if (j < currentValuesM) this.values[i][j] = values[i][j] % mod;
                    else this.values[i][j] = 0;
                }
            } else {

                for (int j = 0; j < M; j++) {
                    this.values[i][j] = 0;
                }
            }
        }
    }

    /**
     * Generates a string representation of the matrix.
     *
     * @return String representing the matrix in a grid format.
     */
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

    /**
     * Performs an element-wise operation between this matrix and another matrix
     * using a specified operator, constrained by the modulus.
     *
     * @param other    The other matrix to operate with.
     * @param operator The operation to perform, represented by the Operator interface.
     * @return A new Matrix containing the result of the operation.
     * Returns null if the operation fails due to incompatible matrices.
     */
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

    /**
     * Checks if the modulus of this matrix is equal to the modulus of another matrix.
     *
     * @param other The other matrix to compare with.
     * @throws RuntimeException If the modulus of the matrices are not equal.
     */
    private void checkIfModsEquals(Matrix other) {
        if (this.mod != other.mod) {
            throw new RuntimeException("The modulus are not equal");
        }
    }
}
