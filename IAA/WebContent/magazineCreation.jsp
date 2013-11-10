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
<h3>Lege ein neues Magazin an</h3>

<s:form action="magazineCreationAction">

 	  <s:textfield name="magazineBean.title" label="Titel" />
 	  <s:textfield  name="magazineBean.authors" label="Autoren" />
 	  <s:textfield name="magazineBean.publicationDate"  label ="Veroeffentlichungsdatum" />
 	  <s:textfield name="magazineBean.keywords"  label ="Schlagwörter"/>
 	  <s:textfield name="magazineBean.condition"  label ="Zustand"/>
 	  <s:textfield name="magazineBean.isbn"  label ="ISBN Nummer"/>
 	  <s:textfield name="magazineBean.publisher"  label ="Verlag"/>
 	  <s:textfield name="magazineBean.issue"  label ="Ausgabe"/>
 	   
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>