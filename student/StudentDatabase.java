package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDatabase {
	private String firstName;
	private String lastName;
	private String name;
	private int gradeLevel;
	private int studentId = 10000;
	private String[] object = { "History 101", "Mathematics 101", "English 101", "Chemistry 101",
			"Computer Science 101" };
	private List courses = new ArrayList();
	private int balance;

	static boolean isInteger(String s) { // 정수 판별 함수
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) { // 문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
			return false;
		}
	}

	public void mainMethod() {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.print("Enter number of new student to enroll : ");
			String input = scan.nextLine();
			if (isInteger(input)) {
				num = Integer.parseInt(input);
				break;
			} else {
				System.out.println("Only enter number.");
				continue;
			} // if else
		} // while
		while (num > 0) {
			studentName();
			gradeLevel();
			int re = enrollCourse();
			studentPayment(re);
			printStuentData();
			num--;
		} // while
		System.exit(0);
	}// mainMethod()

	public String studentName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter student first name : ");
		firstName = scan.nextLine();
		System.out.print("Enter student last name : ");
		lastName = scan.nextLine();
		name = firstName + " " + lastName;
		return name;
	}// studentName()

	public void gradeLevel() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Freshmen");
		System.out.println("2 - Sophmore");
		System.out.println("3 - Junior");
		System.out.println("4 - Senior");
		while (true) {
			System.out.print("Enter student class level : ");
			String input = scan.nextLine();
			if (isInteger(input)) {
				gradeLevel = Integer.parseInt(input);
				if (0 < gradeLevel && gradeLevel < 5) {
					break;
				} else {
					System.out.println("Enter number from 1 to 4.");
					continue;
				}
			} else {
				System.out.println("Only enter number.");
				continue;
			}
		} // while
	}// gradeLevel()

	public int enrollCourse() {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.print("Enter course to enroll (Q to quit): ");
			String course = scan.nextLine();
			if (course.equals("Q")) {
				break;
			} else if (courseEquals(course) == 1) {
				if (count > 0 && coursesOverlap(course) == 1) {
					System.out.println("This course already enrolled. Try again.");
					continue;

				} else {
					courses.add(course);
					count++;
				} // if else
			} else {
				System.out.println("Wrong course. Try again.");
				continue;
			}
		} // while
		return count;
	}// enrollCourse()

	public int courseEquals(String course) {
		int n = 0;
		for (int i = 0; i < object.length; i++) {
			if (object[i].equals(course)) {
				n = 1;
				break;
			} else {
				n = 0;
			} // if else
		} // for
		return n;
	}// courseEquals()

	public int coursesOverlap(String course) {
		int n = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).equals(course)) {
				n = 1;
				break;
			} else {
				n = 0;
			} // if else
		} // for
		return n;
	}// coursesOverlap()

	public void studentPayment(int count) {
		Scanner scan = new Scanner(System.in);
		balance = 600 * count;
		System.out.println("Your balance is : $" + balance);
		while (true) {
			System.out.print("Enter your payment : ");
			int payment = Integer.parseInt(scan.nextLine());
			if (0 < payment && payment <= balance) {
				balance -= payment;
				break;
			} else {
				System.out.println("Check your balance. Try again.");
				continue;
			} // if else
		} // while
		System.out.println("Your balance is : $" + balance);
	}// studentPayment()

	public void printStuentData() {
		System.out.println("Name : " + name);
		System.out.println("Grade Level : " + gradeLevel);
		System.out.println("student ID : " + studentId);
		studentId++;
		System.out.println("Courses Enrolled : ");
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i));
		}
		System.out.println("Balance : " + balance);
		courses.clear();
	}// printStudentData

}
