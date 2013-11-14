<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead style="background-color:#FF7140">
	<tr>
		<th>Titel</th>
		<th>Veröffentlichungsdatum</th>
		<th>ISBN</th>
		<th>Verlag</th>
		<th>Ausgabe</th>
		<th>Auflage</th>
		<th>Verliehen</th>
		<th>Reserviert</th>
	</tr>
	<thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="publications">
			<tr>

				<td><a href="<s:url action="showPublicationDetailAction"><s:param name="publicationID" value="publicationID" /></s:url>"><s:property value="title"/></a></td>
				<td><s:property value="publicationDate"/></td>
				<td><s:property value="isbn"/></td>
				<td><s:property value="publisher"/></td>
				<td><s:property value="edition"/></td>
				<td><s:property value="issue"/></td>
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
				<td>
				<s:form action="sortColumnVerlag">
					<s:submit value="sortieren" />
				</s:form> 
				</td>
				<td>
				<s:form action="sortColumnVerlag">
					<s:submit value="sortieren" />
				</s:form> 
				</td>
				<td>
				<s:form action="sortColumnVerlag">
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

</body>
</html>