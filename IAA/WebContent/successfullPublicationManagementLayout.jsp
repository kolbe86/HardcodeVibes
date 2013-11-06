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

<table style="border:solid;background-color:pink">
	<tr>
		<th>Titel</th>
		<th>Author</th>
		<th>ISBN</th>
		<th>Verlag</th>
	</tr>
		<s:iterator value="publications">
			<tr>
				<td><s:property value="titel"/></td>
				<td><s:property value="author"/></td>
				<td><s:property value="isbn"/></td>
				<td><s:property value="verlag"/></td>
			</tr>
		</s:iterator>
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

<div style="width:100%;height:40%;background-color:green;">du da</div>

</body>
</html>