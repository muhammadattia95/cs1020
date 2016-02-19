/* Fix in Q1 and copy over */
class Animal {
	private String _name; // e.g. Cow
	private String _sound; // e.g. Moo
	public Animal(String name, String sound) {
		_name = name; _sound = sound; }
	public String getName() { return _name; }
	public void makeSound() {
		System.out.println(_name + " goes " + _sound); }
}

class Flyer extends Animal { 
	protected String _name;
	protected String _sound;
	protected boolean _isFlying;
	public Flyer(String name, String sound) { 
		super(name, sound); 
	}
	public void makeSound() {
		if (_isFlying)
			System.out.println(getName() + " goes flap");
		else super.makeSound();
	}
	public void fly() { _isFlying = true; }
	public void stop() { _isFlying = false; }
}
/* ----------------------- */

public class NewMcDonald {
	private Animal[] _farm; // New McDonald had a farm (still has now)
	private static final int SIZE = 5; // Fixed farm size of 5
	
	public NewMcDonald() {
		/* TODO: Create your farm, an Animal array */
		_farm = new Animal[SIZE];
		fillThisFarm();
	}
	
	public void makeSomeNoise() {
		/* TODO: Make sound(s) without looking out for Flyers...! */
		for(Animal animal: _farm){
			animal.makeSound();
		}
	}
	
	public void fillThisFarm() {
		_farm[0] = new Flyer("Parrot", "squak");
		_farm[1] = new Animal("Cow", "moo");
		_farm[2] = new Flyer("Mosquito", "buzz");
		((Flyer)_farm[2]).fly();
		_farm[3] = new Animal("Sheep", "mehh");
		_farm[4] = new Animal("Fish", "blurp");
	}

	public static void main(String[] args){
		NewMcDonald newMcDonald = new NewMcDonald();
		newMcDonald.makeSomeNoise();
	}

}

