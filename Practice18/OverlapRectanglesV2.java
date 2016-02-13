// This program reads in 4 vertices representing the opposite vertices
// of 2 rectangles and computes the overlap area of the rectangles.
// This program uses the MyRect class.

// Add import statements below
import java.util.*;
import java.awt.*;

public class OverlapRectanglesV2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
		Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());
		MyRect rect1 = new MyRect(rect1Vertex1, rect1Vertex2);

		System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
		Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());
		MyRect rect2 = new MyRect(rect2Vertex1, rect2Vertex2);

		arrangeVertices(rect1);
		arrangeVertices(rect2);

   		System.out.println("1st rectangle: " + rect1);
   		System.out.println("2nd rectangle: " + rect2);

		if (rect1.equals(rect2))
			System.out.println("They are identical.");
		else
			System.out.println("They are not identical.");

		System.out.println("Overlap area = " + overlapArea(rect1, rect2));
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

	// To compute the overlap area of rectangles rect1 and rect2
	public static int overlapArea(MyRect rect1, MyRect rect2) {
		// Fill in the code 
		//

		if(areOverlapping(rect1, rect2)){
			
			if(rect1.getVertex1().x == rect2.getVertex1().x && rect1.getVertex2().y == rect2.getVertex2().y){
				return (rect2.getVertex2().x - rect2.getVertex1().x) * (rect2.getVertex2().y - rect2.getVertex1().y);
			}else{
				Point btmLeft = new Point(
					Math.max(rect1.getVertex1().x, rect2.getVertex1().x),
					Math.max(rect1.getVertex1().y, rect2.getVertex1().y)
				);
				Point topRight = new Point(
					Math.min(rect1.getVertex2().x, rect2.getVertex2().x),
					Math.min(rect1.getVertex2().y, rect2.getVertex2().y)
				);


				int area = Math.abs(topRight.x - btmLeft.x) * Math.abs(topRight.y - btmLeft.y);

				return area;
			}
		}else{
			return 0;
		}

		 		
	}

	public static boolean areOverlapping(MyRect rect1, MyRect rect2){
		int minX1 = rect1.getVertex1().x;
		int maxX1 = rect1.getVertex2().x;

		int minX2 = rect2.getVertex1().x;
		int maxX2 = rect2.getVertex2().x;

		Point btmLeft1 = rect2.getVertex1();
		Point topRight1 = rect2.getVertex2();

		Point btmLeft2 = rect1.getVertex1();
		Point topRight2 = rect1.getVertex2();

		return (btmLeft1.x >= minX1 && btmLeft1.x <= maxX1) || (topRight1.x >= minX1 && topRight1.x <= maxX1) ||
			(btmLeft2.x >= minX2 && btmLeft2.x <= maxX2) || (topRight2.x >= minX2 && topRight2.x <= maxX2) ;
	}

}

