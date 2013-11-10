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
<h3>Lege eine neues Buch an</h3>

<s:form action="bookCreationAction">

 	  <s:textfield name="bookBean.title" label="Titel" />
 	  <s:textfield  name="bookBean.authors" label="Autoren" />
 	  <s:textfield name="bookBean.publicationDate"  label ="Veroeffentlichungsdatum" />
 	  <s:textfield name="bookBean.keywords"  label ="Schlagwörter"/>
 	  <s:textfield name="bookBean.condition"  label ="Zustand"/>
 	  <s:textfield name="bookBean.isbn"  label ="ISBN Nummer"/>
 	  <s:textfield name="bookBean.publisher"  label ="Verlag"/>
 	  <s:textfield name="bookBean.edition"  label ="Auflage"/>
 	   
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>