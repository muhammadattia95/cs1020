/**
 *  *
 *   * author	: Wong Kang Fei
 *    * matric no: A0138862W
 *     * 
 *      */

import java.util.*;

public class HelloWorld {
	private static List<Integer> results = new ArrayList<Integer>();

	public static void main(String[] args) {

		// declare the necessary variables
				
		Scanner sc = new Scanner(System.in);
		final int QUERY_ID = sc.nextInt();
		
		sc.nextLine(); // consume line feed

		switch(QUERY_ID){
			case 1:
				final int QUERY_COUNT = sc.nextInt();
				sc.nextLine(); // consume line feed

				for(int i = 0; i< QUERY_COUNT; i++){
					results.add(executeQuery(sc.next(), sc.nextInt(), sc.nextInt()));
					sc.nextLine(); // consume line feed
				}
				printResult();
				break;
			case 2:
				while(true){
					String operator = sc.next();
					if(operator.equals("0")){
						break;
					}else{
						results.add(executeQuery(operator, sc.nextInt(), sc.nextInt()));
					}
					sc.nextLine(); // consume line feed
				}
				printResult();
				break;
			case 3:
				while(sc.hasNext()){
					results.add(executeQuery(sc.next(), sc.nextInt(), sc.nextInt()));
				}
				printResult();
				break;
			default:
				break;
		}
		
		
		// read input and process them accordingly
	}

	private static int executeQuery(String operator, int bit1, int bit2){
		return operator.equals("AND")? bit1 & bit2 : bit1 | bit2;
	}

	private static void printResult(){
		for(Integer i : results){
			System.out.println(i);
		}
	}
}

