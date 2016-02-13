import java.awt.*;
import java.util.*;

class CentredBall {

	/************** Data members **********************/
	private static int quantity = 0; 

	private String colour;
	private double radius;
	private Point  centre;

	/************** Constructors **********************/
	public CentredBall(){
		this.colour = "yellow";
		this.radius = 10;
		this.centre = new Point(0,0);
		this.quantity++;
	}

	public CentredBall(String colour, double radius, Point centre){
		this.colour = colour;
		this.radius = radius;
		this.centre = centre;
		this.quantity++;
	}

	public CentredBall(String colour, double radius, int xCoord, int yCoord){
		this.colour = colour;
		this.radius = radius;
		this.centre = new Point(xCoord, yCoord);
		this.quantity++;
	}

	/**************** Accessors ***********************/
	public String getColour(){
		return colour;
	}

	public double getRadius(){
		return radius;
	}

	public Point getCentre(){
		return centre;
	}

	public static int getQuantity(){
		return quantity;
	}

	/**************** Mutators ************************/
	public void setColour(String colour){
		this.colour = colour;
	}

	public void setRadius(double radius){
		this.radius = radius;
	}

	public void setPoint(Point point){
		this.centre = centre;
	}


	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return "[colour="+colour+", radius="+radius+", centre=("+centre.x+","+centre.y+")]";
	}
	//
	// 			// Overriding equals() method
	public boolean equals(Object obj) {
		if(obj instanceof CentredBall){
			CentredBall centredBall = (CentredBall) obj;
			return colour.equals(centredBall.getColour()) &&
				radius == centredBall.getRadius() &&
				centre.x == centredBall.getCentre().x &&
				centre.y == centredBall.getCentre().y;
		}else{
			return false;
		}
			
	}
/*
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		CentredBall[] centredBalls = new CentredBall[3];

		boolean isFirstAndSecondSame = false;
		CentredBall largestCentredBall = null;

		for(int i=0; i<centredBalls.length; i++){
			switch(i){
				case 0:
					System.out.println("1st ball");
					break;
				case 1:
					System.out.println("2nd ball");
					break;
				case 2:
					System.out.println("3rd ball");
					break;
			}
			
			System.out.print("Enter colour, radius and centre: ");
			centredBalls[i] = new CentredBall(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextInt());
			sc.nextLine(); // consume line feed

			if(i == 1){
				isFirstAndSecondSame = centredBalls[0].equals(centredBalls[1]);
			}

			if(largestCentredBall == null){
				largestCentredBall = centredBalls[i];
			}else if(centredBalls[i].getRadius() > largestCentredBall.getRadius()){
				largestCentredBall = centredBalls[i];
			}
		}

		System.out.println("1st and 2nd balls are "+ (isFirstAndSecondSame? "the same." : "not the same."));
		System.out.println("The largest ball created is:");
		System.out.println(largestCentredBall);
	}
	*/
}
//
// 					
