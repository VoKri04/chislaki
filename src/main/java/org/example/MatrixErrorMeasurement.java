package org.example;
import java.util.Formatter;
import java.util.Locale;

public class MatrixErrorMeasurement {
    private double alpha;
    private double beta;
    private double norm;
    private double normInverse;
    private double mulNorm;
    private double diffNorm;
    private double x;
    private double r;


    public MatrixErrorMeasurement() {

    }
    public MatrixErrorMeasurement(double alpha, double beta, double norm, double normInverse, double mulNorm, double diffNorm, double x, double r) {
        this.alpha = alpha;
        this.beta = beta;
        this.norm = norm;
        this.normInverse = normInverse;
        this.mulNorm = mulNorm;
        this.diffNorm = diffNorm;
        this.x = x;
        this.r = r;
    }

    public static void printMatrixErrorMeasurement(MatrixErrorMeasurement[] matrix, int n) {
        System.out.print("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.printf(Locale.US, "%10s %10s %15s %15s %15s %15s %15s %15s%n",
                "A", "B", "||A||", "||A^-1||", "||V||", "||Z||", "||X||", "||R||");
        System.out.print("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf(Locale.US, "%10.4e %10.4e %15.4e %15.4e %15.4e %15.4e %15.4e %15.4e%n",
                    matrix[i].getAlpha(),
                    matrix[i].getBeta(),
                    matrix[i].getNorm(),
                    matrix[i].getNormInverse(),
                    matrix[i].getMulNorm(),
                    matrix[i].getDiffNorm(),
                    matrix[i].getX(),
                    matrix[i].getR());
        }
    }





    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public void setNorm(double norm) {
        this.norm = norm;
    }

    public void setNormInverse(double normInverse) {
        this.normInverse = normInverse;
    }

    public void setMulNorm(double mulNorm) {
        this.mulNorm = mulNorm;
    }

    public void setDiffNorm(double diffNorm) {
        this.diffNorm = diffNorm;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getNorm() {
        return norm;
    }

    public double getNormInverse() {
        return normInverse;
    }

    public double getMulNorm() {
        return mulNorm;
    }

    public double getDiffNorm() {
        return diffNorm;
    }

    public double getX() {
        return x;
    }

    public double getR() {
        return r;
    }
}
