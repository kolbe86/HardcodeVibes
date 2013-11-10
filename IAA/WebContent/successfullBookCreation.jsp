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
<h3>Publikation wurde erfolgreich angelegt.</h3>

<p>
Der Titel der Publikation ist: <s:property value="bookBean.title" />
 Author: <s:property value="bookBean.authors" />
 Datum: <s:property value="bookBean.publicationDate" />
 Schlagwort: <s:property value="bookBean.keywords" />
 ISBN: <s:property value="bookBean.isbn" />
 Verlag: <s:property value="bookBean.publisher" />
 Auflage: <s:property value="bookBean.edition" />
 
 </p>

<p><a href="<s:url action='bookCreationLink' />" >Weiteres Buch anlegen</a>.</p>
<p><a href="<s:url action='baseLayoutLink' />" >Zueruck zur Startseite</a>.</p>

</body>
</html>