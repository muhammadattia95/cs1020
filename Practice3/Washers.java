/*
 *	Author: Wong Kang Fei
 *	Mat No: A0138862W
 *
 * */
import java.util.*;


public class Washers{
	public static void main(String[] args){
		double d1;
		double d2;
		double thickness;
		double density;
		int qty;

		double unitWeight;
        double totalWeight;
		double rimArea;

		Scanner sc = new Scanner(System.in);

		System.out.print("Inner diameter in cm: ");
		d1 = sc.nextDouble();

		System.out.print("Outer diameter in cm: ");
		d2 = sc.nextDouble();
		
		System.out.print("Thickness in cm: ");
		thickness = sc.nextDouble();

		System.out.print("Density in grams per cubic cm: ");
		density = sc.nextDouble();

		System.out.print("Quantity: ");
		qty = sc.nextInt();

		rimArea = circleArea(d2) - circleArea(d1);
		unitWeight = rimArea * thickness * density;

		totalWeight = unitWeight * qty;

		System.out.printf("Total weight of %d washers is %.2f grams. %n", qty, totalWeight);
	}

	private static double circleArea(double diameter){
		return Math.pow(diameter/2, 2)*Math.PI;
	}		
}
