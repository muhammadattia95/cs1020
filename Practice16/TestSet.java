import java.util.Scanner;
import java.util.ArrayList;

public class TestSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set setA = new Set();
		Set setB = new Set();

		System.out.print("Enter number of elements in set A: ");
		final int A_COUNT = sc.nextInt();
	
		System.out.print("Enter elements for set A: ");
		for(int i =0; i<A_COUNT; i++){
			setA.addMember(sc.nextInt());
		}

		System.out.print("Enter number of elements in set B: ");
		final int B_COUNT = sc.nextInt();

		System.out.print("Enter elements for set B: ");
		for(int i =0; i<B_COUNT; i++){
			setB.addMember(sc.nextInt());
		}
		
		System.out.println("Set A: " + setA);
		System.out.println("Set B: " + setB);

		if (setA.isSubset(setB)) {
			System.out.println("Set A is a subset of set B.");
		}
		else {
			System.out.println("Set A is not a subset of set B.");
		}

		if(setA.isSubset(setB) && setB.isSubset(setA)){
			System.out.println("Set A is equal to set B.");
		}else{
			System.out.println("Set A is not equal to set B.");
		}
	}

} 

