// This program reads in information of a number of knobs.
// For each knob, its current state, current position and
// target position. It then computes the state of each knob after
// the required number of stops, and the total stops of all knobs.

// Add import statement(s) below
import java.util.*;

public class TurnKnobs{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int knobCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		// Declare the necessary variables
		ArrayList<Knob> knobs = new ArrayList<Knob>();

		// Read input and process them accordingly
		for(int i=0; i<knobCount; i++){
			String[] parameters = sc.nextLine().split(" ");

			if(parameters[0].equals("on")){
				knobs.add(new Knob(true, parameters[1], parameters[2]));
			}else{
				knobs.add(new Knob(false, parameters[0], parameters[1]));

			}
		}

		// Output the result
		// Use the given println() statements below to ensure that 
		// your outputs are in the right format.
		int totalMoves = 0;
		for(Knob knob : knobs){
			int moveCount = knob.numOfMoves();
			totalMoves+=moveCount;
			System.out.println(knob.deviceIsOn(moveCount)? "on": "off");
		}


		// Print total number of stops 

		System.out.println("Total stop(s) = " + totalMoves);
	}
}

