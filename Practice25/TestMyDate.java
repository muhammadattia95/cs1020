// TestMyDate class.
// Fill in the parts that are marked "WRITE YOUR CODE HERE."

import java.util.*;

public class TestMyDate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Enter the year, month and day (as integers): ");
       
        int year = 0;
		int	month = 0;
		int	day = 0;

        // Read the integers year, month and day from the input using 
        // Scanner's nextInt(). 
        // If nextInt() throws an InputMismatchException, then print an
        // error message "Invalid integer input." and terminate program.
       
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
		try{
			year = scanner.nextInt();
			month = scanner.nextInt();
			day = scanner.nextInt();

		}catch(InputMismatchException ex){
			System.out.println("Invalid integer input.");
			System.exit(0);
		}
       
       
        // Create a MyDate instance with the input year, month and day.
        // If MyDate constructor throws an InvalidDateException, then print
        // the message in the exception and terminate program.
       
        // =======================
        // WRITE YOUR CODE HERE.
        // =======================
		try{
			MyDate date = new MyDate(year, month, day);
			// Print out the date input by the user.
        	System.out.println("The date you entered is " + date + ".");

		}catch(InvalidDateException ex){
			System.out.println(ex.getMessage());
			System.exit(0);
		}

       
       
           }
}
