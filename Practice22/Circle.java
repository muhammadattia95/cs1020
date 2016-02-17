// Circle class:
//   Instance attributes: colour, radius
// This class is given and should not be modified.
// Aaron Tan

class Circle {

	/************** Data members **********************/
	protected String colour;
	protected double radius;

	/************** Constructors **********************/
	// Default constructor creates a yellow, radius 10.0 circle

	public Circle() {
		this("yellow", 10.0);
	}

	public Circle(String colour, double radius) {
		setColour(colour);
		setRadius(radius);
	}

	/**************** Accessors ***********************/
	public String getColour() {
		return this.colour;   // 'this' is optional here
	}

	public double getRadius() {
		return this.radius;   // 'this is optional here
	}

	/**************** Mutators ************************/
	public void setColour(String colour) {
		this.colour = colour;  // 'this' is required here
	}

	public void setRadius(double radius) {
		this.radius = radius;  // 'this' is required here
	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		return "[" + getColour() + ", " + getRadius() + "]";
	}

	// Overriding equals() method
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle circle = (Circle) obj;
			return this.getColour().equals(circle.getColour()) &&
			       this.getRadius() == circle.getRadius();
		}
		else
			return false;
	}
}

