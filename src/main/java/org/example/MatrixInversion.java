package org.example;

import java.util.Arrays;

import static java.lang.Math.abs;

public class MatrixInversion {

    public static void printMatrixInverse(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] inverseMatrix(double[][] a) {
        int n = a.length;
        double[] identityColumn = new double[n];

        for (int k = 0; k < n; ++k) {
            Arrays.fill(identityColumn, 0);
            identityColumn[k] = 1;

            // Поиск строки с максимальным элементом в текущем столбце
            int maxRow = k;
            for (int i = k + 1; i < n; ++i) {
                if (Math.abs(a[i][k]) > Math.abs(a[maxRow][k])) {
                    maxRow = i;
                }
            }

            // Перестановка текущей строки с найденной строкой в матрице
            double[] tempA = a[k];
            a[k] = a[maxRow];
            a[maxRow] = tempA;

            double tempI = identityColumn[k];
            identityColumn[k] = identityColumn[maxRow];
            identityColumn[maxRow] = tempI;

            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
            // Нормализация текущей строки
            double pivot = a[k][k];
            for (int j = 0; j < n; ++j) {
                a[k][j] /= pivot;
            }
            identityColumn[k] /= pivot;

            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
            // Обнуление текущего столбца в других строках
            for (int i = 0; i < n; ++i) {
                if (i != k) {
                    double factor = a[i][k];
                    for (int j = 0; j < n; ++j) {
                        a[i][j] -= factor * a[k][j];
                    }
                    identityColumn[i] -= factor * identityColumn[k];
                }
            }
            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();
            /*System.out.println("identityColumn[i] ");
            for(int i = 0; i < n; i++){
                System.out.println(identityColumn[i]);
            }
            System.out.println("a[i][k]  ");
            for(int i = 0; i < n; i++){
                System.out.println(a[i][k]);
            }*/
            for(int i = 0; i < n; i++){
                a[i][k] = identityColumn[i];
            }
        }

        return a;
    }

}

