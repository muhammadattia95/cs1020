import java.util.*;

public class Lisp{
	private static final int LEFT_BRACKET = -9999;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Lisp lisp = new Lisp();

		System.out.println(lisp.evaluate(args[0]));
	}
		
	public int evaluate(String exp){

		Stack<Character> s = new Stack<Character>(); // operators
		Stack<Integer> t = new Stack<Integer>(); // numbers and paranthesis

		for(char c : exp.toCharArray()){
			if(Character.isDigit(c)){
				t.push(Character.getNumericValue(c));
			}else if(c == '('){
				t.push(LEFT_BRACKET);
			}else if(c == ')'){

				if( t.peek() == LEFT_BRACKET){
					char operator = s.pop(); // either + or *
					int operand2 = t.pop();
					
					if(operator == '+'){
						t.push(Integer.valueOf(0));
					}else if(operator == '*'){
						t.push(Integer.valueOf(1));
					}

					t.pop(); //remove '('
				}else{
					// is digits
					char operator = s.pop();

					switch(operator){
						case '+':
							while(true){
								int operand2 = t.pop();
								int operand1 = t.pop();
								if(t.peek() == LEFT_BRACKET){
									t.pop();
									t.push(operand1 + operand2);
									break;
								}else{
									t.push(operand1 + operand2);
								}
							}
							break;
						case '-':
							while(true){
								int operand2 = t.pop();
								int operand1 = t.pop();
								if(t.peek() == LEFT_BRACKET){
									t.pop();
									t.push(operand1 - operand2);
									break;
								}else{
									t.push(operand1 - operand2);
								}
							}
							break;
						case '*':
							while(true){
								int operand2 = t.pop();
								int operand1 = t.pop();
								if(t.peek() == LEFT_BRACKET){
									t.pop();
									t.push(operand1 * operand2);
									break;
								}else{
									t.push(operand1 * operand2);
								}
							}
							break;
						case '/':
							while(true){
								int operand2 = t.pop();
								int operand1 = t.pop();
								if(t.peek() == LEFT_BRACKET){
									t.pop();
									t.push(operand1/ operand2);
									break;
								}else{
									t.push(operand1 / operand2);
								}
							}
							break;
						default:
							// wut
							break;
					}
				}
			}else{
				// is operator
				s.push(c);
			}
		}
		return t.pop();
	}
}
