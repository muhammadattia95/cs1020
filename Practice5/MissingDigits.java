// MissingDigits.java
// // To find digits that do not appear in user's input number.
import java.util.*;
//
public class MissingDigits {
	//
	//
	private static boolean[] digits = new boolean[10];
	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		int originalNumber = number;

		while(number !=0){
			int i = number % 10;
			number = number / 10;
			digits[i] = true;
		}

		sc.nextLine(); // consume line feed

		System.out.print("Missing digits in "+ originalNumber+": ");
		for(int i = 0; i< digits.length; i++){
			if(!digits[i]){
				System.out.print(i + " ");
			}	
		}
		System.out.println();


	}

}

