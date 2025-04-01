package org.example;

import org.junit.jupiter.api.Test;

class MatrixErrorMeasurementTest {
    // alpha, beta – минимальное и максимальное собственные значения (спектр матрицы).
    // sign_law – закон распределения знаков. -1 - отрицательные 0 - чередование
    // lambda_law – закон распределения собственных значений. 1 - sqrt 2 - sin
    // variant – вариант структуры матрицы. 0 - симметричная матрица  1 - матрица простой структуры 2 - одна жорданова клетка 2x2 при минимальном с.з.
    // schema – схема генерации.
    public int N = 100;
    private double constAlpha = 5.;
    private double constBeta  = 20;
    private int sign_law = 1;
    private int lambda_law = 2;
    private int variant = 0;
    private int schema = 1;
    private int cycles = 20;

    @Test
    void matrixErrorMeasurementTest() {
        int n = N;
        MatrixErrorMeasurement[] matrixErrorMeasurement = new MatrixErrorMeasurement[n];
        boolean flag = true;
        for(int k = 0; k < 2; k++){
            double alpha = constAlpha;
            double beta  = constBeta;
            for(int i = 0; i < cycles; i++){
                double[][] a = new double[n][];
                for (int j = 0; j < n; j++)	a[j] = new double[n];

                double[][] a_inv = new double[n][];

                for (int j = 0; j < n; j++)	a_inv[j] = new double[n];

                double[][] c = new double[n][];
                for (int j = 0; j < n; j++)	c[j] = new double[n];

                Gen g = new Gen(a, a_inv, n, alpha, beta, sign_law, lambda_law, variant, schema );
                g.mygen();
                matrixErrorMeasurement[i] = new MatrixErrorMeasurement();
                matrixErrorMeasurement[i].setAlpha(alpha); // alpha
                matrixErrorMeasurement[i].setBeta(beta); // beta
                double[][] matrixInversion = MatrixInversion.inverseMatrix(a);
                double norm = g.matr_inf_norm(a, n);
                matrixErrorMeasurement[i].setNorm(norm); // ||A||
                double normInverse = g.matr_inf_norm(matrixInversion, n);
                matrixErrorMeasurement[i].setNormInverse(normInverse); //||A_inv||
                matrixErrorMeasurement[i].setMulNorm(norm * normInverse); // ||V||
                double diffNorm = g.matr_inf_norm(g.subtractMatrices(a_inv, matrixInversion), n);
                matrixErrorMeasurement[i].setDiffNorm(diffNorm); // ||Z||
                matrixErrorMeasurement[i].setX(diffNorm/normInverse); //||X||
                g.matr_mul(a_inv, matrixInversion, c, n);
                matrixErrorMeasurement[i].setR(g.calculateR(matrixInversion)); // ||R||
                if(flag){
                    beta = beta * 10;
                } else {
                    alpha = alpha / 10;
                }

            }
            flag = false;
            MatrixErrorMeasurement.printMatrixErrorMeasurement(matrixErrorMeasurement, cycles);
        }

    }

}