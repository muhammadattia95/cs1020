import java.util.ArrayList;
import java.util.Collections;

public class Coordinate implements Comparable<Coordinate>{
	private double _x;
	private double _y;
	private double _z;
	
	public Coordinate(double x, double y, double z) {
		_x = x;
		_y = y;
		_z = z;
	}

	public double getX() { return _x; }
	public double getY() { return _y; }
	public double getZ() { return _z; }

	public double distanceFromOrigin(){
		return Math.sqrt(_x*_x + _y*_y + _z*_z);
	}

	public int compareTo(Coordinate c){
		// loss of precision, will not sort properly
		//return (int) (distanceFromOrigin() - c.distanceFromOrigin());

		if(distanceFromOrigin() > c.distanceFromOrigin()){
			return 1;
		}else if(distanceFromOrigin() < c.distanceFromOrigin()){
			return -1;
		}else{
			return 0;
		}

	}
	
	
	// Here is a tester for you to use. Uncomment it after you have finished making this class sortable
	
	public static void main(String[] args) {
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
		coords.add( new Coordinate(0,1,1) );
		coords.add( new Coordinate(2,3,5) );
		coords.add( new Coordinate(1,4,0) );
		coords.add( new Coordinate(1,1,1) );
		coords.add( new Coordinate(1,1,0) );
		coords.add( new Coordinate(3,2,5) );
		
		Collections.sort(coords);
		
		for (int i=0; i<coords.size(); i++) {
			Coordinate current = coords.get(i);
			double distance = Math.sqrt(current.getX()*current.getX()
									    + current.getY()*current.getY()
									    + current.getZ()*current.getZ());
									   
			System.out.println("Rank " + i + ": (" + current.getX() + ", " 
			                   + current.getY() + ", " + current.getZ() 
							   + ") with distance " + distance);
		}
	}
	
}
