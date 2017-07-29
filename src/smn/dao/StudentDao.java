package smn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import smn.util.Conn;
import smn.vo.Student;

public class StudentDao {
	Conn conn=null;
	public Student selectByReaderId(String readerId){
		conn=new Conn();
		String sql="select * from student where readerId='"+readerId+"'";
		ResultSet rs=conn.executeQuery(sql);
		try {
			if(rs.next()){
				Student stu=new Student(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getDate(4),rs.getString(5),rs.getInt(6),rs.getBytes(7));
				return stu;
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			conn.closed();	
		}
	}
	
	public void updateStudent(Student stu){
		conn=new Conn();
		String sql="update student set num="+stu.getNum()+"where readId='"+stu.getReaderId()+"'";
		conn.executeUpdate(sql);
		conn.closed();
	}
}
