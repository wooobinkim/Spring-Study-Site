package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.BookDTO;
import edu.ssafy.util.DBUtil;

@Repository("BookDAOJDBCTemplateImpl")
public class BookDAOJDBCTemplateImpl implements BookDAO {
	@Autowired
	private JdbcTemplate jt;

	class BookMapper implements RowMapper<BookDTO> {

		@Override
		public BookDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookDTO b = new BookDTO();
			b.setISBN(rs.getString("ISBN"));
			b.setAuthor(rs.getString("Author"));
			b.setDescr(rs.getString("Descr"));
			b.setTitle(rs.getString("Title"));
			b.setPicture(rs.getString("Picture"));
			b.setPrice(rs.getString("Price"));
			return b;
		}
	}

	@Override
	public void regBook(BookDTO b) throws SQLException {
		jt.update("insert into books values (?,?,?,?,?,?)",
				new Object[] { b.getISBN(), b.getAuthor(), b.getTitle(), b.getPrice(), b.getDescr(), b.getPicture() });

	}

	@Override
	public List<BookDTO> listbook() throws SQLException {
		List<BookDTO> list = jt.query("select ISBN,Author,Title,Price,Descr,Picture from books", new BookMapper());

		return list;
	}

	@Override
	public void deleteBook(BookDTO b) throws SQLException {
		jt.update("delete from books where ISBN=?", new Object[] { b.getISBN() });

	}

	@Override
	public void updateBook(BookDTO b) throws SQLException {
		jt.update("update books set Author=?,Title=?,Price=?,Descr=?,Picture=? where ISBN=?",
				new Object[] { b.getAuthor(), b.getTitle(), b.getPrice(), b.getDescr(), b.getPicture(), b.getISBN() });

	}

}
