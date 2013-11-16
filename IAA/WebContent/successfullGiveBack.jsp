<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Give Back</title>
</head>
<body style="height:100%;width:100%">

<h1>Die folgende Publikation wurde erfolgreich zurück gegeben:</h1>
<table>
<tr><td>Titel:</td><td><s:property value="publicationBean.title" /></td></tr>
<tr><td>Autoren:</td><td><s:property value="publicationBean.authors"/></td></tr>
<tr><td>Publikationsdatum: </td><td><s:property value="publicationBean.publicationDate"/></td></tr>
<tr><td>Publikationstyp: </td><td><s:property value="publicationBean.publicationType"/></td></tr>
<tr><td>Schlagwörter:</td><td><s:property value="publicationBean.keywords" /></td></tr>
<tr><td>ISBN:</td><td><s:property value="publicationBean.isbn" /></td></tr>
<tr><td>Verlag: </td><td><s:property value="publicationBean.publisher"/></td></tr>
<tr><td>Ausgabe:</td><td><s:property value="publicationBean.issue"/></td></tr>
<tr><td>Auflage:</td><td><s:property value="publicationBean.edition"/></td></tr>
<tr><td>Zustand:</td><td><s:property value="publicationBean.condition"/></td></tr>
</table>
</body>
</html>