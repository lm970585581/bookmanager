package smn.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import smn.util.Conn;
import smn.vo.Lend;

public class LendDao {
	public ArrayList selectLend(String readerId, int pageNow, int pageSize) {
		ArrayList list = new ArrayList();
		Conn conn = new Conn();
		String sql = "select bookId,ISBN,bookName,publisher,price,lTime from lend where readerId='"
				+ readerId + "' limit " + pageNow + "," + pageSize;
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setISBN(rs.getString(2));
				lend.setBookName(rs.getString(3));
				lend.setPublisher(rs.getString(4));
				lend.setPrice(rs.getFloat(5));
				lend.setlTime(rs.getDate(6));
				list.add(lend);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			conn.closed();
		}
	}

	public int selectLendSize(String readerId) {
		Conn conn = new Conn();
		String sql = "select count(*) from lend where readerId='" + readerId
				+ "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				int PageCount = rs.getInt(1);
				return PageCount;
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			conn.closed();
		}
	}

	public Lend selectByBookId(String bookId) {
		Conn conn = new Conn();
		String sql = "select * from lend where bookId='" + bookId + "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setReaderID(rs.getString(2));
				lend.setISBN(rs.getString(3));
				lend.setlTime(rs.getDate(4));
				return lend;
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			conn.closed();
		}
	}

	public boolean addLend(Lend lend) {
		Conn conn = new Conn();
		String sql = "insert into lend values('" + lend.getBookId() + "','"
				+ lend.getReaderID() + "','" + lend.getISBN() + "','"
				+ new Date(lend.getlTime().getTime()) + "')";
		conn.executeUpdate(sql);
		conn.closed();
		return true;
	}

	public Lend selectByBookISBN(String ISBN) {
		Conn conn = new Conn();
		try {
			String sql="select * from lend where ISBN='"+ISBN+"'";
			ResultSet rs = conn.executeQuery(sql);
			if (rs.next()) {
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setReaderID(rs.getString(2));
				lend.setISBN(rs.getString(3));
				lend.setlTime(rs.getDate(4));
				return lend;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			conn.closed();
		}
	}
}
