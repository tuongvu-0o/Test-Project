package com.nguyentuongvu.multicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController {
	
	@RequestMapping("/mvc")
	public ModelAndView showMVC() 
	{
		ModelAndView mv = new ModelAndView("view_mvc");
		return mv;
	}

}