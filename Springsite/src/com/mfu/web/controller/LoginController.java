package com.mfu.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.ejb.BackpackService;
import com.test.ejb.MemberService;
import com.test.ejb.RentService;
import com.test.entity.Backpack;
import com.test.entity.Book;
import com.test.entity.Member;
import com.test.entity.Rent;

@Controller

public class LoginController {
	
	@EJB(mappedName="ejb:/Database.old//MemberServiceBean!com.test.ejb.MemberService")
	MemberService memberServ;
	
	@EJB(mappedName="ejb:/Database.old//BackpackServiceBean!com.test.ejb.BackpackService")
	BackpackService backpackServ;

	@EJB(mappedName="ejb:/Database.old//RentServiceBean!com.test.ejb.RentService")
	RentService rentServ;
	
	List<Member> ListMember;
	List<Member> id;
	
	
	
	

	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public ModelAndView newEmployee(){
	ModelAndView mv = new ModelAndView("login.jsp");
	
	mv.addObject("login", new Member());
	return mv;
	}
	
	
	
	public long convert() {		
		String aa = id.toString();
		aa = aa.substring(1, aa.length() - 1);
		
		return Long.parseLong(aa);
		
	}
	

	
	
	@RequestMapping(value = "/bpindex")
	public ModelAndView newEmployese(HttpServletRequest request){
		String xx = request.getParameter("id");
		ModelAndView mv = new ModelAndView("bpindex.jsp");
		List<Backpack> showList;
		try {
			showList = backpackServ.showbackpack(Long.parseLong(xx));
			mv.addObject("showList", showList);
		}catch(Exception gg) {
			gg.getMessage();
		}
		
		return mv;
		}
	
	@RequestMapping("/deletex")
	public String deleteEmp(HttpServletRequest request){
	backpackServ.delete(Long.valueOf(request.getParameter("id")));
	return "redirect:bpindex.do";
	}
		
	
	@RequestMapping(value = "/index.do")
	public ModelAndView newEmployee(HttpServletRequest request){
	ModelAndView mv = new ModelAndView("index.jsp");
	
	try {
		mv.addObject("ListMember", ListMember);
	}catch(Exception gg) {
		gg.getMessage();
	}
	
	return mv;
	}
	
	
	
	@RequestMapping(value = "/validate",method = RequestMethod.POST)
	public String loginvalidation(HttpServletRequest request, @RequestParam("password")String password){
			String usr = request.getParameter("username");
			String msg = null;			
			
		try {	
			List<Member> x = memberServ.listmember(usr, password);
			
			
			try {
				System.out.println(x.get(0));
				
			}catch(Exception a) {
				msg = "redirect:login.do";
			}
			
			if(x.isEmpty()) {
				msg = "redirect:login.do";
			}else {
			
				ListMember = memberServ.allMember(usr);
				msg = "redirect:index.do";

			}
			
			}
			
	catch (Exception e) {			
			e.printStackTrace();
			}			
		return msg;
			}
	
	@RequestMapping(value = "/history")
	public ModelAndView newEmployesse(HttpServletRequest request){
		String xx = request.getParameter("id");
		
		ModelAndView mv = new ModelAndView("history.jsp");
		List<Rent> showList;
		
		
		try {
			showList = rentServ.showrent(Long.parseLong(xx));
			
			mv.addObject("showList", showList);
		}catch(Exception gg) {
			gg.getMessage();
		}
		
		return mv;
		}
	
	@RequestMapping(value = "/extend")
	public ModelAndView newEmployessse(HttpServletRequest request){
		String xx = request.getParameter("id");
		
		ModelAndView mv = new ModelAndView("history.jsp");
		Rent dateu = rentServ.findrent(Long.parseLong(xx));
		
		List<Rent> showList = null;
		try {
			dateu.setDate("14 days left");
			
			rentServ.update(dateu);
			mv.addObject("showList", showList);
		}catch(Exception gg) {
			gg.getMessage();
		}
		
		return mv;
		}
	
	
	
	

}

