import java.util.*;

class Knob {

	// Data attributes
	boolean isOn;      // is the device on?
	String currPos;    // current position of knob
	String targetPos;  // target position of knob

	// Constructor
	public Knob(boolean state, String newCurrPos, String newTargetPos) { 
		// fill in the code
		this.isOn = state;
		this.currPos = newCurrPos;
		this.targetPos = newTargetPos;
	}

	// Determine whether the device is on or off after num moves
	public boolean deviceIsOn(int num) {
		if(num%2 != 0){
			isOn = !isOn;
		}

		return isOn;

	}

	// Compute the least number of moves to turn the knob
	public int numOfMoves() {                       
		int moveCount = 0;

		do{
			turnCW();
			moveCount++;
		}while(!currPos.equals(targetPos));
		return moveCount; // this is a stub
	}

	public void turnCW(){
		switch(currPos){
			case "up":
				currPos = "right";
				break;
			case "right":
				currPos = "down";
				break;
			case "down":
				currPos = "left";
				break;
			case "left":
				currPos = "up";
				break;
		}
	}
}

