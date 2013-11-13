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

 	  <s:textfield name="publicationBean.title" label="Titel"/>
 	  <s:textfield  name="publicationBean.authors" label="Autoren" value=""/>
 	  	<s:submit action="addAuthorAction"/>
 	  <s:property value="publicationBean.authors"/>
 	  <s:textfield name="publicationBean.publicationDate"  label ="Veroeffentlichungsdatum"/>
 	  <s:select name="publicationBean.keywords.name"  list="publicationBean.keywords" listKey="publicationBean.keywords" listValue="name" size="1" multiple="True"/>
<%--  	  <s:textfield name="publicationBean.condition"  label ="Zustand" value="Neu"/> --%>
 	  <s:textfield name="publicationBean.isbn"  label ="ISBN Nummer"/>
 	  <s:textfield name="publicationBean.publisher"  label ="Verlag"/>
 	  <s:textfield name="publicationBean.edition"  label ="Auflage"/>
		<s:textfield name="publicationBean.issue" label = "Ausgabe"/>

   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>