package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for simple App.
 */
public class GenTest 
{
	private final Gen gen = new Gen();

	private int N = 3;
	private double ALPHA = 1.;
	private double BETA  = pow(10,20);

	@Test
	public void GenTest()
	{
		int n = N;
		double alpha = ALPHA;
		double beta  = BETA;

		double[][] a = new double[n][];
		for (int i = 0; i < n; i++)	a[i] = new double[n];

		double[][] a_inv = new double[n][];
		for (int i = 0; i < n; i++)	a_inv[i] = new double[n];

		Gen g = new Gen(a, a_inv, n, alpha, beta, 1, 2, 0, 1 );

		g.mygen (); // симметричная
	//	g.mygen ( a, a_inv, n, alpha, beta, 1, 2, 1, 1 ); //проостой структуры
	//	g.mygen ( a, a_inv, n, alpha, beta, 0, 0, 2, 1 ); //жорданова клетка

		g.print_matr(a,n);
		g.print_matr(a_inv,n);

	}

	@Test
	public void GenTest2()
	{
		int n = N;
		double alpha = 1;
		double beta  = 4;

		double[][] a = new double[n][];
		for (int i = 0; i < n; i++)	a[i] = new double[n];

		double[][] a_inv = new double[n][];
		for (int i = 0; i < n; i++)	a_inv[i] = new double[n];

		double[][] c = new double[n][];
		for (int i = 0; i < n; i++)	c[i] = new double[n];

		Gen g = new Gen(a, a_inv, n, alpha, beta, 0, 0, 0, 1 );
		g.mygen (); // симметричная

		//g.mygen (a, a_inv, n, alpha, beta, 1, 2, 0, 1 ); // симметричная
		//	g.mygen (a, a_inv, n, alpha, beta, 1, 2, 1, 1 ); //проостой структуры
		//	g.mygen (a, a_inv, n, alpha, beta, 0, 0, 2, 1 ); //жорданова клетка

		g.print_matr(a, n);
		g.print_matr(a_inv,n);
		g.matr_mul(a, a_inv, c, 3);
		g.print_matr(c, 3);
	}
	@Test
	void testSubtractMatrices_ValidInput() {
		double[][] a = {
				{1.0, 2.0},
				{3.0, 4.0}
		};
		double[][] b = {
				{0.5, 1.5},
				{2.5, 3.5}
		};
		double[][] expected = {
				{0.5, 0.5},
				{0.5, 0.5}
		};

		double[][] result = gen.subtractMatrices(a, b);

		assertArrayEquals(expected, result);
	}
}
