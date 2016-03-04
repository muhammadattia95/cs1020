import java.util.*;

public class BasicLinkedList<E>{
	protected int size;
	protected ListNode<E> head;

	
	public static void main(String[] args){
		BasicLinkedList<Integer> bll = new BasicLinkedList<Integer>();

		bll.addFirst(9);
		bll.addFirst(8);
		bll.addFirst(7);
		bll.addFirst(6);
		bll.addFirst(5);
		bll.addFirst(4);
		bll.addFirst(3);
		bll.addFirst(2);
		bll.addFirst(1);

		System.out.print("this list before split: ");
		bll.print();

		BasicLinkedList<Integer> splitResult = bll.split();

		System.out.print("this list after split: ");
		bll.print();

		System.out.print("Returned list: ");
		splitResult.print();

		System.out.println("=====");

		BasicLinkedList<Integer> l1 = new BasicLinkedList<Integer>();
		l1.addFirst(7);
		l1.addFirst(5);
		l1.addFirst(5);
		l1.addFirst(4);
		l1.addFirst(3);
		l1.addFirst(1);

		BasicLinkedList<Integer> l2 = new BasicLinkedList<Integer>();
		l2.addFirst(6);
		l2.addFirst(5);
		l2.addFirst(3);
		l2.addFirst(3);
		l2.addFirst(2);
		l2.addFirst(2);

		System.out.print("firstList before merge: ");
		l1.print();

		System.out.print("secondList before merge: ");
		l2.print();

		BasicLinkedList<Integer> ml = BasicLinkedList.merge(l1, l2);
		System.out.print("New returned list: ");
		ml.print();
		
		System.out.print("firstList after merge: ");
		l1.print();

		System.out.print("secondList after merge: ");
		l2.print();
	}
	
	public BasicLinkedList(){
		this.size = 0;
		this.head = null;
	}

	private BasicLinkedList(ListNode<E> firstNode){
		this.size = 0; // not considered
		this.head = firstNode;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public int size(){
		return this.size();
	}

	public E getFirst(){
		if(isEmpty()){
			throw new NoSuchElementException("getFirst(): List is empty.");
		}else{
			return head.getData();
		}
	}

	public boolean contains(E data){
		ListNode<E> curr = head;

		while(curr != null){
			if(curr.getData().equals(data)){
				return true;
			}else{
				curr = curr.getNext();
			}
		}

		return false;
	}

	public void addFirst(E data){
		head = new ListNode<E>(data, head);
		size++;
	}

	public E removeFirst(){
		if(isEmpty()){
			throw new NoSuchElementException("removeFirst(): List is empty.");
		}else{
			ListNode<E> dataNode = head;
			head = head.getNext();
			size--;
			return dataNode.getData();
		}
	}

	public void print(){
		String result = "[";
		ListNode<E> curr = head;

		while(curr != null){
			result += curr.getData() + " ";
			curr = curr.getNext();
		}

		result = result.trim() + "]";
		
		System.out.println(result);
	}

	// Pre: at least 2 elems exist in the list
	public BasicLinkedList<E> split(){
		ListNode<E> targetNode = head;
		ListNode<E> pacerNode = head.getNext();

		
		while(pacerNode != null && pacerNode.getNext() != null){
			targetNode = targetNode.getNext();
			pacerNode = pacerNode.getNext().getNext();;

		}

		BasicLinkedList<E> secondList = new BasicLinkedList<E>(targetNode.getNext());
		targetNode.setNext(null);

		return secondList;
	}

	private ListNode<E> removeFirstNode(){
		if(isEmpty()){
			throw new NoSuchElementException("removeFirstNode(): List is empty.");
		}else{
			ListNode<E> dataNode = head;
			head = head.getNext();
			
			dataNode.setNext(null);

			size--;
			return dataNode;
		}
	}

	public void logicalRemove(ListNode<E> target){
		target.setData(target.getNext().getData());
		target.setNext(target.getNext().getNext());
		size--;
	}

	// sorted merge
	public static BasicLinkedList<Integer> merge(BasicLinkedList<Integer> firstList, BasicLinkedList<Integer> secondList){
		ListNode<Integer> newListHead = firstList.getFirst() > secondList.getFirst()? secondList.removeFirstNode(): firstList.removeFirstNode();
		ListNode<Integer> newListTail = newListHead;

		while(!firstList.isEmpty() && !secondList.isEmpty()){
			//System.out.println(firstList.getFirst() +":"+ secondList.getFirst());
			if(firstList.getFirst() > secondList.getFirst()){
				newListTail.setNext(secondList.removeFirstNode());
			}else{
				newListTail.setNext(firstList.removeFirstNode());
			}

			newListTail = newListTail.getNext();
		}

		if(!firstList.isEmpty()){
			newListTail.setNext(firstList.head);
			firstList.head = null;
		}else if(!secondList.isEmpty()){
			newListTail.setNext(secondList.head);
			secondList.head = null;
		}

		return new BasicLinkedList<Integer>(newListHead);
	}
}

