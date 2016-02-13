import java.util.*;

public class Main{
	public static void main(String[] args){
		Zip zip = new Zip();
		String s1 = "AAAAABBBAA";
		String s2 = "AAAAABBBBCCCDDEFGGGGHHI";
		for(Pair pair : zip.compressString(s2)){
			System.out.println(pair);
		};

		//Book book = new Book();
		Book book = new Book<Animal>();
		book.add(new Animal());
		//Book<Animal> book = new Book();
		//Book<Animal> book = new Book<Animal>();
		//Book<Flyer> book = new Book<Animal>();
		//Book<Animal> book = new Book<Flyer>();
		//Writing<Flyer> writing = new Book<Flyer>();
		//Book<Flyer> book = new Writing<Flyer>();
		//Book<Flyer> book = new Birdopedia();


		//http://www.javabeat.net/how-to-use-extends-in-generics/
		//ArrayList<? extends Animal> a = new ArrayList<Flyer>();
		//a.add(null);
		//a.add(new Flyer());
	}


}

class Pair<T, S>{
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

class Zip{
	public ArrayList<Pair<Character, Integer>> compressString(String input){
		ArrayList<Pair<Character, Integer>> pairs = new ArrayList<Pair<Character, Integer>>();
		char[] inputChars = input.toCharArray();

		char temp = inputChars[0];
		int comboBreakerIndex = 0;

		for(int i=0; i<inputChars.length; i++){
			if(i == inputChars.length -1){
				// can try to add at outside of the for-loop
				if(inputChars[i] == temp){
					pairs.add(new Pair<Character, Integer>(temp, i-comboBreakerIndex+1));
				}else{
					pairs.add(new Pair<Character, Integer>(temp, i-comboBreakerIndex));
					pairs.add(new Pair<Character, Integer>(inputChars[i], 1));
				}
			}else if(inputChars[i] == temp){
				continue;
			}else{
				pairs.add(new Pair<Character, Integer>(temp, i-comboBreakerIndex));
				temp = inputChars[i];
				comboBreakerIndex = i;
			}

		}
			
		return pairs;
	}
}

class Animal{};
class Flyer extends Animal{};
class Glider extends Flyer{};

class Writing<T>{};
class Book<T> extends Writing<T>{};
class Birdopedia extends Book<Flyer>{};
