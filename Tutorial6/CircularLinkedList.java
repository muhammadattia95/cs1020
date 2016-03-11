public class CircularLinkedList<E> {
	
	public int _size;
	public ListNode<E> _head;
	public ListNode<E> _tail;
	
	public void addFirst(E element) {
		_size++;
		_head = new ListNode<E>(element, _head);
		if (_tail == null)
			_tail = _head;
		_tail.setNext(_head);
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[");
		if (_head != null) {
			ListNode<E> curr = _head;
			while (curr != _tail) {
				buffer.append(curr.getElement() + ", ");
				curr = curr.getNext();
			}
			buffer.append(_tail.getElement());
		}
		buffer.append("]");
		return buffer.toString();
	}
	
	public void swap(int index) {
		if(_size < 1){
			return;
		}

		/* TODO : UNDONE */
		ListNode<E> prev1 = null;
		ListNode<E> prev2 = null;
		ListNode<E> curr = _head;

		while(index != 0){
			prev1 = prev2;
			prev2 = curr;
			curr = curr.getNext();
			index--;
		}

		prev2.setNext(curr.getNext());
		prev1.setNext(curr);
		curr.setNext(prev2);

		if(index == 0){
			_head = curr;
		}else if(index == _size -2){
			_tail = prev2;
		}else if(index == _size -1){
			_head = prev2;
			_tail = curr;
		}
		
		// not done. 2 elements?
		/*
		if(_head == curr && _tail == prev2){
			_head = prev2;
			_tail = curr;
		}else if(_head == prev2 && _tail == curr){
			_head = curr;
			_tail = prev2;
		}

		if(_head == curr){
			_head = prev2;
		}else if(_head == prev2){
			_head = curr;
		}

		if(_tail == curr){
			_tail = prev2;
		}else if(_tail == prev2){
			_tail == curr;
		}
		*/

	}
	
	public static void main(String[] args) {
		CircularLinkedList<Character> list = new CircularLinkedList<Character>();
		for (int offset = 12; offset >= 0; offset--) // 13 chars
			list.addFirst((char)('a' + offset));
		System.out.println(list.toString());
		list.swap(15);
		System.out.println(list.toString());
	}
}

