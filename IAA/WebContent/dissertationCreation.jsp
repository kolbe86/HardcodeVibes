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
<h3>Lege eine neue Dissertation an</h3>

<s:form action="dissertationCreationAction">

 	  <s:textfield name="dissertationBean.title" label="Titel" value="Studie über Vögel"/>
 	  <s:textfield  name="dissertationBean.authors" label="Autoren" value="Hugh Heffner"/>
 	  <s:textfield name="dissertationBean.publicationDate"  label ="Veroeffentlichungsdatum" value="21.03.2013" />
 	  <s:textfield name="dissertationBean.keywords"  label ="Schlagwörter" value="Vogel"/>
 	  <s:textfield name="dissertationBean.condition"  label ="Zustand" value="Alt"/>
 	   
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>