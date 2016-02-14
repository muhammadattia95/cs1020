// This program reads in a number of rectangles and compute the
// overlap of all rectangles.
// This program uses the MyRect class.

// Add import statements below
import java.util.*;
import java.awt.*;

public class OverlapRectanglesV3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyRect rect1, rect2;

		System.out.print("How many rectangles? ");
		int numRect = sc.nextInt();

		System.out.print("Enter 2 opposite vertices of first rectangle: ");
		rect1 = readRectangle(sc);
		arrangeVertices(rect1);

		for (int i=2; i<=numRect; i++) {
			System.out.print("Enter 2 opposite vertices of next rectangle: ");
			rect2 = readRectangle(sc);
			arrangeVertices(rect2);
			rect1 = overlap(rect1, rect2);
		}

		int overlapArea = area(rect1);
		if (overlapArea == 0)
			System.out.println("No overlap");
		else {
			System.out.println("Overlap rectangle: " + rect1);
			System.out.println("Overlap area = " + overlapArea);
		}
	}

	// Read data of a rectangle, create a rectangle object
	// and return it.
	public static MyRect readRectangle(Scanner sc) {
		Point vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point vertex2 = new Point(sc.nextInt(), sc.nextInt());
		return new MyRect(vertex1, vertex2);
	}

	// To rearrange the 2 opposite vertices of rect
	// such that the first vertex v1 becomes the bottom-left vertex
	// and the second vertex v2 becomes the top-right vertex.
	public static void arrangeVertices(MyRect rect) {
		// Fill in the code 
		Point vertex3 = new Point(rect.getVertex1().x, rect.getVertex2().y);
		Point vertex4 = new Point(rect.getVertex2().x, rect.getVertex1().y);

		if(rect.getVertex1().x < rect.getVertex2().x){ // vertex1: left, vertex2: right
			if(rect.getVertex1().y < rect.getVertex2().y){ // vertex1: bottom, vertex2: top
				// vertex1: bottom-left
				// vertex2: top-right
				// vertex3: top-left
				// vertex4: bottom-right

				// already sorted, do nothing
			}else{ // vertex1: top, vertex2: bottom
				// vertex1: top-left
				// vertex2: bottom-right
				// vertex3: bottom-left
				// vertex4: top-right

				rect.setVertex1(vertex3);
				rect.setVertex2(vertex4);
			}
		}else{ // vertex1: right, vertex2: left
			if(rect.getVertex1().y < rect.getVertex2().y){ // vertex1: bottom, vertex2: top
				// vertex1: bottom-right
				// vertex2: top-left
				// vertex3: top-right
				// vertex4: bottom-left

				rect.setVertex1(vertex4);
				rect.setVertex2(vertex3);
			}else{ // vertex1: top, vertex2: bottom
				// vertex1: top-right
				// vertex2: bottom-left
				// vertex3: bottom-right
				// vertex4: top-left
				Point temp = rect.getVertex1();
				rect.setVertex1(rect.getVertex2());
				rect.setVertex2(temp);
			}
		}
	}

	// To compute the overlap rectangle of rect1 and rect2
	public static MyRect overlap(MyRect rect1, MyRect rect2) {
		// Fill in the code 
		//

		if(areOverlapping(rect1, rect2)){

			if(rect1.getVertex1().x == rect2.getVertex1().x && rect1.getVertex2().y == rect2.getVertex2().y){
				return rect1;
				//return (rect2.getVertex2().x - rect2.getVertex1().x) * (rect2.getVertex2().y - rect2.getVertex1().y);
			}else{
				//System.out.println("1");
				Point btmLeft = new Point(
						Math.max(rect1.getVertex1().x, rect2.getVertex1().x),
						Math.max(rect1.getVertex1().y, rect2.getVertex1().y)
						);
				Point topRight = new Point(
						Math.min(rect1.getVertex2().x, rect2.getVertex2().x),
						Math.min(rect1.getVertex2().y, rect2.getVertex2().y)
						);

				return new MyRect(btmLeft, topRight);
			}
		}else{
			//System.out.println("2");
			return new MyRect(
					new Point(0,0),
					new Point(0,0)
					);
		}



	}

	// To compute the area of rect
	public static int area(MyRect rect) {

		return Math.abs(rect.getVertex2().x-rect.getVertex1().x) * Math.abs(rect.getVertex2().y-rect.getVertex1().y);
	}

	public static boolean areOverlapping(MyRect rect1, MyRect rect2){
		int minX1 = rect1.getVertex1().x;
		int maxX1 = rect1.getVertex2().x;
		int minY1 = rect1.getVertex1().y;
		int maxY1 = rect1.getVertex2().y;

		int minX2 = rect2.getVertex1().x;
		int maxX2 = rect2.getVertex2().x;
		int minY2 = rect2.getVertex1().y;
		int maxY2 = rect2.getVertex2().y;

		Point btmLeft1 = rect2.getVertex1();
		Point topRight1 = rect2.getVertex2();

		Point btmLeft2 = rect1.getVertex1();
		Point topRight2 = rect1.getVertex2();

		if((btmLeft1.x >= minX1 && btmLeft1.x <= maxX1) || (topRight1.x >= minX1 && topRight1.x <= maxX1) ||
			(btmLeft2.x >= minX2 && btmLeft2.x <= maxX2) || (topRight2.x >= minX2 && topRight2.x <= maxX2)){
			if((btmLeft1.y >= minY1 && btmLeft1.y <=maxY1) || (topRight1.y >=minY1 && topRight1.y <=maxX1) ||
				(btmLeft2.y >=minY2 && btmLeft2.y <=maxY2) || (topRight2.y >=minY2 && topRight2.y <=maxY2)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}

