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

 	  <s:textfield name="publicationBean.title" label="Titel" value="Buchtitel"/>
 	  <s:textfield  name="publicationBean.authors" label="Autoren" value="Autor"/>
 	  <s:submit action="addAuthorAction"/>
 	  <s:property value="publicationBean.authors"/>
 	  <s:textfield name="publicationBean.publicationDate"  label ="Veroeffentlichungsdatum" value="01.01.2000"/>
 	  <s:textfield name="publicationBean.keywords"  label ="Schlagw�rter" value="Keyword"/>
 	  <s:textfield name="publicationBean.condition"  label ="Zustand" value="Neu"/>
 	  <s:textfield name="publicationBean.isbn"  label ="ISBN Nummer" value="978-3-86680-192-9"/>
 	  <s:textfield name="publicationBean.publisher"  label ="Verlag" value="Grim"/>
 	  <s:textfield name="publicationBean.edition"  label ="Auflage" value="3. Auflage"/>

   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>