package com.tutorials4u.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String baseLayout()
	{
		return "baseLayout";		
	}
	
	public String publicationCreation()
	{
		return "publicationCreation";		
	}
	
	public String publicationManagement()
	{
		return "publicationManagement";		
	}
	
	public String lendingProcessManagement()
	{
		return "lendingProcessManagement";		
	}
	
	public String basicDataLender()
	{
		return "basicDataLender";		
	}
	
	public String basicDataType()
	{
		return "basicDataType";		
	}
	
	public String basicDataWord()
	{
		return "basicDataWord";		
	}
	
}