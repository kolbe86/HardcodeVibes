<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
PublicationDetail

<s:form>
		<table style="background-color:#FFCF73">
		<thead style="background-color:#FF7140">
			<tr>
				<th>Spalte 1</th>
				<th>Spalte 2</th>
				<th>Spalte 3</th>
			</tr>
		</thead>
		<tbody style="background-color:#FFCF73">
			<tr>
				<td><s:textfield name="publicationBean.publicationID" label="ID"></s:textfield></td>
				<td><s:textfield name="publicationBean.title" label="Titel" size="auto"/></td>
<%-- 				<td><s:textfield name="publicationBean.authors" label="Autoren"/></td> --%>
				<td><s:textfield name="publicationBean.publicationDate" label="Publikationsdatum"/></td>
			</tr>
<!-- 				<tr> -->
<%-- 					<td><s:textfield name="publicationBean.keywords" label="Schlagwörter"/></td> --%>
<%-- 					<td><s:textfield name="publicationBean.isbn" label="ISBN"/></td> --%>
<%-- 					<td><s:textfield name="publicationBean.publisher" label="Verlag"/></td> --%>
<!-- 				</tr> -->
			<tr>
				<td><s:textfield name="publicationBean.edition" label="Ausgabe"/></td>
				<td><s:textfield name="publicationBean.issue" label="Auflage"/></td>
				<td><s:textfield name="publicationBean.condition" label="Zustand"/></td>
			</tr>
			<tr>
				<td><s:submit action="changePublicationAction" value="aendern" /></td>
				<td><s:submit action="deletePublicationAction" value="loeschen" /></td>
				<td><s:submit action="createLendingProcessAction" value="Ausleihvorgang anlegen" /></td>
			</tr>
		</tbody>
		</table>
	</s:form>

</body>
</html>