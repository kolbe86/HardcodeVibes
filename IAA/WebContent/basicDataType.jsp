<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Basic Data Type</title>
</head>
<body>

<h4 style="background-color:#FF7140">Stammdaten Publikationsart</h4>


<div style="width:100%;height:60%;background-color:light-blue;margin:20px">

<s:form  action="sortBasicDataPublicationType" method="execute">
		<s:radio name="increasing" value="true" label="Sortierreihenfolge" list="#@java.util.LinkedHashMap@{true:'Aufsteigend',false:'Absteigend'}"/><br></br>
		<s:submit value="sortieren" />
</s:form> 

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

<h4 style="background-color:#FF7140">Details zur Publikationsart</h4>

				<s:form action="addPublicationTypeAction" >
					<s:textfield name="publicationTypeBean.name" label="Publikationsart" size="auto"/>
					<s:submit value="hinzufügen" />
					<s:submit value="löschen" action="deletePublicationTypeAction"/>
				</s:form> 
</div>
</body>
</html>