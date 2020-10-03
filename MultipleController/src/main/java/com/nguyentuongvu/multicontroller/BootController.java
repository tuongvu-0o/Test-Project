package com.nguyentuongvu.multicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class BootController {
	@RequestMapping("/boot")
	public ModelAndView showMVC1() 
	{
		ModelAndView mv = new ModelAndView("view_boot");
		return mv;
	}
}
