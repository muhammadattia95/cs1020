class GenericTriple1<T, U, V>{
	private Pair<T, Pair<U, V>> triple;
	
	public GenericTriple1(T obj1, U obj2, V obj3){
		//
	}

	public Pair<T, Pair<U,V>> getTriple(){
		return triple;
	}
}

class GenericSingle2<T, U, V> extends Pair<T,V>{
	private U _objCenter;

	public GenericSingle2(T pobjLeft, U pobjCenter, V pobjRight){
		super(pobjLeft, pobjRight);
		this._objCenter = pobjCenter;
	}

	public U getCenter(){
		return _objCenter;
	}
}

public class Pair<T, S>{
	private T _objLeft;
	private S _objRight;

	public Pair(T pobjLeft, S pobjRight){
		this._objLeft = pobjLeft;
		this._objRight = pobjRight;
	}

	public T getLeft(){
		return _objLeft;
	}

	public S getRight(){
		return _objRight;
	}

	public String toString(){
		return "("+_objLeft + ","+_objRight+")";
	}
}
