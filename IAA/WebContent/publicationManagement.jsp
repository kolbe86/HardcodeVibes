<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Publikation verwalten</title>
</head>
<body>
<h3>Suchen Sie eine Publikation, die Sie verwalten möchten</h3>

<s:form action="publicationManagementAction">

<%-- 	<jsp:useBean id="publicationBean" class="de.nak.librarymgmt.model.Publication" /> --%>
<%--  	<s:property value="publicationBean.authors"/> --%>
	<s:textfield name="publicationBean.title" label="Titel"/>
<%-- 	<s:textfield  name="author" label="Autoren"/> --%>
<%-- 		<s:submit action="addAuthorAction"/> --%>
 	<s:textfield name="publicationBean.publicationDate"  label ="Veroeffentlichungsdatum"/>
<%-- 	<s:select name="publicationTypeSelection"  list="publicationTypeSelection" size="1" multiple="false" label="Publikationsart"/> --%>
<%-- 	<s:select name="keywordSelection"  list="keywordSelection" size="1" multiple="true" label="Schlagwörter"/> --%>
<%-- 	<s:select name="condition"  list="condition" listKey="condition" size="1" multiple="True" label="Zusatnd"/> --%>
	<s:textfield name="publicationBean.isbn"  label ="ISBN Nummer"/>
	<s:textfield name="publicationBean.publisher"  label ="Verlag"/>
	<s:textfield name="publicationBean.edition"  label ="Auflage"/>
	<s:textfield name="publicationBean.issue" label = "Ausgabe"/>
   		<s:submit/>
   	  
</s:form>	
 
</body>
</html>
