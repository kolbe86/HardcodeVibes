<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Creation Successful</title>
</head>
<body>
<h3>Publikation wurde erfolgreich angelegt.</h3>

<table>
	<tbody  style="background-color:#FFCF73">
		<tr>
			<td>Titel: </td>
			<td><s:property value="publicationBean.title" /></td>
		</tr>
		<tr>
			<td>Autoren): </td>
			<td><s:property value="authorSelection"/> </td>
		</tr>
		<tr>
			<td>Datum: </td>
			<td><s:property value="publicationBean.publicationDate" /></td>
		</tr>
		<tr>
			<td>ISBN: </td>
			<td><s:property value="publicationBean.isbn" /></td>
		</tr>
		<tr>
			<td>Verlag: </td>
			<td><s:property value="publicationBean.publisher" /></td>
		</tr>
		<tr>
			<td>Auflage: </td>
			<td><s:property value="publicationBean.edition" /></td>
		</tr>
		<tr>
			<td>Ausgabe: </td>
			<td><s:property value="publicationBean.issue"/></td>
		</tr>
	</tbody>
</table>

<p><a href="<s:url action='publicationCreationLink' />" >Weitere Publikation anlegen</a>.</p>

</body>
</html>