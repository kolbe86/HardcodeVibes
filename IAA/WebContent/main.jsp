<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Lending Process</title>
</head>
<body style="height:100%;width:100%">

<h1>Die Bibliothekare Chu, Kolbe und Mäckel begrüßen Sie!</h1>
<br></br>
<h1>Übersicht gemahnter Ausleihvorgänge:</h1>
<br></br>
<s:form action="sortDunnedLendingProcess" method="execute" escapeAmp="false">
		<s:radio name="increasing" value="true" label="Sortierreihenfolge" list="#@java.util.LinkedHashMap@{true:'Aufsteigend',false:'Absteigend'}"/><br></br>
		<s:radio name="whichColumn"  value="'borrower'" label="Spalte" list="#@java.util.LinkedHashMap@{'borrower':'Ausleiher','publication':'Publikation','issueDate':'Ausleihdatum','returnDate':'Rückgabedatum','extensionOfTimeLevel':'Verlängerungslevel','dunningLevel':'Mahnstufe'}"/>
		<s:submit value="sortieren" />
</s:form> 
<table>
	<thead style="background-color:#FF7140">
		<tr>
			<th>Ausleiher</th>
			<th>Publikation</th>
			<th>Ausleihdatum</th>
			<th>Rückgabedatum</th>
			<th>Verlängerungslevel</th>
			<th>Mahnstufe</th>
		</tr>
	</thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="lendingProcesses">
			<tr>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="borrower"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="publication"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="issueDate"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="returnDate"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="extensionOfTimeLevel"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="dunningLevel"/></a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</body>
</html>