<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lending Process</title>
</head>
<body style="height:100%;width:100%">

<div style="width:100%;height:60%;background-color:light-blue;margin:20px">

<s:form action="sortLendingProcess" method="execute" escapeAmp="false">
		<s:radio name="increasing" value="true" label="Sortierreihenfolge" list="#@java.util.LinkedHashMap@{true:'Aufsteigend',false:'Absteigend'}"/><br></br>
		<s:radio name="whichColumn"  value="'borrower'" label="Spalte" list="#@java.util.LinkedHashMap@{'borrower':'Ausleiher','publication':'Publikation','issueDate':'Ausleihdatum','returnDate':'Rückgabedatum','extensionOfTimeLevel':'Verlängerungslevel','status':'Status','dunningLevel':'Mahnstufe'}"/>
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
			<th>Status</th>
			<th>Mahnstufe</th>
		</tr>
	</thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="lendingProcesses">
			<tr>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="borrower.matriculationNumber"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="publication.publicationID"/></a>
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
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="status"/></a>
				</td>
				<td>
				<a href="<s:url action="lendingProcessStartupAction"><s:param name="paramLendingProcess" value="lendingProcessID" /></s:url>"><s:property value="dunningLevel"/></a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</div>

<div style="width:100%;height:40%;background-color:light-blue;margin:20px">

		<s:form action="giveBackPublicationAction">
			<s:textfield name="lendingProcessBean.lendingProcessID" label="ID"/>
			<s:textfield name="lendingProcessBean.borrower" label="Ausleiher" disabled="true"/>
			<s:textfield name="lendingProcessBean.publication" label="Publikation" disabled="true"/>
			<s:textfield name="lendingProcessBean.issueDate" label="Ausleihdatum" disabled="true"/>
			<s:textfield name="lendingProcessBean.returnDate" label="Rückgabedatum" disabled="true"/>
			<s:textfield name="lendingProcessBean.extensionOfTimeLevel" label="Verlängerungslevel" disabled="true"/>
			<s:textfield name="lendingProcessBean.status" label="Status" disabled="true"/>
			<s:textfield name="lendingProcessBean.dunningLevel" label="Mahnstufe" disabled="true"/>
					<s:submit value="Rückgabe" />
					<s:submit value="verlängern" action="extendLendingProcessAction"/>
					<s:submit value="Verlust" action="lostPublicationAction"/>
					<s:param name="paramLendingProcess" value="lendingProcessBean.lendingProcessID"/>
				</s:form> 
</div>
</body>
</html>