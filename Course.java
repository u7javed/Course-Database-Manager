package course;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Course{
	
	static Scanner kB = new Scanner(System.in);

	//course info
	String courseName;
	int courseID;
	
	//instructor information
	String instructorFirstName;
	String instructorLastName;
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Course(String courseName, int courseID, String instructorFirstName, String instructorLastName) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.instructorFirstName = instructorFirstName;
		this.instructorLastName = instructorLastName;
	}

	//setters and getters
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getInstructorFirstName() {
		return instructorFirstName;
	}

	public void setInstructorFirstName(String instructorFirstName) {
		this.instructorFirstName = instructorFirstName;
	}

	public String getInstructorLastName() {
		return instructorLastName;
	}

	public void setInstructorLastName(String instructorLastName) {
		this.instructorLastName = instructorLastName;
	}
	
	//utility functions
	
	//add a student
	public void addStudent() {
		System.out.println("Enter the student's first name:");
		String firstName = kB.nextLine();
		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
		System.out.println("Enter student's last name:");
		String lastName = kB.nextLine();
		lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
		System.out.println("Enter student's age:");
		int age = Integer.parseInt(kB.nextLine());
		studentList.add(new Student(firstName, lastName, age, generateStudentID()));
	}
	
	//generate a random 7-digit student id that is unique;
	public int generateStudentID() {
		int id = 0;
		boolean isValid = false;
		while(!isValid) {
			id = (int)(Math.random()*((9999999 - 1000000) + 1)) + 1000000;
			isValid = true;
			for(Student student: studentList) {
				if(id == student.ID) {
					isValid = false;
				}
			}
		}
		return id;
	}
	
	public void viewGrades() {
		System.out.println("");
		for(Student student: studentList) {
			System.out.println(student.lastName + ", " + student.firstName + " (" + student.ID + ") " + student.averageGrade);
		}
	}
	//string representation of class
	public String toString() {
		System.out.println(courseName + ": " + courseID);
		System.out.println("Instructor: " + instructorLastName + ", " + instructorFirstName);
		System.out.println("Student List:\n");
		for(Student student: studentList) {
			System.out.println(student.lastName + ", " + student.firstName + " (" + student.ID + ")");
		}
		return "";
	}
	
}
