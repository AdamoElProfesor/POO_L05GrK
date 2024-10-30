package ch.heigvd.poo;
import ch.heigvd.poo.operators.*;


public class Main {
    public static void main(String[] args) {

        int MODULUS = 5;

        int[][] values1 = {{1}, {1, 2}};
        int[][] values2 = {{1, 4, 2, 3, 2}, {0, 1, 0, 6, 2}, {0, 0, 2, 0, 2}};

        Matrix matrix1 = new Matrix(3, 3, MODULUS, values1);
        Matrix matrix2 = new Matrix(3, 3,MODULUS + 1, values2);

        Operator operatorAdd = new Addition();
        Operator operatorSub = new Subtraction();
        Operator operatorMul = new Multiplication();


        System.out.println("The modulus is " + MODULUS); // Getter to get modulus ? 

        System.out.println("one :");
        System.out.println(matrix1);

        System.out.println("two :");
        System.out.println(matrix2);

        System.out.println("one + two:");
        System.out.println(matrix1.performOperation(matrix2, operatorAdd));

        System.out.println("one - two:");
        System.out.println(matrix1.performOperation(matrix2, operatorSub));

        System.out.println("one x two:");
        System.out.println(matrix1.performOperation(matrix2, operatorMul));
    }
}