package edu.ssafy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.BookDTO;
import edu.ssafy.repository.BookDAO;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	@Qualifier("BookDAOJDBCTemplateImpl")
	BookDAO bdao;

	@Override
	public void regBook(BookDTO b) throws SQLException {
		bdao.regBook(b);
	}

	@Override
	public List<BookDTO> listbook() throws SQLException {
		return bdao.listbook();
	}

	@Override
	public void deleteBook(BookDTO b) throws SQLException {
		bdao.deleteBook(b);
	}

	@Override
	public void updateBook(BookDTO b) throws SQLException {
		bdao.updateBook(b);
	}

}
