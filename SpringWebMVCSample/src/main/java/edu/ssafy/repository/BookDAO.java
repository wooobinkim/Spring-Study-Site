package edu.ssafy.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.dto.BookDTO;

public interface BookDAO {
	
	public void regBook(BookDTO b) throws SQLException;
	
	public List<BookDTO> listbook() throws SQLException;
	
	public void deleteBook(BookDTO b) throws SQLException;
	
	public void updateBook(BookDTO b) throws SQLException;
}
