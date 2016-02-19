class GenericTriple1<T, U, V>{
	private Pair<T, Pair<U, V>> triple;
	
	public GenericTriple1(T obj1, U obj2, V obj3){
		triple = new Pair<T, Pair<U,V>>(obj1, new Pair<U, V>(obj2, obj3));
	}

	public Pair<T, Pair<U,V>> getTriple(){
		return triple;
	}

	public T getLeft(){
		return triple.getLeft();
	}

	public U getCenter(){
		return triple.getRight().getLeft();
	}

	public V getRight(){
		return triple.getRight().getRight();
	}
}

class GenericTriple2<T, U, V> extends Pair<T,V>{
	private U _objCenter;

	public GenericTriple2(T pobjLeft, U pobjCenter, V pobjRight){
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

	public static void main(String[] args){
		// or create a Person class extends GenericTriple1 or 2
		GenericTriple1<String, Double, Double> person1 = new GenericTriple1<String, Double, Double>("WKF", 55.5, 174.0);
		GenericTriple2<String, Double, Double> person2 = new GenericTriple2<String, Double, Double>("KNN", 100.0, 14.5);
	}
}
