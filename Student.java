package course;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	static Scanner kB = new Scanner(System.in);

	
	String firstName;
	String lastName;
	int age;
	int ID;
	double averageGrade = 0;
	
	ArrayList<Grade> grades = new ArrayList<Grade>();
	
	public Student(String firstName, String lastName, int age, int ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	//change grade of any assignment, test, or exam
	public void changeGrade() {
		System.out.println("");
		for(Grade grade: grades) {
			System.out.println(grade.name + ": " + grade.grade + "%");
		}
		System.out.println("Enter the name of the assigment, test, or exam to change grade");
		String gN = kB.nextLine();
		System.out.println("Now enter the given grade of " + gN);
		double gG = Double.parseDouble(kB.nextLine());
		for(Grade grade: grades) {
			if(gN.equalsIgnoreCase(grade.name)) {
				grade.setGrade(gG);
			}
		}
		updateAverageGrade();
	}
	
	public void updateAverageGrade() {
		double totalWeight = 0;
		double totalPercentage = 0;
		for(Grade grade: grades) {
			totalWeight += grade.weight;
			totalPercentage += (grade.grade*grade.weight);
		}
		averageGrade = totalPercentage/totalWeight;
	}
	
	public String toString() {
		System.out.println(lastName + ", " + firstName);
		System.out.println(averageGrade);
		for(Grade grade: grades) {
			System.out.println(grade.name + ": " + grade.grade + "% (WEIGHT: " + grade.weight + ")");
		}
		return "";
	}
	
	
}
