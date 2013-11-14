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
<body style="height:100%;width:100%">

<div style="width:100%;height:60%;background-color:light-blue;margin:20px">

<table>
	<thead style="background-color:#FF7140">
		<tr>
			<th>Publikationsarten</th>
		</tr>
	</thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="publicationTypes">
			<tr>
				<td>
				<a href="<s:url action="publicationTypeStartupAction"><s:param name="paramPublicationType" value="name" /></s:url>"><s:property value="name"/></a>
				</td>

			</tr>
		</s:iterator>
	</tbody>
</table>
</div>

<div style="width:100%;height:40%;background-color:light-blue;margin:20px">


<s:textfield name="tempFieldPublicationType" label="Publikationsart" size="auto"/>
				<s:form action="addPublicationTypeAction">
					<s:submit value="hinzuf�gen" />
				</s:form> 
				<s:form action="deletePublicationTypeAction">
					<s:submit value="l�schen" />
				</s:form> 
</div>
</body>
</html>