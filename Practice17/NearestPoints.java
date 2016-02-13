import java.util.*;
import java.awt.*;

public class NearestPoints {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> points = new ArrayList<Point>();

		double minDist = Double.POSITIVE_INFINITY;

		int size = sc.nextInt();  // size of list;
		for(int i=0; i<size;i++){
			points.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		
		for(int i=0; i<size;i++){
			
			for(int j=i; j<size; j++){
				if(j == i){
					continue;
				}else{
					double newMinDist =  calcDistance(points.get(i), points.get(j));
					minDist = newMinDist < minDist? newMinDist: minDist;
					//System.out.println(newMinDist);
				}
			}
		}

		System.out.printf("Minimum distance = %.2f\n", minDist);
	}

	private static double calcDistance(Point a, Point b){
		return Math.sqrt(Math.pow((a.x - b.x),2) +Math.pow((a.y - b.y), 2));
	}
}


