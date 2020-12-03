package Student;

import java.util.ArrayList;
import java.util.List;

public class StudentVO {
	private String firstName;
	private String lastName;
	private String name;
	private int gradeLevel;
	private int studentId;
	private String[] subject = { "History 101", "Mathematics 101", "English 101", "Chemistry 101",
			"Computer Science 101" };
	private String course;
	private List<String> courses = new ArrayList<>();
	private int balance;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String[] getSubject() {
		return subject;
	}
	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List courses) {
		this.courses = courses;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
