<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Creation Successful</title>
</head>
<body>
<h3>Dissertation wurde erfolgreich angelegt.</h3>

<p>
Der Titel der Publikation ist: <s:property value="dissertationBean.title" />
 Author: <s:property value="dissertationBean.authors" />
 Datum: <s:property value="dissertationBean.publicationDate" />
 Schlagwort: <s:property value="dissertationBean.keywords" />
 Schlagwort: <s:property value="dissertationBean.condition" />
 
 </p>

<p><a href="<s:url action='dissertationCreationLink' />" >Weitere Dissertation anlegen</a>.</p>
<p><a href="<s:url action='baseLayoutLink' />" >Zueruck zur Startseite</a>.</p>

</body>
</html>