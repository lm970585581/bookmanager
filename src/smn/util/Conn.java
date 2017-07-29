package smn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	private final String url = "jdbc:mysql://127.0.0.1:3306/test1";
	private final String userName = "root";
	private final String password = "toor";
	private Connection con = null;
	private Statement stm = null;

	public Conn() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载数据库驱动失败！");
		}
	}

	public void createCon() {
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败！");
		}
	}

	public void getStm() {
		createCon();
		try {
			stm = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("创建Statement对象失败！");
		}
	}

	public boolean executeUpdate(String sql) {
		System.out.println(sql);
		boolean mark = false;
		try {
			getStm();
			int iCount = stm.executeUpdate(sql);
			if (iCount > 0)
				mark = true;
			else
				mark = false;
		} catch (Exception e) {
			e.printStackTrace();
			mark = false;
		}
		return mark;
	}

	/* 查询数据库 */
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			getStm();
			try {
				rs = stm.executeQuery(sql);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("查询数据库失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/* 关闭数据库的操作 */
	public void closed() {
		if (stm != null)
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭stm对象失败！");
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭con对象失败！");
			}
	}
}
