package homework1;

// The code has been written using NewtonRootFinderTest5g.java file from the 5th lecture

import org.mariuszgromada.math.mxparser.Function;

import processing.core.PApplet;

public class IntegralGenerator extends PApplet {

	Integral in;

	public static void main(String[] args) {
		PApplet.main(IntegralGenerator.class);
	}

	public void settings() {
		size(800, 500);
	}

	public void setup() {

		Function f = new Function("f(x) = 3.05815 * x + sin(4 * pi * x)");
		in = new Integral(f, 0, 20);

		double x = in.findIntegral1(); // First method of integration
		double x2 = in.findIntegral2(); // Second method of integration
		double x3 = in.findIntegral3(); // Third method of integration
		double numericalresult = 611.63; // Numerical result of the integral
		
		System.out.println("Calculated integral result is: 611.63");
		System.out.printf("First method's integral result is:  x=%.2f ", x);
		System.out.printf("Absolut error is: %.2f ", (numericalresult - x));
		System.out.printf("Relative error is: %.2f percent\n", (((numericalresult - x) / numericalresult) * 100));

		System.out.printf("Second method's integral result is: x=%.2f ", x2);
		System.out.printf("Absolut error is: %.2f ", (numericalresult - x2));
		System.out.printf("Relative error is: %.2f percent\n", (((numericalresult - x2) / numericalresult) * 100));

		System.out.printf("Third method's integral result is:  x=%.2f ", x3);
		System.out.printf("Absolut error is: %.2f ", (numericalresult - x3));
		System.out.printf("Relative error is: %.2f percent\n", (((numericalresult - x3) / numericalresult) * 100));
	}

	public void draw() {
		this.background(0);
		in.plot(this);
	}

}
