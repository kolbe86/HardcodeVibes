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
<h3>Publikation ändern</h3>

<s:form action="changePublicationAction">
	<s:textfield name="publicationBean.publicationID" label="ID"/>
	<s:textfield name="publicationBean.title" label="Titel"/>
 	<s:textfield name="publicationBean.publicationDate"  label ="Veroeffentlichungsdatum"/>
	<s:select name="publicationTypeSelection"  list="publicationTypes" size="1" multiple="false"  label="Publikationsart" value="publicationTypeSelection"/>
	<s:select name="keywordSelection"  list="keywordSelection" size="1" multiple="true" label="Schlagwörter" value="selectedKeywords"/>
	<s:radio name="condition" key="conditions" list="conditions" value="condition" label="Zustand"/>
	<s:textfield name="publicationBean.isbn"  label ="ISBN Nummer"/>
	<s:textfield name="publicationBean.publisher"  label ="Verlag"/>
	<s:textfield name="publicationBean.edition"  label ="Auflage"/>
	<s:textfield name="publicationBean.issue" label = "Ausgabe"/>
   		<s:submit value="Publikation ändern"/>
</s:form>	
 
</body>
</html>