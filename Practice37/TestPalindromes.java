import java.util.*;

public class TestPalindromes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str;

		while (sc.hasNextLine()) {

			str = sc.nextLine();
			System.out.print("\"" + str + "\"");

			// To remove characters that are not letters in the alphabet,
			// represented by the regular expression [^a-zA-Z] in the
			// replaceAll() method below
			str = str.replaceAll("[^a-zA-Z]", "");

			if (isPalindrome(str)) 
				System.out.println(" is a palindrome.");
			else
				System.out.println(" is not a palindrome.");
		}
	}

	// Returns true if str is a palindrome; otherwise, returns false.
	public static boolean isPalindrome(String str) {
		if(str.length() == 0 || str.length() == 1){
			return true;
		}else if(!Character.isLetterOrDigit(str.charAt(0)) ){
			return isPalindrome(str.substring(1));
		}else if(!Character.isLetterOrDigit(str.charAt(str.length()-1))){
			return isPalindrome(str.substring(0, str.length()-1));
		}else if(Character.toLowerCase(str.charAt(0)) == Character.toLowerCase(str.charAt(str.length() -1))){
			return isPalindrome(str.substring(1, str.length()-1));
		}else{
			return false;
		}

	}
}

