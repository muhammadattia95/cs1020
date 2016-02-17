// To test out CentredCircle class 
// This class is given and should not be modified.
// Aaron Tan

import java.util.*;
import java.awt.geom.*;

public class TestCentredCircle {

	// This method reads circle's input data from user, creates
	// a CentredCircle object, and returns it to the caller.
	public static CentredCircle readCircle(Scanner sc) {

		System.out.print("Enter colour: ");
		String inputColour = sc.next();

		if (inputColour.equals("Default"))
			return new CentredCircle();
		else {
			System.out.print("Enter radius: ");
			double inputRadius = sc.nextDouble();
			System.out.print("Enter centre: ");
			double inputCentreX = sc.nextDouble();
			double inputCentreY = sc.nextDouble();

			// Create a CentredCircle object using the alternative constructor
			return new CentredCircle(inputColour, inputRadius, 
		                             new Point2D.Double(inputCentreX, inputCentreY));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read input and create a CentredCircle object
		CentredCircle circle1 = readCircle(scanner);
		System.out.println();

		// Read input and create another CentredCircle object
		CentredCircle circle2 = readCircle(scanner);
		System.out.println();

		// Testing toString() method in CentredCircle class
		// You may also write: 
		//    System.out.println("1st circle: " + circle1.toString());
		//    System.out.println("2nd circle: " + circle2.toString());
		System.out.println("1st circle: " + circle1);
		System.out.println("2nd circle: " + circle2);

		// Testing equals() method in CentredCircle class
		if (circle1.equals(circle2))
			System.out.println("They are identical.");
		else
			System.out.println("They are not identical.");
	}
}

