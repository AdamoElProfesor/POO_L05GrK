package ch.heigvd.poo;

public class Main {
    public static void main(String[] args) {
        int MODULUS = 5;

        int[][] values1 = {{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}};
        int[][] values2 = {{1, 4, 2, 3, 2}, {0, 1, 0, 4, 2}, {0, 0, 2, 0, 2}};

        Matrix matrix1 = new Matrix(values1, MODULUS);
        Matrix matrix2 = new Matrix(values2, MODULUS);

        System.out.println("The modulus is " + MODULUS); // Getter to get modulus ? 

        System.out.println("one :");
        System.out.println(matrix1);

        System.out.println("two :");
        System.out.println(matrix2);

        System.out.println("one + two:");
        System.out.println(matrix1.addition(matrix2));

        System.out.println("one - two:");
        System.out.println(matrix1.subtraction(matrix2));

        System.out.println("one x two:");
        System.out.println(matrix1.componentProduct(matrix2));
    }
}