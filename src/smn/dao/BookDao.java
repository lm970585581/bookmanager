package smn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import smn.util.Conn;
import smn.vo.Book;

public class BookDao {
	Conn conn = null;

	public Book selectBook(String ISBN) {
		conn = new Conn();
		String sql = "select * from book where ISBN='" + ISBN + "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				return new Book(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8),
						rs.getBytes(9));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			conn.closed();
		}
	}

	public boolean updateBook(Book book) {
		conn = new Conn();
		String sql = "update book set bookName='" + book.getBookName()
				+ "',author='" + book.getAuthor() + "',publisher='"
				+ book.getPublisher() + "',price=" + book.getPrice() + ",cnum="
				+ book.getCnum() + ",snum=" + book.getSnum() + ",summary='"
				+ book.getSummary() + "',photo=" + book.getPhoto()
				+ " where ISBN='" + book.getISBN() + "'";
		conn.executeUpdate(sql);
		conn.closed();
		return true;
	}

	public boolean addBook(Book book) {
		try {
			conn = new Conn();
			String sql="insert into book values('"+book.getISBN()+"','"+book.getBookName()+"','"+book.getAuthor()+"','"+book.getPublisher()+"','"+book.getPrice()+"','"+book.getCnum()+"','"+book.getSnum()+"','"+book.getSummary()+"','"+book.getPhoto()+"')";
			conn.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.closed();
		}

	}
	
	public boolean deleteBook(String ISBN){
		try {
			conn = new Conn();
			String sql="delete from book where ISBN='"+ISBN+"'";
			conn.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			conn.closed();
		}
	}
}
