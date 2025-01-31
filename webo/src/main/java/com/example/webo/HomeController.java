package com.example.webo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "ind.jsp";
	}
	 
	@RequestMapping("add")
	public String add(HttpServletRequest req,HttpSession ses){
		
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		int res=num1+num2;
		ses.setAttribute("result", res);
		System.out.println(res);
		return "res.jsp";
	}
	
	
	
}
