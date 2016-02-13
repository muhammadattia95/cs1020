import java.util.*;

public class Reading {

	//
	public static void main(String[] args) {
		// 													// Fill in the code
		//
		Scanner sc = new Scanner(System.in);
		String format = sc.nextLine();

		switch(format){
			case "LIMIT":
				final int LIMIT = sc.nextInt();
				for(int i = 0; i<LIMIT; i++){
					System.out.println(operate(sc.next(), sc.nextInt(), sc.nextInt()));
				}
				break;
			case "SENTINEL":
				while(true){
					String op = sc.next();
					if(op.equals("-1")){
						break;
					}else{
						System.out.println(operate(op, sc.nextInt(), sc.nextInt()));
					}
				}
				break;
			case "EOF":
				while(sc.hasNext()){
					System.out.println(operate(sc.next(), sc.nextInt(), sc.nextInt()));
				}
				break;
		}

	}

	// Add a method operate(String, int, int) below
	// 	// Perform operation on the operands based on the string in op
	public static int operate(String op, int operand1, int operand2) {
		switch(op){
			case "ADD":
				return operand1 + operand2;
			case "SUB":
				return operand1 - operand2;
			case "MUL":
				return operand1*operand2;
			default:
				return 0;
		}
		//
		// 									// complete the code
	}

}
