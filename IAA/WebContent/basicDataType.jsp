<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Basic Data Type</title>
</head>
<body>
<table>
	<tr>
		<th>Eins</th>
		<th>Zwei</th>
		<th>Drei</th>
		<th>Vier</th>
	</tr>
		<s:iterator value="basicDataKeeper.tempPublicationType">
			<tr>
				<td><s:property value="tempPublicationType"/></td>
				<td><s:property value="tempPublicationType"/></td>
				<td><s:property value="tempPublicationType"/></td>
				<td><s:property value="tempPublicationType"/></td>
			</tr>
		</s:iterator>
</table>
</body>
</html>