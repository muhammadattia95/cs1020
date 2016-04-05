import java.util.*;

class Instruction {
	private static char[] operators;
	private static int[] operands;
	private static int instructionCount;
	private static int targetNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		instructionCount = sc.nextInt();
		targetNum = sc.nextInt();

		sc.nextLine(); // consume line feed
		
		operators = new char[instructionCount];
		operands = new int[instructionCount];

		for(int i = 0; i<instructionCount; i++){
			operators[i] = sc.next().charAt(0);
			operands[i] = sc.nextInt();
			sc.nextLine();
		}

		System.out.println(findClosestTotal());
	}

	private static int findClosestTotal(){
		if(instructionCount <= 0){
			return 0;
		}else{
			return findClosestTotal(operators[0], operands[0], 0, 1);
		}
	}

	// pre: operators size = operands size, the index of operators corresponds to the index of operands
	private static int findClosestTotal(char operator, int operand, int totalChosen, int index){
		
		int totalNotChosen = totalChosen;

		switch(operator){
			case '+':
				totalChosen = totalChosen + operand;
				break;
			case '-':
				totalChosen = totalChosen - operand;
				break;
			case '*':
				totalChosen = totalChosen * operand;
				break;
			case '/':
				totalChosen = totalChosen / operand;
				break;
			default:
				break;
		}

		/*
		System.out.println("===");
		System.out.println(totalChosen);
		System.out.println(totalNotChosen);
		*/
		

		if(instructionCount <= index){
			return distanceBetweenNum(targetNum, totalChosen) < distanceBetweenNum(targetNum, totalNotChosen)? totalChosen: totalNotChosen;
		}else{
			int chosen = findClosestTotal(operators[index], operands[index], totalChosen, index+1);
			int notChosen = findClosestTotal(operators[index], operands[index], totalNotChosen, index+1);

			int currentClosestTotal = distanceBetweenNum(targetNum, chosen) < distanceBetweenNum(targetNum, notChosen)? chosen: notChosen;

			return currentClosestTotal;
		}
	}

	private static int distanceBetweenNum(int num1, int num2){
		return Math.abs(num1 - num2);
	}
}
