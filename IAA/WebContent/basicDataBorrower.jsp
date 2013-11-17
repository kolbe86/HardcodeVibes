<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=IUTF-8" />
<title>Basic Data Borrower</title>
</head>
<body style="height:100%;width:100%">

<div style="width:100%;height:60%;background-color:light-blue;margin:20px">

<s:form action="sortBasicDataBorrower" method="execute" escapeAmp="false">
		<s:radio name="increasing" value="true" label="Sortierreihenfolge" list="#@java.util.LinkedHashMap@{true:'Aufsteigend',false:'Absteigend'}"/><br></br>
		<s:radio name="whichColumn"  value="'matNumber'" label="Spalte" list="#@java.util.LinkedHashMap@{'matNumber':'Matrikelnummer','firstName':'Vorname','lastName':'Nachname'}"/>
		<s:submit value="sortieren" />
</s:form> 
<table>
	<thead style="background-color:#FF7140">
		<tr>
			<th>Matrikelnummer</th>
			<th>Vorname</th>
			<th>Nachname</th>
		</tr>
	</thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="borrowers">
			<tr>
				<td>
				<a href="<s:url action="borrowerStartupAction"><s:param name="paramBorrower" value="matriculationNumber" /></s:url>"><s:property value="matriculationNumber"/></a>
				</td>
				<td>
				<a href="<s:url action="borrowerStartupAction"><s:param name="paramBorrower" value="matriculationNumber" /></s:url>"><s:property value="firstName"/></a>
				</td>
				<td>
				<a href="<s:url action="borrowerStartupAction"><s:param name="paramBorrower" value="matriculationNumber" /></s:url>"><s:property value="lastName"/></a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</div>

<div style="width:100%;height:40%;background-color:light-blue;margin:20px">

		<s:form action="addBorrowerAction" acceptcharset="utf-8">
			<s:textfield name="borrowerBean.matriculationNumber" label="Matrikelnummer" size="auto"/>
			<s:textfield name="borrowerBean.firstName" label="Vorname" size="auto"/>
			<s:textfield name="borrowerBean.lastName" label="Nachname" size="auto"/>
					<s:submit value="hinzufügen"/>
					<s:submit value="löschen" action="deleteBorrowerAction"/>
				</s:form> 
</div>
</body>
</html>