package com.mfu.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.ejb.BookService;
import com.test.ejb.MemberService;
import com.test.entity.Book;
import com.test.entity.Member;

@Controller
public class UserController {


	@EJB(mappedName="ejb:/Database.old//BookServiceBean!com.test.ejb.BookService")
	BookService bookServ;
	
	
	
	@RequestMapping("/viewproge")
	public ModelAndView newEmployee1(@RequestParam("genre")String genre){
	ModelAndView mv = new ModelAndView("view.jsp");
	List<Book> booklist;
	try {
		booklist = bookServ.getbookcata(genre);
		mv.addObject("booklist", booklist);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return mv;
	
	
	}
	
	

	
	
	
	
	

}
