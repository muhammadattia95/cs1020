import java.awt.*;

public class Main{
	public static void main(String[] args){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		System.out.println("=====swap1=====");
		swap1(a, b);
		System.out.println("a:" + a);
		System.out.println("b:" + b);

		MyInteger a2 = new MyInteger(Integer.parseInt(args[0]));
		MyInteger b2 = new MyInteger(Integer.parseInt(args[1]));
		
		System.out.println("=====swap2====="); 
		MyInteger.swap2(a2, b2);
		System.out.println("a:" + a2.x);
		System.out.println("b:" + b2.x);
		
		int[] arr = new int[999];
		int a3 = Integer.parseInt(args[0]);
		int b3 = Integer.parseInt(args[1]);
		
		arr[a3] = a3;
		arr[b3] = b3;

		System.out.println("=====swap3====="); 
		swap3(arr, a3, b3);
		System.out.println("a:" + arr[a3]);
		System.out.println("b:" + arr[b3]);

		System.out.println("=====diamonds=====");
		Point[] centers = new Point[]{
			new Point(10, 20),
			new Point(20, 10),
			new Point(0, 0)
		};
		int width = 1;
		int height = 3;

		Point[][] diamonds = Diamond.drawDiamonds(width, height, centers);

		for(Point[] diamond: diamonds){
			System.out.println("!!!!!diamond!!!!!");
			for(Point vertex: diamond){
				System.out.println("x:"+vertex.x+" y:"+vertex.y);
			}
		}
	}

	public static void swap1(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}

	public static void swap3(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

class MyInteger{

	public int x;

	public MyInteger(int n){
		x = n;
	}

	public static void swap2(MyInteger a, MyInteger b){
		int temp = a.x;
		a.x = b.x;
		b.x = temp;
	}
}

class Diamond{
	/*
	public Point top;
	public Point right;
	public Point bottom;
	public Point left;

	public Diamond(Point top, Point right, Point bottom, Point left){
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
	}*/

	public static Point[][] drawDiamonds(int width, int height, Point[] centers){
		Point[][] diamonds = new Point[centers.length][4];
		for(int i = 0; i< centers.length; i++){
			diamonds[i] = calcVertices(width, height, centers[i]);
		}

		return diamonds;
	}

	public static Point[] calcVertices(int width, int height, Point center){
		return new Point[] {
			new Point(center.x, center.y+height),
			new Point(center.x+width, center.y),
			new Point(center.x, center.y-height),
			new Point(center.x-width, center.y)
		};
	}
}
