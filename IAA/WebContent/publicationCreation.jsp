<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>
</head>
<body>
<h3>Lege eine neue Publikation an</h3>

<s:form action="publicationCreationAction">

 	  <s:textfield name="publicationBean.titel" label="Titel" />
 	  <s:textfield  name="publicationBean.author" label="Author" />
 	  <s:textfield name="publicationBean.dateOfPublication"  label ="Veroeffentlichkeitsdatum"/>  
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>