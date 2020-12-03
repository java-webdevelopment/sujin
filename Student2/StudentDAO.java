package Student;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.abc.vo.GuVO;

public class StudentDAO {

	static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	static final String USER = "week7";
	static final String PASSWORD = "week7";
	
	Connection con = null;
	PreparedStatement pt = null;
	ResultSet rs = null;
	String sql = null;
	
	public StudentDAO() {
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {e.printStackTrace();}
	}//생성자

	//학생 정보 출력
	public List<StudentVO> getStudentlist() {	
		List<StudentVO> list = new ArrayList<>();
		list.clear();
		try {		
			con=DriverManager.getConnection(URL, USER, PASSWORD);
			sql = "select * from student";
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();
			while(rs.next()) {
				StudentVO studentvo = new StudentVO();
				
				studentvo.setStudentId(rs.getInt("studentId"));
				studentvo.setName(rs.getString("name"));
				studentvo.setGradeLevel(rs.getInt("gradeLevel"));
				studentvo.setBalance(rs.getInt("balance"));
				
				list.add(studentvo);
			}
			int re=pt.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}//finally
		return list;
	}//getGlist()

	//학생 정보 저장
	public void insertStudent(StudentVO studentvo) {
		try {
			con=DriverManager.getConnection(URL, USER, PASSWORD);
			sql = "insert into student values(studentId_seq.nextval,?,?,?)";
			pt=con.prepareStatement(sql);
			pt.setString(1,studentvo.getName());
			pt.setInt(2,studentvo.getGradeLevel());
			pt.setInt(3,studentvo.getBalance());
			
			rs=pt.executeQuery();
		
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}//insertStudent()

	//과목 저장
	public void insertStudentCourses(StudentVO studentvo) {
		try {
			con=DriverManager.getConnection(URL, USER, PASSWORD);
			sql = "insert into student_courses values(studentId2_seq.nextval,?)";
			pt=con.prepareStatement(sql);
			pt.setString(1,studentvo.getCourse());
			
			rs=pt.executeQuery();
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
	}//insertStudentCourses()

}
