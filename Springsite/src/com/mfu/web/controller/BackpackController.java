package com.mfu.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.ejb.BackpackService;
import com.test.ejb.BookService;
import com.test.ejb.MemberService;
import com.test.ejb.RentService;
import com.test.entity.Backpack;
import com.test.entity.Book;
import com.test.entity.Member;
import com.test.entity.Rent;

@Controller
public class BackpackController {

	
	@EJB(mappedName="ejb:/Database.old//MemberServiceBean!com.test.ejb.MemberService")
	MemberService memberServ;
	
	@EJB(mappedName="ejb:/Database.old//BackpackServiceBean!com.test.ejb.BackpackService")
	BackpackService backpackServ;
	
	@EJB(mappedName="ejb:/Database.old//BookServiceBean!com.test.ejb.BookService")
	BookService bookServ;
	
	@EJB(mappedName="ejb:/Database.old//RentServiceBean!com.test.ejb.RentService")
	RentService rentServ;
	
	
	Member user;
	Book bookusr;
	String username;
	Rent rentusr;
	
	List<Backpack> show;
	

	
	
	@RequestMapping("/view")
	public  ModelAndView essditEmp(HttpServletRequest request) {
		username = request.getParameter("id");
		user = memberServ.findMember(Long.parseLong(username));
		
		ModelAndView mv = new ModelAndView("view.jsp");
	
		return mv;
		
	}
	
	

	
	
	@RequestMapping("/addbook")
	public ModelAndView editEmp(HttpServletRequest request){
	
	String idbook = request.getParameter("idbook");
	bookusr = bookServ.findBook(Long.parseLong(idbook));
	
	
	ModelAndView mv = new ModelAndView("Result.jsp");
	try {
		Backpack back = new Backpack();
		back.setBookName(bookusr.getNamebook());
		back.setMember(user);
		
		backpackServ.insert(back);
		

	
	} catch (Exception e) {
	// TODO Auto-generated catch block
	
	e.printStackTrace();
	
	
	}
	return mv;
	}
	
	@RequestMapping("/backpack")
	public ModelAndView editEmssp(HttpServletRequest requst) {
		List<Backpack> showList;
		ModelAndView mv = new ModelAndView("backpack.jsp");
		try {
			showList = backpackServ.showbackpack(Long.parseLong(username));
			mv.addObject("showList", showList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	@RequestMapping("/delete")
	public String deleteEmp(HttpServletRequest request){
	backpackServ.delete(Long.valueOf(request.getParameter("id")));
	return "redirect:backpack.do";
	}
	
	@RequestMapping("/rent")
	public ModelAndView editsEmssp(@RequestParam("idbk")String idbk, @RequestParam("idusr")String idusr) {

		
		ModelAndView mv = new ModelAndView("resultrent.jsp");
		try {
			Rent back = new Rent();
			back.setDate("7 days left");
			back.setMember(user);
			back.setbackpack(backpackServ.findbackpack(Long.parseLong(idbk)));
			rentServ.insert(back);
			backpackServ.delete(Long.valueOf(idbk));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mv;
	
	}
	
	
	
	
	
	
	
	
	
}
