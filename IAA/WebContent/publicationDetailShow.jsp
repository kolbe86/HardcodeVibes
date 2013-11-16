<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form>
		<table style="background-color:#FFCF73">
		<tbody style="background-color:#FFCF73">
			<tr>
				<td><s:textfield name="publicationBean.publicationID" label="ID"></s:textfield></td>
<%-- 					<s:submit action="showPublicationDetailAction" value="Publikation anzeigen"/> --%>
				<td><s:textfield name="publicationBean.title" label="Titel" size="auto" disabled="true"/></td>
				<td><s:textfield name="publicationBean.publicationDate" label="Publikationsdatum" disabled="true"/></td>
				<td><s:textfield name="publicationBean.publicationType" label="Publikationsart" disabled="true"/></td>
				<td><s:textfield name="publicationBean.keywords" label="Schlagwörter" disabled="true"/></td>
				<td><s:textfield name="publicationBean.isbn" label="ISBN" disabled="true"/></td>
				<td><s:textfield name="publicationBean.publisher" label="Verlag" disabled="true"/></td>
				<td><s:textfield name="publicationBean.edition" label="Ausgabe" disabled="true"/></td>
				<td><s:textfield name="publicationBean.issue" label="Auflage" disabled="true"/></td>
				<td><s:textfield name="publicationBean.condition" label="Zustand" disabled="true"/></td>
				<td><s:checkbox name="publicationBean.distributed" label="Verliehen" disabled="true"></s:checkbox>
				<s:submit action="showPublicationChangeAction" value="aendern"/>
				<s:submit action="deletePublicationAction" value="loeschen" />
				<s:submit action="chooseBorrowerAction" value="Ausleihvorgang anlegen" />
			</tr>
		</tbody>
		</table>
	</s:form>

</body>
</html>