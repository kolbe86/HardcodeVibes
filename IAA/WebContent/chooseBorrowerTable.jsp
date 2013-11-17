<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose Borrower</title>
</head>
<body>
Sie möchten das Buch mit dem Titel <s:property value="publicationBean.title"/> ausleihen. Wählen Sie einen Ausleiher aus der Liste oder erstellen Sie über das Menu zunächst einen neuen Ausleiher:

<s:property value="publicationBean.publicationID"/>

<%-- <s:form action="sortBorrowerTablePublication" method="execute" escapeAmp="false"> --%>
<%-- 		<s:radio name="increasing" value="true" label="Sortierreihenfolge" list="#@java.util.LinkedHashMap@{true:'Aufsteigend',false:'Absteigend'}"/><br></br> --%>
<%-- 		<s:radio name="whichColumn"  value="'matNumber'" label="Spalte" list="#@java.util.LinkedHashMap@{'matNumber':'Matrikelnummer','firstName':'Vorname','lastName':'Nachname'}"/> --%>
<%-- 		<s:submit value="sortieren" /> --%>
<%-- </s:form>  --%>

<table>
	<thead style="background-color:#FF7140">
	<tr>
		<th>Matrikelnumer</th>
		<th>Vorname</th>
		<th>Nachname</th>
	</tr>
	<thead>
	<tbody style="background-color:#FFCF73"> 
		<s:iterator value="borrowers">
			<tr>
				<td><a href="<s:url action="createLendingProcessAction" escapeAmp="false">
								<s:param name="matriculationNumber" value="matriculationNumber"/>
								<s:param name="publicationID" value="publicationBean.publicationID"/>
								</s:url>"><s:property value="matriculationNumber"/></a></td>
				<td><s:property value="firstName"/></td>
				<td><s:property value="lastName"/></td>
			</tr>
		</s:iterator>
		</tbody>
</table>
</body>
</html>