/*  
 * CS1020 (AY2012/3 Sem2)  
 * Sit-in Lab #3 Morning session
 * Author    :   
 * Matric no.:   
 * Lab group : 
 * Description of program:   
 */ 

import java.util.*;

class ListNode <E> {  /* data attributes */  
	private E element;  
	private ListNode <E> next;

	/* constructors */  
	public ListNode(E item) { this(item, null); }
	public ListNode(E item, ListNode <E> n) { element = item; next = n; }

	/* get the next ListNode */  
	public ListNode <E> getNext() { return next; }

	/* get the element of the ListNode */  
	public E getElement() { return element; }

	/* set the next reference */  
	public void setNext(ListNode <E> n) { next = n; } 
}

class LinkedList <E> {  
	private ListNode <E> head = null;  

	public boolean isEmpty() { return (head == null); }

	public E getFirst() throws NoSuchElementException {   
		if (head == null) 
			throw new NoSuchElementException("can't get from an empty list");   
		else return head.getElement();  
	}

	/* return the reference to the first node in the list */
	public ListNode <E> getHead() { return head; }

}


/* WebBrowser Simulator */
public class WebBrowser {
	private Stack<String> backwardS = new Stack<String>();
	private Stack<String> forwardS = new Stack<String>();
	private String currURL = null;

	public WebBrowser(Scanner sc) {
		while(sc.hasNext()){
			String op = sc.nextLine();
			switch(op){
				case "FORWARD":
					forward();
					break;
				case "BACKWARD":
					backward();
					break;
				default:
					newURL(op);
					break;
			}
		}

		if(forwardS.isEmpty() && backwardS.isEmpty() && currURL == null){
			System.out.println("Browsing history is empty.");
		}else{

			System.out.println("Browsing History:");
		
			Stack<String> rStack = reverseStack(backwardS);

			while(!rStack.isEmpty()){
				System.out.println(rStack.pop());
			}
			System.out.println(currURL);

			while(!forwardS.isEmpty()){
				System.out.println(forwardS.pop());
			}

			System.out.println("Current Page:");
			System.out.println(currURL);
		}
	}

	private Stack<String> reverseStack(Stack<String> s){
		Stack<String> rStack = new Stack<String>();
		while(!s.isEmpty()){
			rStack.push(s.pop());
		}

		return rStack;
	}

	private void forward(){
		if(forwardS.isEmpty()){
			return;
		}else{
			if(currURL != null){
				backwardS.push(currURL);
				currURL = forwardS.pop();
			}
		}
	}

	private void backward(){
		if(backwardS.isEmpty()){
			return;
		}else{
			if(currURL != null){
				forwardS.push(currURL);
				currURL = backwardS.pop();
			}
		}
	}

	private void newURL(String url){
		if(currURL != null){
			backwardS.push(currURL);
		}

		while(!forwardS.isEmpty()){
			forwardS.pop();
		}

		currURL = url;
	}

	public static void main(String[] args) {         
		Scanner sc = new Scanner(System.in);     
		WebBrowser bc = new WebBrowser(sc);

	}
}
