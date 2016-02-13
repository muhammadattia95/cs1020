import java.util.*;

public class MileToKm{
	public static void main(String[] main){
		final double KMS_PER_MILE = 1.609;
		double miles;
		double kms;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter distance in miles: ");
		miles = sc.nextDouble();

		kms = KMS_PER_MILE * miles;

		System.out.printf("That equals %9.2f km.", kms);
	}
}
