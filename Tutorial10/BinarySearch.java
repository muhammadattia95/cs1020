import java.util.Scanner;

public class BinarySearch {
	public static int binSearchRecur(int[] input, int searchTerm,
	                                 int low, int high) throws Exception {
		if (low > high) {
			throw new Exception("Item Not Found");
		}
		
		int mid = (low + high) / 2;
		if (searchTerm > input[mid]) {
			return binSearchRecur(input, searchTerm, mid+1, high);
		}
		else if (searchTerm < input[mid]) {
			return binSearchRecur(input, searchTerm, low, mid-1);
		}
		else {
			return mid;
		}
	}
	
	// Driver for the recursive function
	public static int binarySearch(int[] input, int searchTerm) throws Exception {
		return binSearchRecur(input, searchTerm, 0, input.length);
	}
	
	public static void main(String[] args) {
		int inputArray[] = {1,3,4,5,7,8,10,12,13,14,18,19,20};
		System.out.println("Input Data: {1,3,4,5,7,8,10,12,13,14,18,19,20}");
		System.out.print("Search For? ");
		
		Scanner sc = new Scanner(System.in);
		int searchTerm = sc.nextInt();
		sc.close();
		
		System.out.print("Searching for Item " + searchTerm + "... ");
		
		try {
			int loc = binarySearch(inputArray, searchTerm);
			System.out.println("Found it at position " + loc + "!");
		} catch (Exception e) {
			System.out.println("Not found!");
		} 
	}
}
