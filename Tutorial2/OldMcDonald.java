/*
 *	Author: Wong Kang Fei
 *	Mat No: A0138862W
 *
 * */

public class OldMcDonald {
	private Animal[] _farm; // Old McDonald had a farm (still has now)
	private static final int SIZE = 3; // Fixed farm size

	public OldMcDonald() {
		_farm = new Animal[]{
			new Animal("Cow", "Moo"),
				new Animal("Dog", "Woof"),
				new Animal("Duck", "Quack")
		};
	}

	public void sing() {
		for (int i = 0; i < SIZE; i++){
			System.out.println("Old McDonald had a farm, E-I-E-I-O");
			System.out.println("And on his farm he had a "+_farm[i].getType()+", E-I-E-I-O");
			System.out.println("With a "+_farm[i].getSound()+" "+_farm[i].getSound()+" here and a "+_farm[i].getSound()+" "+_farm[i].getSound()+" there...");
		}

	}

	public static void main(String[] args) {
		(new OldMcDonald()).sing();
	}
}

class Animal {
	private String type;
	private String sound;

	public Animal(String type, String sound){
		this.type = type;
		this.sound = sound;
	}

	public String getType(){
		return type;
	}

	public String getSound(){
		return sound;
	}

}


