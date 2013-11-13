<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>


<body style="height:100%;width:100%;opacity:0.5">

<div style="width:100%;height:60%;background-color:red;">wohooo

	<table style="border:solid">
	<thead>
	<tr>
		<th>Titel</th>
		<th>Autoren</th>
		<th>Veröffentlichungsdatum</th>
		<th>Schlagwörter</th>
		<th>Zustand</th>
		<th>Verliehen</th>
		<th>Reserviert</th>
	</tr>
	<thead>
	<tbody>
		<s:iterator value="publications">
			<tr>

				<td><a href="<s:url action="publicationManagementDetailAction"><s:param name="publicationID" value="publicationID" /></s:url>"><s:property value="title"/></a></td>
				<td><s:property value="authors"/></td>
				<td><s:property value="publicationDate"/></td>
				<td><s:property value="keywords"/></td>
				<td><s:property value="condition"/></td>
				<td><s:property value="distributed"/></td>
				<td><s:property value="reserved"/></td>
				<td>Moin</td>
				<td>Moin</td>
				<td>Moin</td>
			</tr>
		</s:iterator>
			<tr onclick='<s:action name="sortColumnTitel"/>' >
				<td onclick='<s:action name="sortColumnTitel"/>'>Moin</td>
				<td>Moin</td>
				<td>Moin</td>
			</tr>
		</tbody>
			<tr style="border:solid,background-color:red">
				<td>
				<s:form action="sortColumnTitel">
					<s:submit property="sortieren" />
				</s:form>  
				</td>
				<td>
				<s:form action="sortColumnAuthor">
					<s:submit property="sortieren" />
				</s:form> 
				</td>
				<td>
				<s:form action="sortColumnIsbn">
					<s:submit property="sortieren" />
				</s:form> 
				</td>
				<td>
				<s:form action="sortColumnVerlag">
					<s:submit property="sortieren" />
				</s:form> 
				</td>
			</tr>
</table>


</div>

<div style="width:100%;height:40%;background-color:green;">
<%-- 	<s:property value="param"/> --%>
	<s:form action="baseLayoutLink">
	<s:textfield name="publicationBean.title" label="Titel"/><br>
	<s:textfield name="publicationBean.authors" label="Authoren"/><br>
	<s:textfield name="publicationBean.publicationDate" label="Publikationsdatum"/><br>
	<s:textfield name="publicationBean.keywords" label="Schlagwörter"/><br>
	<s:textfield name="publicationBean.condition" label="Zustand"/><br>
	<s:property value="publicationBean.distributed"/>
	
	<s:submit/>
	</s:form>

</div>

</body>
</html>