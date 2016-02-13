import java.util.*;

public class MissingDigitsV2 {

	public static void main(String[] args) {
		Vector<Integer> numbers = new Vector<Integer>();
		numbers.setSize(10);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		int originalNumber = number;

		sc.nextLine(); // consume line feed
		
		while(number != 0){
			int lastDigit = number %10;
			
			numbers.set(lastDigit, lastDigit);

			number = number / 10;
		}

		System.out.print("Missing digits in "+ originalNumber + ": " );
		for(int i=0; i<numbers.size(); i++){
			if(numbers.get(i) == null){
				System.out.print(i+" ");
			}
		}
		
		System.out.println();


	}


}


