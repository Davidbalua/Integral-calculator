package homework1;

// The code has been written using NewtonRootFinder5g.java file from the 5th lecture

import java.awt.Color;

import org.mariuszgromada.math.mxparser.Function;

import grafica.GPoint;
import processing.core.PApplet;

public class Integral {

	private static final int N_GRIDPOINTS = 200; // 10 grid points per second

	private double a; // starting integration point on graph
	private double b; // ending integration point on graph
	private Function f;
	private FunctionPlotter1D fp;

	public Integral(Function f, double a, double b) {
		this.a = a; // starting integration point on graph
		this.b = b; // ending integration point on graph
		this.f = f; // function
		fp = new FunctionPlotter1D(this.f, this.a, this.b);
	}

	public void plot(PApplet app) {

		// plot function
		this.fp.plot(app);
	}

// First method of integration

	public double findIntegral1() {
		double areaFx = 0.0;
		double areadFx = 0.0;
		double dx = (this.b - this.a) / N_GRIDPOINTS;
		this.fp.clearPoints();

		for (int i = 0; i < N_GRIDPOINTS; i++) {
			double x = this.a + i * dx;
			double fx = this.f.calculate(x);

			areadFx = dx * fx;
			areaFx = areadFx + areaFx;

			// graphics

			GPoint pointA = new GPoint((float) (x), 0);
			GPoint pointB = new GPoint((float) (x), (float) fx);
			GPoint pointC = new GPoint((float) (x + dx), (float) fx);

			this.fp.addLine(pointA, pointB, Color.GREEN);
			this.fp.addLine(pointC, pointB, Color.RED);

		}

		return areaFx;
	}

	// Second method of integration

	public double findIntegral2() {
		double areaFx = 0.0;
		double areadFx = 0.0;
		double dx = (this.b - this.a) / N_GRIDPOINTS;
		this.fp.clearPoints();

		for (int i = 0; i < N_GRIDPOINTS; i++) {
			double x = this.a + (0.5 * dx) + i * dx;
			double fx = this.f.calculate(x);

			areadFx = dx * fx;
			areaFx = areadFx + areaFx;

			// graphics

			GPoint pointA = new GPoint((float) (x - (0.5 * dx)), 0);
			GPoint pointB = new GPoint((float) (x - (0.5 * dx)), (float) fx);
			GPoint pointC = new GPoint((float) (x + (0.5 * dx)), (float) fx);

			this.fp.addLine(pointA, pointB, Color.GREEN);
			this.fp.addLine(pointC, pointB, Color.ORANGE);

		}

		return areaFx;
	}

	// Third method of integration

	public double findIntegral3() {
		double areaFx = 0.0;
		double areadFx = 0.0;
		double dx = (this.b - this.a) / N_GRIDPOINTS;
		this.fp.clearPoints();

		for (int i = 0; i < N_GRIDPOINTS; i++) {
			double x = this.a + i * dx;
			double fx = this.f.calculate(x);
			double fx1 = this.f.calculate(x + dx);

			areadFx = dx * ((fx + fx1) / 2);
			areaFx = areadFx + areaFx;

			// graphics

			GPoint pointA = new GPoint((float) (x), 0);
			GPoint pointB = new GPoint((float) (x), (float) fx);
			GPoint pointC = new GPoint((float) (x + dx), (float) fx1);

			this.fp.addLine(pointA, pointB, Color.GREEN);
			this.fp.addLine(pointC, pointB, Color.BLUE);

		}

		return areaFx;
	}

}
