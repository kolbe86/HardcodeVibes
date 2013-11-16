<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action="sortPublications" method="execute" escapeAmp="false">
		<s:radio name="increasing" value="true" label="Sortierreihenfolge" list="#@java.util.LinkedHashMap@{true:'Aufsteigend',false:'Absteigend'}"/><br></br>
		<s:radio name="whichColumn"  value="'title'" label="Spalte" list="#@java.util.LinkedHashMap@{'title':'Titel','publicationDate':'Veröffentlichungsdatum','publicationType':'Publikationsart','keyword':'Schlagwörter','isbn':'ISBN','publisher':'Verlag','edition':'Ausgabe','issue':'Auflage','distributed':'Verliehen','reserved':'Reserviert','condition':'Zustand'}"/>
		<s:submit value="sortieren" />
	</s:form> 
<table>
	<thead style="background-color:#FF7140">
	<tr>
		<th>Titel</th>
<!-- 		<th>Autoren</th> -->
		<th>Veröffentlichungsdatum</th>
		<th>Publikationsart</th>
		<th>Schlagwörter</th>
		<th>ISBN</th>
		<th>Verlag</th>
		<th>Ausgabe</th>
		<th>Auflage</th>
		<th>Verliehen</th>
		<th>Reserviert</th>
		<th>Zustand</th>
	</tr>
	<thead>
	<tbody style="background-color:#FFCF73">
		<s:iterator value="publications">
			<tr>

				<td><a href="<s:url action="showPublicationDetailAction"><s:param name="publicationID" value="publicationID" /></s:url>"><s:property value="title"/></a></td>	
<!-- 				<td> -->
<%-- 					<s:iterator value="authors"> --%>
<%-- 						<s:property value="authors"/> --%>
<%-- 					</s:iterator> --%>
<!-- 				</td> -->
				<td><s:property value="publicationDate"/></td>
				<td><s:property value="publicationType"/></td>
				<td><s:iterator value="keywords">
					<s:property value="name"/> - 
				</s:iterator></td>
				<td><s:property value="isbn"/></td>
				<td><s:property value="publisher"/></td>
				<td><s:property value="edition"/></td>
				<td><s:property value="issue"/></td>
				<td><s:property value="distributed"/></td>
				<td><s:property value="reserved"/></td>
				<td><s:property value="condition"/></td>
			</tr>
		</s:iterator>
		</tbody>
</table>

</body>
</html>