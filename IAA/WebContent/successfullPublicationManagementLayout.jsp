<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>


<body style="height:100%;width:100%">

<div style="width:100%;height:60%;background-color:light-blue;margin:20px">
<h1>Publikationen</h1>

	<table>
	<thead style="background-color:#FF7140">
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
	<tbody style="background-color:#FFCF73">
		<s:iterator value="publications">
			<tr>

				<td><a href="<s:url action="publicationManagementDetailAction"><s:param name="publicationID" value="publicationID" /></s:url>"><s:property value="title"/></a></td>
				<td><s:property value="authors"/></td>
				<td><s:property value="publicationDate"/></td>
				<td><s:property value="keywords"/></td>
				<td><s:property value="condition"/></td>
				<td><s:property value="distributed"/></td>
				<td><s:property value="reserved"/></td>
			</tr>
		</s:iterator>
		</tbody>
			<tr style="border:solid,background-color:#FF7140">
				<td>
				<s:form action="sortColumnTitel">
					<s:submit value="sortieren" />
				</s:form>  
				</td>
				<td>
				<s:form action="sortColumnAuthor">
					<s:submit value="sortieren" />
				</s:form> 
				</td>
				<td>
				<s:form action="sortColumnIsbn">
					<s:submit value="sortieren" />
				</s:form> 
				</td>
				<td>
				<s:form action="sortColumnVerlag">
					<s:submit value="sortieren" />
				</s:form> 
				</td>
			</tr>
</table>


</div>

<div style="width:100%;height:40%;background-color:light-blue;margin:20px">
<%-- 	<s:property value="param"/> --%>
<h2>Publikationsdetails</h2>

	<table style="background-color:#FFCF73">
	<tr>
	<td><s:textfield name="publicationBean.title" label="Titel" size="auto"/></td>
	<td><s:textfield name="publicationBean.authors" label="Autoren"/></td>
	</tr>
	<tr>
	<td><s:textfield name="publicationBean.publicationDate" label="Publikationsdatum"/></td>
	<td><s:textfield name="publicationBean.keywords" label="Schlagwörter"/></td>
	</tr>
	<tr>
	<td><s:textfield name="publicationBean.condition" label="Zustand"/></td>
	<td><s:property value="publicationBean.distributed"/></td>
	</tr>
	<tr>
	<td><s:submit action="changePublicationAction" value="aendern" /></td>
	<td><s:submit action="deletePublicationAction" value="loeschen" /></td>
	</tr>
	</table>
</div>

</body>
</html>