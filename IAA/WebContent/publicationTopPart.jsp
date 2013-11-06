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
Der Titel der Publikation ist: <s:property value="probeBuchBean.titel" />
 Author: <s:property value="probeBuchBean.author" />
 Datum: <s:property value="probeBuchBean.datum" />
 Schlagwort: <s:property value="probeBuchBean.schlagwort" />
 Typ der Publikation: <s:property value="probeBuchBean.typ" />
 ISBN: <s:property value="probeBuchBean.isbn" />
 Verlag: <s:property value="probeBuchBean.verlag" />
 Anzahl: <s:property value="probeBuchBean.anzahl" />
 
 </p>

</body>
</html>