package com.mfu.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.ejb.BookService;
import com.test.entity.Book;
import com.test.entity.Member;

@Controller
public class SpringController {

	@EJB(mappedName="ejb:/Database.old//BookServiceBean!com.test.ejb.BookService")
	BookService bookServ;
	
	@RequestMapping("/listEmp")
	public ModelAndView listEmployee(HttpServletRequest request){
	ModelAndView mv = new ModelAndView("listEmp.jsp");
	List<Book> empList;
	try {
	empList = bookServ.allbook();
	mv.addObject("empList", empList);
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return mv;
	}
	
	@RequestMapping("/newEmp")
	public ModelAndView newEmployee(){
	ModelAndView mv = new ModelAndView("empForm.jsp");
	Book book = new Book();
	mv.addObject("book", book);
	return mv;
	}

	@RequestMapping("/saveEmp")
	public String saveEmp(
	@ModelAttribute("book") Book book,BindingResult result, HttpServletRequest request){
	
	try {
	
	if(book.getBookId()==0){
	bookServ.insert(book);
	
	} else {
	bookServ.update(book);
	}
	} catch (Exception e) {
	
	e.printStackTrace();
	}
	return "redirect:listEmp.do";
	}
	
	@RequestMapping("/editEmp")
	public ModelAndView editEmp(HttpServletRequest request){
	int paramId = Integer.parseInt(request.getParameter("id"));
	Book foundbook;
	ModelAndView mv = new ModelAndView("empForm.jsp");
	try {
	foundbook = bookServ.findBook(paramId);
	mv.addObject("book", foundbook);
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return mv;
	}
	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request){
	bookServ.delete(Long.valueOf(request.getParameter("id")));
	return "redirect:listEmp.do";
	}
	
	
	

}
