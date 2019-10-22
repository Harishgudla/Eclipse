package com.hcl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value={"/"} ,method = RequestMethod.GET)
	public ModelAndView welocmePage(){
		ModelAndView model=new ModelAndView();
		model.setViewName("welcomePage");
		return model;
		
	}
	
	@RequestMapping(value={"/Success"} ,method = RequestMethod.GET)
	public ModelAndView homePage(){
		ModelAndView model=new ModelAndView();
		model.setViewName("Success");
		return model;
			}
	@RequestMapping(value="/loginPage",method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout){
		ModelAndView model=new ModelAndView();
		if(error!=null){
			model.addObject("error","Invalid Credentails");
			model.setViewName("loginPage");
			return model;
		}
		else if(logout!=null){
			model.addObject("message","Logged out succcessfully");
			model.setViewName("loginPage");
			return model;
		}
		else if(logout==null&&error==null){
			model.setViewName("loginPage");
			return model;
		}
		return new ModelAndView("Success");
		
	}
	
}
