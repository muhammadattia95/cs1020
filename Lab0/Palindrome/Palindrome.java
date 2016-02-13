/*
 *  * author		: Wong Kang Fei
 *   * matric no.	: A0138862W
 *    */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 	 * 		PRE-Condition  :
	 * 	 	 * 		POST-Condition :
	 * 	 	 	 */
	public static boolean isPalindrome(String word) {
		int halfLength = word.length()/2;
		
		String word1 = word.substring(0, halfLength);
		String word2 = word.substring(halfLength, word.length());

		return isPalindrome(word1, word2);

	}

	public static boolean isPalindrome(String word1, String word2){
		return word1.equals(new StringBuilder(word2).reverse().toString());
	}

	public static void main(String[] args) {
		// declare the necessary variables
		//
		//
		// 		// declare a Scanner object to read input
		//
		//
		// 				// read input and process them accordingly
		//
		//
		// 						// simulate the problem
		//
		//
		// 								// output the result
		//
		
		Scanner sc = new Scanner(System.in);

		String word1 = sc.nextLine();
		String word2 = sc.nextLine();

		//System.out.println(isPalindrome(word1, word2)? "YES" : "NO");
		System.out.println(isPalindrome(word1+word2)? "YES" : "NO");
	}
}
