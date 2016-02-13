/*
 * Author: Wong Kang Fei
 * Mat No: A0138862W
*/

import java.util.*;

public class MeasurementAlt{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		final int studentCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		Object[] tallestStudent = null;
		Object[] shortestStudent = null;

		for(int i=0;i<studentCount;i++){
			String name = sc.next();
			double height = sc.nextDouble();
			double weight = sc.nextDouble();

			sc.nextLine(); // consume line feed

			Object[] student = new Object[]{name, height, weight};

			if(tallestStudent == null){
				tallestStudent = new Object[]{name, height, weight};
			}else{
				tallestStudent = tallerStudent(student, tallestStudent);
			}

			if(shortestStudent == null){
				shortestStudent = new Object[]{name, height, weight};
			}else{
				shortestStudent = shorterStudent(student, shortestStudent);
			}

		}

		System.out.printf(shortestStudent[0] + " is the shortest with BMI equals to %.2f.%n", calcStudentBMI(shortestStudent));
		System.out.printf(tallestStudent[0] + " is the tallest with BMI equals to %.2f.%n", calcStudentBMI(tallestStudent));

	}

	private static Object[] shorterStudent(Object[] student1, Object[] student2){
		return (double)student1[1] < (double)student2[1]?
			student1:
			student2;
	}

	private static Object[] tallerStudent(Object[] student1, Object[] student2){
		return (double)student1[1] > (double)student2[1]?
			student1:
			student2;
	}

	private static double calcStudentBMI(Object[] student){
		double height = (double) student[1];
		double weight = (double) student[2];

		return weight/(height*height/10000);
	}

}
/*
class Student{
	private String name;
	private double height; // in centimeters
	private double weight; // in kilograms

	public Student(String name, double height, double weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName(){
		return name;
	}

	public double getHeight(){
		return height;
	}

	public double getWeight(){
		return weight;
	}

	public double getBMI(){
		return weight / (height*height/10000);
	}
}
*/
