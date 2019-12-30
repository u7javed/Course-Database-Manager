package course;

import java.util.Scanner;

public class Main {
	
	static Scanner kB = new Scanner(System.in);
	static Course newCourse;

	public static void main(String[] args) {
		System.out.println("Enter the course name: ");
		String cN = kB.nextLine();
		cN = cN.substring(0, 1).toUpperCase() + cN.substring(1).toLowerCase();
		System.out.println("Enter the course ID");
		int cID = Integer.parseInt(kB.nextLine());
		System.out.println("Enter Instructor's first name: ");
		String fN = kB.nextLine();
		fN = fN.substring(0, 1).toUpperCase() + fN.substring(1).toLowerCase();
		System.out.println("Enter Instructor's last name: ");
		String lN = kB.nextLine();
		lN = lN.substring(0, 1).toUpperCase() + lN.substring(1).toLowerCase();
		newCourse = new Course(cN, cID, fN, lN);
		String input = "";
		do {
			System.out.println("ClassList\n"
					+ "Add Student\n"
					+ "View Grades\n"
					+ "Add Assignment\n"
					+ "Change Grades\n"
					+ "Exit");
			input = kB.nextLine();
			if(input.equalsIgnoreCase("ClassList")) {
				System.out.println(newCourse.toString());
			} else if(input.equalsIgnoreCase("Add Student")) {
				addStudent();
			} else if(input.equalsIgnoreCase("view grades")) {
				viewGrades();
			} else if(input.equalsIgnoreCase("add assignment")) {
				addAssignment();
			} else if(input.equalsIgnoreCase("change grades")) {
				changeGrades();
			}
		} while(!input.equalsIgnoreCase("exit"));
	}
	
	public static void addStudent() {
		newCourse.addStudent();
	}
	
	public static void viewGrades() {
		newCourse.viewGrades();
	}
	
	public static void addAssignment() {
		System.out.println("Enter the name of the assignment, test, or exam you wish to add");
		String aN = kB.nextLine();
		System.out.println("Enter the weight from 0 - 1 for " + aN);
		double w = Double.parseDouble(kB.nextLine());
		for(int i = 0; i < newCourse.studentList.size(); i++) {
			newCourse.studentList.get(i).grades.add(new Grade(aN, w));
		}
	}
	
	public static void changeGrades() {
		System.out.println(newCourse.toString());
		System.out.println("\nFrom the list, type the student ID for which you wish to change a grade:");
		int studentID = Integer.parseInt(kB.nextLine());
		for(int i = 0; i < newCourse.studentList.size(); i++) {
			if(newCourse.studentList.get(i).ID == studentID) {
				System.out.println("\n" + newCourse.studentList.get(i).toString() + "\n");
				System.out.println("From the list, enter the name of the assignment, test, or exam you wish to change: ");
				String aN = kB.nextLine();
				for(int j = 0; j < newCourse.studentList.get(i).grades.size(); j++) {
					if(aN.equalsIgnoreCase(newCourse.studentList.get(i).grades.get(j).name)) {
						System.out.println();
						System.out.println("Enter the new grade for " + newCourse.studentList.get(i).grades.get(j).name + ": ");
						double nG = Double.parseDouble(kB.nextLine());
						newCourse.studentList.get(i).grades.get(j).setGrade(nG);
					}
				}
				newCourse.studentList.get(i).updateAverageGrade();
			}
		}
	}

}
