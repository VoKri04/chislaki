package org.example;

import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixInversionTest {
    private int N = 3;
    private double ALPHA = 1.;
    private double BETA  = 1.e+3;

    private static final double EPSILON = 1e-6; // Допустимая погрешность

    // Тест для проверки корректного обращения 3x3 матрицы
    @Test
    void testInverseMatrix3x3() {
        double[][] matrix = {
                {3, 2, 1},
                {-2, 3, 1},
                {4, 4, 3}
        };

        double[][] expectedInverse = {
                {5.0 / 15, -2.0 / 15, -1.0 / 15},
                {10.0 / 15, 5.0 / 15, -5.0 / 15},
                {-20.0 / 15, -4.0 / 15, 13.0 / 15}
        };

        double[][] actualInverse = MatrixInversion.inverseMatrix(matrix);

        // Проверяем, что все элементы соответствуют ожидаемым
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expectedInverse[i], actualInverse[i], EPSILON);
        }
    }
    @Test
    void testInverseMatrix3x31() {
        double[][] matrix = {
                {3, 5, -2},
                {1, -3, 2},
                {6, 7, -3}
        };

        double[][] expectedInverse = {
                {-5.0 / 10, 1.0 / 10, 4.0 / 10},
                {15.0 / 10, 3.0 / 10, -8.0 / 10},
                {25.0 / 10, 9.0 / 10, -14.0 / 10}
        };

        double[][] actualInverse = MatrixInversion.inverseMatrix(matrix);
        MatrixInversion.printMatrixInverse(actualInverse);

        // Проверяем, что все элементы соответствуют ожидаемым
        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expectedInverse[i], actualInverse[i], EPSILON);
        }
    }
    // Тест на 2x2 матрицу
    @Test
    void testInverseMatrix2x2() {
        double[][] matrix = {
                {4, 7},
                {2, 6}
        };

        double[][] expectedInverse = {
                {0.6, -0.7},
                {-0.2, 0.4}
        };

        double[][] actualInverse = MatrixInversion.inverseMatrix(matrix);

        MatrixInversion.printMatrixInverse(actualInverse);

        for (int i = 0; i < matrix.length; i++) {
            assertArrayEquals(expectedInverse[i], actualInverse[i], EPSILON);
        }
    }

    // Тест для единичной матрицы (обратная должна быть такой же)
    @Test
    void testInverseIdentityMatrix() {
        double[][] identity = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        double[][] actualInverse = MatrixInversion.inverseMatrix(identity);

        for (int i = 0; i < identity.length; i++) {
            assertArrayEquals(identity[i], actualInverse[i], EPSILON);
        }
    }
    @Test
    void testInverseMatrixCorrect() {
        double[][] matrix = {
                {3, 2, 1},
                {-2, 3, 1},
                {4, 4, 3}
        };

        double[][] matrixInverse = MatrixInversion.inverseMatrix(matrix);
        int n = 3;
        double[][] c = new double[n][];
        for (int i = 0; i < 3; i++)	c[i] = new double[n];
        Gen g = new Gen();
        MatrixInversion.printMatrixInverse(matrixInverse);
        System.out.println();
        g.matr_mul(matrix, matrixInverse, c, n);
        g.print_matr(c, n);
    }
    @Test
    void testInverseMatrix() {
        int n = 5;
        double alpha = ALPHA;
        double beta  = pow(10,5);
        double[][] a = new double[n][];
        for (int i = 0; i < n; i++)	a[i] = new double[n];

        double[][] a_inv = new double[n][];
        for (int i = 0; i < n; i++)	a_inv[i] = new double[n];

        Gen g = new Gen(a, a_inv, n, alpha, beta, 1, 2, 1, 1 );
        g.mygen();
        //g.print_matr(a, n);
          g.print_matr(a_inv, n);
          System.out.println();
        double[][] matrixInverse = MatrixInversion.inverseMatrix(a);
        MatrixInversion.printMatrixInverse(matrixInverse);

    }

    @Test
    void testInverseMatrix5() {
        int n = 3;
        double alpha = ALPHA;
        double beta  = BETA;
        double[][] a = new double[n][];
        for (int i = 0; i < n; i++)	a[i] = new double[n];

        double[][] a_inv = new double[n][];
        for (int i = 0; i < n; i++)	a_inv[i] = new double[n];

        Gen g = new Gen(a, a_inv, n, alpha, beta, 1, 2, 1, 1 );
        g.mygen();
        g.print_matr(a, n);
        g.print_matr(a_inv, n);
        System.out.println();
        double[][] matrixInverse = MatrixInversion.inverseMatrix(a);
        MatrixInversion.printMatrixInverse(matrixInverse);
        double[][] r = new double[n][];
        for (int i = 0; i < n; i++)	r[i] = new double[n];
        Gen.matr_mul (a, matrixInverse, r, n);
        MatrixInversion.printMatrixInverse(r);
        MatrixInversion.printMatrixInverse(MatrixInversion.multiplySquareMatrices(a, matrixInverse));

    }
}
