package smn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import smn.util.Conn;
import smn.vo.Login;

public class LoginDao {
	Conn conn=new Conn();
	public Login checkLogin(Login login){
		String sql="select * from user where username='"+login.getName()+"' and password='"+login.getPassword()+"'";
		ResultSet rs=conn.executeQuery(sql);
		try {
			if(rs.next()){
				return login;
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
