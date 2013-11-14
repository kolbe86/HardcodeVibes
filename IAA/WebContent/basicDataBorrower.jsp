<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Basic Data Borrower</title>
</head>
<body style="height:100%;width:100%">

<div style="width:100%;height:60%;background-color:light-blue;margin:20px">

<table>
	<thead style="background-color:#FF7140">
		<tr>
			<th>Ausleiher</th>
		</tr>
	</thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="borrowers">
			<tr>
				<td>
				<a href="<s:url action="borrowerStartupAction"><s:param name="paramBorrower" value="borrowerID" /></s:url>"><s:property value="name"/></a>
				</td>

			</tr>
		</s:iterator>
	</tbody>
</table>
</div>

<div style="width:100%;height:40%;background-color:light-blue;margin:20px">


<s:textfield name="tempFieldBorrower" label="Ausleiher" size="auto"/>
				<s:form action="addBorrowerAction">
					<s:submit value="hinzufügen" />
				</s:form> 
				<s:form action="deleteBorrowerAction">
					<s:submit value="löschen" />
				</s:form> 
</div>
</body>
</html>