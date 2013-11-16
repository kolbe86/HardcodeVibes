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

<h1>Der folgende Ausleihvorgang wurde erfolgreich verlängert::</h1>

<table>
<tr><td>Ausleiher:</td><td><s:property value="lendingProcessBean.borrower" /></td></tr>
<tr><td>Publikation</td><td><s:property value="lendingProcessBean.publication"/></td></tr>
<tr><td>Ausleihdatum: </td><td><s:property value="lendingProcessBean.issueDate"/></td></tr>
<tr><td>Rückgabedatum: </td><td><s:property value="lendingProcessBean.returnDate"/></td></tr>
<tr><td>Verlängerungslevel:</td><td><s:property value="lendingProcessBean.extensionOfTimeLevel" /></td></tr>
<tr><td>Status:</td><td><s:property value="lendingProcessBean.status" /></td></tr>
<tr><td>Mahnstufe: </td><td><s:property value="lendingProcessBean.dunningLevel"/></td></tr>
</table>
</body>
</html>