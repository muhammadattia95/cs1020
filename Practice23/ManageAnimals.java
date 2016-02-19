import java.util.Scanner;

public class ManageAnimals {
	private Zoo<Animal> zoo; // zoo only contains Monkeys or Chimps
	private Zoo<Bird> birdPark;
	public ManageAnimals() {
		zoo = new Zoo<Animal>();
	 	birdPark = new Zoo<Bird>(); 
	}
	public void listAnimals () {
		System.out.println("Zoo: " + zoo); 
		System.out.println("Bird Park: " + birdPark);
	}
	public void addAnimal(String specie, String name) { // INCOMPLETE
		switch (specie) {
			// Substitutability in action (2) -
			//	Animal expected, Monkey (or Chimp) provided
			case "Monkey":
				zoo.addAnimal(new Monkey(name));
				return;
			case "Chimp":
				zoo.addAnimal(new Chimp(name));
				return;
			case "Bird":
			case "Kingfisher":
			case "Chick":
			case "Duck":
			case "Roadrunner":
			default:
				birdPark.addAnimal(new Bird(name, specie));
				return;
		}
	}
	public static void main(String[] args) {
		ManageAnimals manager = new ManageAnimals();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
			manager.addAnimal(sc.next(), sc.next());
		sc.close();
		manager.listAnimals();
	}
}
