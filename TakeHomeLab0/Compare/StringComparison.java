/**
 *  *
 *   * author	: []
 *    * matric no: []
 *     * 
 *      */

import java.util.*;

public class StringComparison {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String string1 = sc.nextLine();
		String string2 = sc.nextLine();

		int comparison = string1.compareToIgnoreCase(string2);

		if(comparison > 0){
			System.out.println(2);
		}else if(comparison <0){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}
}

