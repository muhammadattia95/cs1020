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

class Glider extends Flyer {
	private boolean _isGliding;
	public Glider(String name, String sound) { super(name, sound); }
	public void glide() { if (_isFlying) _isGliding = true; }
	public void stop() { _isFlying = false; _isGliding = false; }
	public void makeSound() {
		if (_isGliding) 
			System.out.println(getName() + " goes whoosh");
		else super.makeSound();
	}

}

public class TestFlyer {
	public static void main(String[] args) {
		Animal cow = new Animal("cow", "moo");
		Flyer parrot = new Flyer("parrot", "squak");
		Glider eagle = new Glider("eagle", "wahhh");
		
		/*
		cow.makeSound();
		parrot.makeSound();
		eagle.makeSound();
		*/
		
		parrot.makeSound();
		parrot.fly();
		parrot.makeSound();
		parrot.stop();
		parrot.makeSound();
		
		eagle.makeSound();
		eagle.fly();
		eagle.makeSound();
		eagle.glide();
		eagle.makeSound();
		eagle.stop();
		eagle.makeSound();


		

	}
}
