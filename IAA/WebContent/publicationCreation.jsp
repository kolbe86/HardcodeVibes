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

 	  <s:textfield name="probeBuchBean.titel" label="Titel" />
 	  <s:textfield  name="probeBuchBean.author" label="Author" />
 	  <s:textfield name="probeBuchBean.datum"  label ="Veroeffentlichkeitsdatum" value="dd.mm.yyyy"/>
 	  <s:select name="probeBuchBean.schlagwort" list="probeBuchBean.schlagwort" size="1" multiple="True" label="Schlagwort"/>
 	  <s:textfield name="probeBuchBean.art"  label ="Art der Publikation"/>
 	  <s:textfield name="probeBuchBean.isbn"  label ="ISBN Nummer"/>
 	  <s:textfield name="probeBuchBean.verlag"  label ="Verlag"/>
 	  <s:textfield name="probeBuchBean.anzahl"  label ="Anzahl"/>
 	   
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>