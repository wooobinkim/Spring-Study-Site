package edu.ssafy.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ssafy.dto.BookDTO;
import edu.ssafy.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookser;
	
	@RequestMapping(value = "/bookmain.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bookmain() {
		
		return "book/bookmain";
	}
	
	@RequestMapping(value = "/regbookform.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String regbookform() throws SQLException {
		return "book/regbook";
	}
	
	
	@RequestMapping(value = "/regbook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String regbookform(BookDTO b, HttpServletRequest request) throws SQLException {
		bookser.regBook(b);
		request.setAttribute("listbook", b);
		return "book/regresult";
	}
	
	@RequestMapping(value = "/emptyinput.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String emptyinput(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		return "book/emptyinput";
	}
	
	@RequestMapping(value = "/listbook.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String listbook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<BookDTO> listbook = bookser.listbook();
		request.setAttribute("listbook", listbook);
		return "book/listbook";
	}
	
	
	
	
	
}
