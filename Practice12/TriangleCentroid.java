import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class TriangleCentroid {

	// Returns the centroid of a triangle with 
	// 3 vertices v1, v2 and v3
	public static Point2D.Double centroid(Point v1, Point v2, Point v3) {
		return new Point2D.Double((v1.getX()+v2.getX()+v3.getX())/3, (v1.getY()+v2.getY()+v3.getY())/3);
	}
	//
	public static void main(String[] args) {
		// 						// Fill in the code 
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 3 vertices: ");
		Point v1 = new Point(sc.nextInt(), sc.nextInt());
		Point v2 = new Point(sc.nextInt(), sc.nextInt());
		Point v3 = new Point(sc.nextInt(), sc.nextInt());

		sc.nextLine(); // consume line feed
		//
		System.out.println("Centroid at " + centroid(v1, v2, v3));
	}
}
//
//
