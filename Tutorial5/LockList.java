import java.util.*;

public class LockList<E> extends BasicLinkedList<E>{

	public static void main(String[] args){
		LockList<String> ll = new LockList<String>();

		ll.addFirst("A");
		ll.addFirst("B");
		ll.addFirst("C");
		
		ll.print();

		ll.lockNode(ll.getSecondNode());

		ll.removeFirst();
		ll.print();
		ll.removeFirst();
		ll.print();
	}
	
	public void lockNode(ListNode<E> node){
		if(node instanceof LockListNode){
			LockListNode<E> dataNode = (LockListNode<E>) node;
			dataNode.lock();
		}
	}

	// for testing only
	// assume at least 3 nodes
	private ListNode<E> getSecondNode(){
		return head.getNext();
	}

	@Override
	public void addFirst(E data){
		head = new LockListNode<E>(data, head);
		size++;
	}

	@Override
	public E removeFirst(){
		if(isEmpty()){
			throw new NoSuchElementException("removeFirst(): List is empty.");
		}else{
			LockListNode<E> dataNode = (LockListNode<E>) head;

			if(!dataNode.isLocked()){
				head = dataNode.getNext();
				size--;
			}

			return dataNode.getData();
		}
	}
}
