<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Register</title>
</head>
<body>

<h4 style="background-color:#FF7140">Publikation ändern</h4>

<s:form action="changePublicationAction">
<table style="background-color:#FFCF73">
		<tbody style="background-color:#FFCF73">
			<tr>
	<td><s:textfield name="publicationBean.publicationID" label="ID"/></td>
	<td><s:textfield name="publicationBean.title" label="Titel"/></td>
 	<td><s:textfield name="publicationBean.publicationDate"  label ="Veroeffentlichungsdatum"/></td>
	<td><s:select name="publicationTypeSelection"  list="publicationTypes" size="1" multiple="false"  label="Publikationsart" value="publicationTypeSelection"/></td>
	<td><s:select name="keywordSelection"  list="keywordSelection" size="1" multiple="true" label="Schlagwörter" value="selectedKeywords"/></td>
	<td><s:radio name="condition" key="conditions" list="conditions" value="condition" label="Zustand"/></td>
	<td><s:textfield name="publicationBean.isbn"  label ="ISBN Nummer"/></td>
	<td><s:textfield name="publicationBean.publisher"  label ="Verlag"/></td>
	<td><s:textfield name="publicationBean.edition"  label ="Auflage"/></td>
	<td><s:textfield name="publicationBean.issue" label = "Ausgabe"/></td>
   		<s:submit value="Publikation ändern"/>
   			</tr>
		</tbody>
		</table>
</s:form>	
 
</body>
</html>