package com.tutorials4u.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String welcome()
	{
		return "welcome";		
	}
	
	public String struts()
	{
		return "struts";		
	}
	
	public String hibernate()
	{
		return "hibernate";		
	}
}
