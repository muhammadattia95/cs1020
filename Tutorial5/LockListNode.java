public class LockListNode<E> extends ListNode<E>{
	private boolean theLock;

	public LockListNode(E data){
		this(data, null);
	}

	public LockListNode(E data, ListNode<E> next){
		super(data, next);
		this.theLock = false;
	}

	public boolean isLocked(){
		return this.theLock;
	}

	public void lock(){
		this.theLock = true;
	}

	public void unlock(){
		this.theLock = false;
	}

	public void toggle(){
		this.theLock = !theLock;
	}
}
