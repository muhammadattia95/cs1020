import java.util.*;

public class CircleArea {

	// You are to write a circleArea(double r) method to 
	// 	// return the area of a circle of radius r.
	//
	public static void main(String[] args) {
		// 				// Fill in the code below
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter side of square: ");
		final double sideOfSquare = sc.nextDouble();

		sc.nextLine(); // consume line feed

		final double diameterOfCircle = Math.sqrt(2*Math.pow(sideOfSquare, 2));
		final double radiusOfCircle = diameterOfCircle/2;
		final double areaOfCircle = Math.PI * Math.pow(radiusOfCircle, 2);

		System.out.printf("Area of circle = %.2f%n", areaOfCircle);

	}
}
