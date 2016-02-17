// CentredCircle class:
//   Subclass of Circle
//   Instance attribute: centre

// Add import statement(s) below
import java.awt.geom.Point2D;

class CentredCircle extends Circle {

	/************** Data members **********************/
	protected Point2D.Double centre;

	/************** Constructors **********************/
	// Default constructor creates a yellow circle 
	// with radius 10.0 circle and centre at (0,0)

	public CentredCircle() {
		// Fill in the code
		this.colour = "yellow";
		this.radius = 10.0;
		this.centre = new Point2D.Double(0, 0);
	}

	public CentredCircle(String colour, double radius, Point2D.Double centre) {
		// Fill in the code
		this.colour = colour;
		this.radius = radius;
		this.centre = centre;
	}

	/**************** Accessor ***********************/
	public Point2D.Double getCentre() {
		// Fill in the code
		return centre;

	}

	/**************** Mutator ************************/
	public void setCentre(Point2D.Double centre) {
		// Fill in the code
		this.centre = centre;
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		// Fill in the code
		return "[" +this.colour+", "+this.radius+", ("+centre.getX()+","+centre.getY()+")]";
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if(super.equals(obj) && obj instanceof CentredCircle){
			CentredCircle centredCircle = (CentredCircle) obj;
			return this.getCentre().getX() == centredCircle.getCentre().getX() &&
				this.getCentre().getY() == centredCircle.getCentre().getY();
		};
		return false;
	}
}

