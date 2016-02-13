// MyRect class
import java.awt.*;

class MyRect {

	/************** Data members **********************/
	private Point vertex1, vertex2;

	/************** Constructors **********************/

	public MyRect() {
		this(0, 0, 1, 1); //Default rectangle with vertices (0,0) and (1,1)
	}

	public MyRect(Point v1, Point v2) {
		setVertex1(new Point(v1));
		setVertex2(new Point(v2));
	}

	public MyRect(int v1X, int v1Y, int v2X, int v2Y) {
		setVertex1(new Point(v1X, v1Y));
		setVertex2(new Point(v2X, v2Y));
	}

	/**************** Accessors ***********************/
	public Point getVertex1() {
		return vertex1;
	}

	public Point getVertex2() {
		return vertex2;
	}

	/**************** Mutators ************************/
	public void setVertex1(Point pt) {
		this.vertex1 = pt;

	}

	public void setVertex2(Point pt) {
		this.vertex2 = pt;

	}

	/***************** Overriding methods ******************/
	// Overriding toString() method
	public String toString() {
		// fill in the code
		return "[("+vertex1.x+", "+vertex1.y+"); ("+vertex2.x+", "+vertex2.y+")]";
	}

	// Overriding equals() method
	// precondition: vertex1 must be bottom-left, vertex2 must be top-right, prearranged.
	public boolean equals(Object obj) {
		// fill in the code
		if(obj instanceof MyRect){
			MyRect rect = (MyRect) obj;
			return this.toString().equals(rect.toString());
		}else{
			return false;
		}
	}
}

