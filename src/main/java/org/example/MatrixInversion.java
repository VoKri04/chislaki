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

        // **************************************
        int [] index = new int[n];
        // для перестановок строк (столбцов)
        for (int k = 0; k < n; ++k) index[k] = k;
        //***************************************
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
            /*System.out.println("Наше maxrow: " + maxRow);*/

            // Перестановка текущей строки с найденной строкой в матрице
            double[] tempA = a[k];
            a[k] = a[maxRow];
            a[maxRow] = tempA;

            // ******************************************
            int temp = index[k];
            index[k] = index[maxRow];
            index[maxRow] = temp;
            // ******************************************
            /*System.out.println("Наше index");
            for(int i = 0; i < n; i++){
                System.out.print(index[i] + " ");
            }
            System.out.println();*/
            double tempI = identityColumn[k];
            identityColumn[k] = identityColumn[maxRow];
            identityColumn[maxRow] = tempI;

            // ******************************************
            identityColumn[k] = 1.0;
            if (k != maxRow) identityColumn[maxRow] = 0.0;
            // ******************************************
            /*System.out.println("После перестановки строк матрица a на итерации k:" + k);
            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();*/
            // Нормализация текущей строки
            double pivot = a[k][k];
            for (int j = 0; j < n; ++j) {
                a[k][j] /= pivot;
            }
            identityColumn[k] /= pivot;

            /*System.out.println("После нормализации строки матрица a: ");
            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();*/
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
            /*System.out.println("После обнуления столбца в других строках ");
            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();*/

            for(int i = 0; i < n; i++){
                a[i][k] = identityColumn[i];
            }
           /* System.out.println("После замены столбца в матрице: ");
            for (double[] row : a) {
                for (double value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            System.out.println();*/
        }

        // ******************************************
        //переставить столбцы
        boolean[] visited = new boolean[n]; // Отмечает, какие столбцы уже на месте

        for (int start = 0; start < n; start++) {
            if (visited[start]) continue; // Если столбец уже обработан, пропускаем

            int current = start;
            double[] tempColumn = new double[n];
            //  2 0 1
            // Запоминаем исходный столбец, который будем перемещать
            for (int i = 0; i < n; i++) {
                tempColumn[i] = a[i][current];
            }

            while (!visited[current]) {
                int next = index[current]; // Узнаем, куда должен переместиться текущий столбец
                visited[current] = true;   // Отмечаем, что мы его уже переместили

                if (next == start) {
                    for (int i = 0; i < n; i++) {
                        a[i][current] = tempColumn[i];
                    }
                    break;
                }

                // Копируем столбец next в current
                for (int i = 0; i < n; i++) {
                    a[i][current] = a[i][next];
                }
                current = next;
            }
        }
        // ******************************************




        return a;
    }

}

