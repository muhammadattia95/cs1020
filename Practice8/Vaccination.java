// Testing the Scanner class.
// // This program reads the name, age and vaccination status of
// // some children and computes their average age and percentage
// // of children who are vaccinated.
//
// // Add import statement(s) below
import java.util.*;
//
public class Vaccination {
	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of children: ");
		final int CHILDREN_COUNT = sc.nextInt();

		sc.nextLine(); // consume line feed

		System.out.println("Number of children is "+ CHILDREN_COUNT);

		int totalAge = 0;
		int numVaccinated = 0;

		for(int i=0; i<CHILDREN_COUNT; i++){
			
			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.println("Name is \""+name+"\"");

			System.out.print("Age: ");
			int age = sc.nextInt();
			totalAge += age;

			sc.nextLine(); // consume line feed

			System.out.println("Age is "+ age);

			System.out.print("Vaccinated for chickenpox? ");
			boolean vaccinated = sc.nextBoolean();
			numVaccinated += vaccinated? 1: 0;

			sc.nextLine(); // consume line feed

			System.out.println(vaccinated? "Vaccinated for chickenpox" : "Not vaccinated for chickenpox");

		}

		double averageAge = (double)totalAge/ (double)CHILDREN_COUNT;
		double percentageVaccinated = (double)numVaccinated/ (double) CHILDREN_COUNT*100;

		System.out.printf("Average age is %.2f%n", averageAge);
		System.out.printf("Percentage of children vaccinated is %.2f%%%n", percentageVaccinated);
		//
		// 											// Fill in the code below
	}
}


