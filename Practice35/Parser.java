/*  
 * CS1020 (AY2012/3 Sem2)  
 * Sit-in Lab #3 Noon session
 * Author    :   
 * Matric no.:   
 * Lab group : 
 * Description of program:   
 */ 

import java.util.*;

/* Parser for the markup language */
public class Parser {

	private static final String SECTION_OPEN = "<S>";
	private static final String SECTION_CLOSE = "</S>";
	private static final String PARAGRAPH_OPEN = "<P>";
	private static final String PARAGRAPH_CLOSE = "</P>";
	private static final String BOLD_OPEN = "<B>";
	private static final String BOLD_CLOSE = "</B>";
	private static final String ITALIC_OPEN = "<I>";
	private static final String ITALIC_CLOSE = "</I>";

	private static final String LINE_BREAK = "<LB>";
	private static final String PAGE_BREAK = "<PB>";

	private static final String TEXT = "<TEXT>";

	private Stack<String> theStack = new Stack<String>();
	
	public Parser(Scanner sc) {
		boolean isValid = true;
		while(sc.hasNext()){
			String theTag = sc.nextLine();
			switch(theTag){
				case SECTION_OPEN:
				case PARAGRAPH_OPEN:
				case BOLD_OPEN:
				case ITALIC_OPEN:
					theStack.push(theTag);
					break;
				case SECTION_CLOSE:
					if(theStack.peek().equals(SECTION_OPEN)){
						theStack.pop();
					}else{
						isValid = false;
					}
					break;
				case PARAGRAPH_CLOSE:
					if(theStack.peek().equals(PARAGRAPH_OPEN)){
						theStack.pop();
					}else{
						isValid = false;
					}
					break;
				case BOLD_CLOSE:
					if(theStack.peek().equals(BOLD_OPEN)){
						theStack.pop();
					}else{
						isValid = false;
					}
					break;
				case ITALIC_CLOSE:
					if(theStack.peek().equals(ITALIC_OPEN)){
						theStack.pop();
					}else{
						isValid = false;
					}
					break;
				case LINE_BREAK:
				case PAGE_BREAK:
				case TEXT:
					// ignore
					// will always be valid regardless the position
					break;
				default:
					theStack.push(theTag);
					isValid = false;
					break;
			}

			if(!isValid){
				break;
			}
		}

		System.out.println(theStack.isEmpty()? "No Error":"Error!");
	}

	public static void main(String[] args) {         
		Scanner sc = new Scanner(System.in);     
		Parser bc = new Parser(sc);

	}
}
