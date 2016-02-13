import java.util.*;

public class TestCentredBall {

	// This method reads ball's input data from user, creates
	// 	// a ball object, and returns it to the caller.
	public static CentredBall readBall(Scanner sc) {
		//
		System.out.print("Enter colour, radius and centre: ");
		return new CentredBall(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextInt());
		//
		// 										// Fill in the code
		//
	}
	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//
		// 																// Read input and create 1st ball object
		System.out.println("1st ball");
		CentredBall b1 = readBall(sc);
		//
		// 																						// Read input and create 2nd ball object
		System.out.println("2nd ball");
		CentredBall b2 = readBall(sc);
		//
		// 																												// Read input and create 3rd ball object
		System.out.println("3rd ball");
		CentredBall b3 = readBall(sc);
		

		boolean isFirstAndSecondSame = b1.equals(b2);
		CentredBall largestCentredBall = null;

		if(b1.getRadius() > b2.getRadius() && b1.getRadius() > b3.getRadius()){
			largestCentredBall = b1;
		}else if(b2.getRadius() >= b3.getRadius()){
			largestCentredBall = b2;
		}else{
			largestCentredBall = b3;
		}
		
		System.out.println();
		System.out.println("1st and 2nd balls are "+ (isFirstAndSecondSame? "the same." : "not the same."));
        System.out.println("The largest ball created is:");
        System.out.println(largestCentredBall);
	}
}
//
//
