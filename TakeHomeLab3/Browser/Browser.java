
/**
*	Name		: Wong Kang Fei
*	Matric No.	: A0138862W
*/

import java.util.*;

public class Browser {
	private final String DEFAULT_PAGE = "http://www.comp.nus.edu.sg";
	private DoublyLinkedList<String> tabs;
	private int activeTabIndex;

	public Browser(){
		tabs = new DoublyLinkedList<String>();
		tabs.add(DEFAULT_PAGE);
		activeTabIndex = 0;
	}

	public void newTab(){
		tabs.add(activeTabIndex+1, DEFAULT_PAGE);
	}

	public void closeTab(){
		int tabIndexToBeRemoved = activeTabIndex;
		if(activeTabIndex == tabs.getSize()-1){ // is last tab
			prevTab();
		}
		tabs.remove(tabIndexToBeRemoved);
	}

	public void nextTab(){
		if(activeTabIndex != tabs.getSize()-1){
			activeTabIndex++;
		}
	}

	public void prevTab(){
		if(activeTabIndex != 0){
			activeTabIndex--;
		}
	}

	public void openHere(String url){
		tabs.modify(activeTabIndex, url);
	}

	public void openNew(String url){
		tabs.add(activeTabIndex+1, url);
	}

	public int getActiveTabIndex(){
		return activeTabIndex;
	}

	public String getActiveTabURL(){
		return tabs.get(activeTabIndex);
	}

	public DoublyLinkedList<String> getTabs(){
		return tabs;
	}

	public static void main(String[] args) {
		Browser browser = new Browser();

		Scanner sc = new Scanner(System.in);
		int queryCount = sc.nextInt();
		
		sc.nextLine();

		for(int i = 0; i<queryCount; i++){
			String[] queryParameters = sc.nextLine().trim().split(" ");

			switch(queryParameters[0]){
				case "NEWTAB":
					browser.newTab();
					break;
				case "CLOSETAB":
					browser.closeTab();
					break;
				case "NEXTTAB":
					browser.nextTab();
					break;
				case "PREVTAB":
					browser.prevTab();
					break;
				case "OPENHERE":
					browser.openHere(queryParameters[1]);
					break;
				case "OPENNEW":
					browser.openNew(queryParameters[1]);
					break;
			}
			System.out.println(browser.getActiveTabURL());
			//browser.getTabs().printElements();
		}
	
	}


}

// http://stackoverflow.com/questions/22029047/dummy-head-node-linked-list 
class DoublyLinkedList<E>{
	private ListNode<E> dummy;
	private int size;

	public DoublyLinkedList(){
		this.dummy = new ListNode<E>(null);
		this.dummy.setNext(dummy);
		this.dummy.setPrev(dummy);

		this.size = 0;
	}

	public boolean isEmpty(){
		return dummy.getNext() == dummy && dummy.getPrev() == dummy;
	}

	public int getSize(){
		return size;
	}

	public void add(int index, E data) {
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException();
		}else if(index == size){
			add(data);
		}else{
			ListNode<E> listNode = new ListNode<E>(data);
			ListNode<E> curr = dummy.getNext();
			while(index != 0){
				curr = curr.getNext();
				index--;
			}

			curr.getPrev().setNext(listNode);
			listNode.setPrev(curr.getPrev());

			curr.setPrev(listNode);
			listNode.setNext(curr);

			size++;
		}
	}

	public void add(E data){
		ListNode<E> listNode = new ListNode<E>(data);
		listNode.setNext(dummy);
		listNode.setPrev(dummy.getPrev());

		listNode.getPrev().setNext(listNode);
		dummy.setPrev(listNode);

		size++;		
	}

	public void remove(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> curr = dummy.getNext(); 
			while(index != 0){
				curr = curr.getNext();
				index--;
			}

			curr.getPrev().setNext(curr.getNext());
 			curr.getNext().setPrev(curr.getPrev());
 			size--;
		}
	}

	public E get(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				curr = curr.getNext();
				index--;
			}

			return curr.getData();
		}
	}

	public void modify(int index, E data){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}else{
			ListNode<E> curr = dummy.getNext();
			while(index !=0){
				curr = curr.getNext();
				index--;
			}

			curr.setData(data);
		}
	}

	public void display(){
		System.out.println("====display===");
		ListNode<E> curr = dummy.getNext();

		while(curr != dummy){
			System.out.println(curr.getData());
			curr = curr.getNext();
		}
		System.out.println("====display===");
	}

	/*
	public static void main(String[] args){
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();

		System.out.println(dll.isEmpty());

		dll.add("C");
		dll.display();

		dll.add("Z");
		dll.display();

		dll.add("A");
		dll.display();

		System.out.println(dll.isEmpty());

		dll.remove(2);
		dll.display();

		dll.remove(1);
		dll.display();

		dll.remove(0);
		dll.display();


		System.out.println(dll.isEmpty());
	}
	*/
}

class ListNode<E>{
	private E data;
	private ListNode<E> prev;
	private ListNode<E> next;

	public ListNode(E data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public ListNode(E data, ListNode<E> prev, ListNode<E> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public E getData(){
		return data;
	}

	public void setData(E data){
		this.data = data;
	}

	public ListNode<E> getPrev(){
		return prev;
	}

	public void setPrev(ListNode<E> listNode){
		this.prev = listNode;
	}

	public ListNode<E> getNext(){
		return next;
	}

	public void setNext(ListNode<E> listNode){
		this.next = listNode;
	}
}
