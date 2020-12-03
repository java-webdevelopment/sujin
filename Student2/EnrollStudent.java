package Student;

import java.util.List;
import java.util.Scanner;

import net.abc.vo.GuVO;

public class EnrollStudent {
	
	StudentDAO studentdao = new StudentDAO();
	StudentVO studentvo = new StudentVO();

	static boolean isInteger(String s) {//정수 판별 함수
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {//문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
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
			setStudentName();//이름 저장
			setGradeLevel();//학년 저장
			enrollCourse();//과목 저장
			setStudentPayment();//등록금 지불
			studentdao.insertStudent(studentvo);//DB에 값 저장
			int count = studentvo.getCourses().size();
			while(count>0) {
				studentdao.insertStudentCourses(studentvo);
				count--;
			}
			printStudentData();//DB 출력
			num--;
		} // while
		System.exit(0);
	}// mainMethod()

	public String setStudentName() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("Enter student first name : ");
			studentvo.setFirstName(scan.nextLine());  
			if(isInteger(studentvo.getFirstName())) {
				System.out.println("Try again.");
				continue;
			}//if
			break;
		}//while
			while(true) {
				System.out.print("Enter student last name : ");
				studentvo.setLastName(scan.nextLine()); 
				if(isInteger(studentvo.getLastName())) {
					System.out.println("Try again.");
					continue;
				}//if
				break;
			}//while
			studentvo.setName(studentvo.getFirstName()+" "+studentvo.getLastName());  
		return studentvo.getName();
	}//setStudentName()

	public void setGradeLevel() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Freshmen");
		System.out.println("2 - Sophmore");
		System.out.println("3 - Junior");
		System.out.println("4 - Senior");
		while (true) {
			System.out.print("Enter student class level : ");
			String input = scan.nextLine();
			if (isInteger(input)) {
				studentvo.setGradeLevel(Integer.parseInt(input));
				if (0 < studentvo.getGradeLevel() && studentvo.getGradeLevel() < 5) {
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
	}//setGradeLevel()

	public void enrollCourse() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("Enter course to enroll (Q to quit): ");
			studentvo.setCourse(scan.nextLine());
			if (studentvo.getCourse().equals("Q")) {
				int count = studentvo.getCourses().size();
				studentvo.setCourse(studentvo.getCourses().get(count-2));
				break;
			} else if (equalsCourse(studentvo.getCourse()) == 1) {
				if (studentvo.getCourses().size() > 0 && overlapCourses(studentvo.getCourse()) == 1) {
					System.out.println("This course already enrolled. Try again.");
					continue;
				} else {
					studentvo.getCourses().add(studentvo.getCourse());
				} // if else
			} else {
				System.out.println("Wrong course. Try again.");
				continue;
			}
		} // while
	}//enrollCourse()

	public int equalsCourse(String course) {
		int n = 0;
		for (int i = 0; i < studentvo.getSubject().length; i++) {
			if (studentvo.getSubject()[i].equals(course)) {
				n = 1;
				break;
			} else {
				n = 0;
			} // if else
		} // for
		return n;
	}//equalsCourse()

	public int overlapCourses(String course) {
		int n = 0;
		for (int i = 0; i < studentvo.getCourses().size(); i++) {
			if (studentvo.getCourses().get(i).equals(course)) {
				n = 1;
				break;
			} else {
				n = 0;
			} // if else
		} // for
		return n;
	}//overlapCourses()

	public void setStudentPayment() {
		Scanner scan = new Scanner(System.in);
		studentvo.setBalance(600 * studentvo.getCourses().size());
		System.out.println("Your balance is : $" + studentvo.getBalance());
		while (true) {
			System.out.print("Enter your payment : ");
			String input = scan.nextLine();
			if (isInteger(input)) {
				int payment = Integer.parseInt(input);
				if (0 < payment && payment <= studentvo.getBalance()) {
					studentvo.setBalance(studentvo.getBalance() - payment);
					break;
				} else {
					System.out.println("Check your balance. Try again.");
					continue;
				} // if else
			} else {
				System.out.println("Only enter number.");
				continue;
			} // if else
		} // while
		System.out.println("Your balance is : $" + studentvo.getBalance());
	}//setStudentPayment()

	public void printStudentData() {
		List<StudentVO> list = studentdao.getStudentlist();
		
		for(StudentVO print:list) {
			System.out.println("Name : " + print.getName()+"\nGrade Level : " + print.getGradeLevel()
			+"\nstudent ID : " +((10000*print.getGradeLevel())+print.getStudentId())
			+"\nBalance : " + studentvo.getBalance());
		}
		System.out.println("Courses: ");
		for (int i = 0; i < studentvo.getCourses().size(); i++) {
			System.out.println(studentvo.getCourses().get(i));
		}
		System.out.println();
		studentvo.getCourses().clear();
	}//printStudentData()
}
