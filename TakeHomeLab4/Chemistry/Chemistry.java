/**
 * Name          : Wong Kang Fei
 * Matric number : A0138862W
 */

import java.util.*;

public class Chemistry {
	private Map<Character, Integer> elements;
	private String exp;
	private static final int LEFT_BRACKET = -1;
	private static final int RIGHT_BRACKET = -2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int elementCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		Map<Character, Integer> elements = new HashMap<Character, Integer>();
		for( int i =0; i<elementCount;i++){
			elements.put(sc.next().charAt(0), sc.nextInt());
		}

		sc.nextLine(); // consume line feed

		Chemistry chemistry = new Chemistry(elements, sc.nextLine());

		System.out.println(chemistry.parseAndEvaluate());
	}

	public Chemistry(Map<Character, Integer> elements, String exp){
		this.elements = elements;
		this.exp = exp;
	}

	private int evaluate(Stack<Integer> s){
		int result = 0;

		while(!s.isEmpty()){
			if(s.peek() == LEFT_BRACKET){
				s.pop();
				break;
			}

			result += s.pop();
		}

		return result;
	}

	private int parseAndEvaluate(){
		Stack<Integer> s = new Stack<Integer>();
		for(char c : exp.toCharArray()){
			if(Character.isLetter(c)){
				s.push(elements.get(c));
			}else if(Character.isDigit(c)){
				s.push(s.pop()*Character.getNumericValue(c));
			}else if(c == '('){
				s.push(LEFT_BRACKET);
			}else if(c == ')'){
				s.push(evaluate(s));
			}else{
				// wut
			}
		}

		return evaluate(s);
	}


	/*
	private static int evaluatePostfix(String exp){
		//System.out.println(exp);
		int result = 0;
		Stack<Integer> s = new Stack<Integer>();
		for( char c : exp.toCharArray()){
			switch(c){
				case '+':
				case '-':
				case '*':
				case '/':
					//System.out.println(s.pop());
					int operand2 = s.pop();
					int operand1 = s.pop();
					result = evaluate(operand1, c, operand2);
					s.push(result);
					break;
				default:
					// operands -> digits
					s.push(Character.isLetter(c)? elements.get(c) : Character.getNumericValue(c));
					break;
			}
		}

		return s.pop();
	}

	private static String formulaToPostfix(String exp){
		System.out.println(exp);
		Stack<Character> s = new Stack<Character>();
		String result = "";
		char[] expArr = exp.toCharArray();
		for(int i = 0; i<expArr.length; i++){
			switch(expArr[i]){
				case '+':
				case '-':
				case '*':
				case '/':
					while( !s.empty() &&
							s.peek() != '(' &&
							Chemistry.precedence(expArr[i]) <= precedence(s.peek())){
								result = result + s.pop();
							}
					s.push(expArr[i]);
					break;
				case '(':
					s.push(expArr[i]);
					break;
				case ')':
					while(s.peek() != '('){
						result = result + s.pop();
					}
					s.pop();
					break;
				default:
					if( (i+1) <= expArr.length -1){ // there's next character in the exp buffer
						if( !Character.isDigit(expArr[i+1]) && expArr[i+1] != ')'){
							s.push('+');
						}
					}

					if( Character.isDigit(expArr[i])){
						result = result + expArr[i] + '*';
					}else if( Character.isLetter(expArr[i])){
						result = result + expArr[i];
					}
					break;
			}
		}
		while(!s.empty()){
			result = result + s.pop();
		}

		return result;
	}

	private static int precedence(char c){
		switch(c){
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			default:
				return -1;	
		}
	}

	private static int evaluate(int operand1, char operator, int operand2){
		switch(operator){
			case '+':
				return operand1+operand2;
			case '-':
				return operand1-operand2;
			case '*':
				return operand1*operand2;
			case '/':
				return operand1/operand2;
			default:
				return 0;
		}
	}
	*/
}


