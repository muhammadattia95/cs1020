/*
 * Author: Wong Kang Fei
 * Mat No: A0138862W
*/

import java.util.*;

public class Measurement{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		final int studentCount = sc.nextInt();

		sc.nextLine(); // consume line feed

		Student tallestStudent = null;
		Student shortestStudent = null;

		for(int i=0;i<studentCount;i++){
			String name = sc.next();
			double height = sc.nextDouble();
			double weight = sc.nextDouble();

			sc.nextLine(); // consume line feed

			Student student = new Student(name, height, weight);

			if(tallestStudent == null){
				tallestStudent = new Student(name, height, weight);
			}else{
				tallestStudent = tallerStudent(student, tallestStudent);
			}

			if(shortestStudent == null){
				shortestStudent = new Student(name, height, weight);
			}else{
				shortestStudent = shorterStudent(student, shortestStudent);
			}

		}

		System.out.printf(shortestStudent.getName() + " is the shortest with BMI equals to %.2f.%n", shortestStudent.getBMI());
		System.out.printf(tallestStudent.getName() + " is the tallest with BMI equals to %.2f.%n", tallestStudent.getBMI());

	}

	private static Student shorterStudent(Student student1, Student student2){
		return student1.getHeight() < student2.getHeight()?
			student1:
			student2;
	}

	private static Student tallerStudent(Student student1, Student student2){
		return student1.getHeight() > student2.getHeight()?
			student1:
			student2;
	}

}

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
