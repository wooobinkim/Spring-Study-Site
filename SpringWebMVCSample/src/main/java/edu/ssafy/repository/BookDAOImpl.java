package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BookDTO;
import edu.ssafy.dto.MemDTO;
import edu.ssafy.util.DBUtil;

@Repository
public class BookDAOImpl implements BookDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	@Override
	public void regBook(BookDTO b) throws SQLException {
		conn = DBUtil.getConnection();
		String sql = "insert into books values (?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, b.getISBN());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getTitle());
		ps.setString(4, b.getPrice());
		ps.setString(5, b.getDescr());
		ps.setString(6, b.getPicture());
		ps.executeUpdate();
		DBUtil.close(ps, conn);
	}
	
	@Override
	public List<BookDTO> listbook() throws SQLException {
		conn = DBUtil.getConnection();
		String sql = "select ISBN,Author,Title,Price,Descr,Picture from books";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		ArrayList<BookDTO> list = new ArrayList();
		while(rs.next()) {
			list.add(new BookDTO(rs.getString("ISBN"), 
					rs.getString("Author"), rs.getString("Title"), 
					rs.getString("Price"), rs.getString("Descr"), rs.getString("Picture")));
		}
		return list;
	}
	
	@Override
	public void deleteBook(BookDTO b) throws SQLException {
		conn = DBUtil.getConnection();
		String sql = "delete from books where ISBN = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, b.getISBN());
		ps.executeUpdate();
		DBUtil.close(ps, conn);
		
	}
	
	@Override
	public void updateBook(BookDTO b) throws SQLException {
		conn = DBUtil.getConnection();
		String sql = "update books set Author=?, Title=?, Price=?, Descr=?, Picture = ? where ISBN=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, b.getISBN());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getTitle());
		ps.setString(4, b.getPrice());
		ps.setString(5, b.getDescr());
		ps.setString(6, b.getPicture());
		ps.executeUpdate();
		DBUtil.close(ps, conn);
		
	}

}
