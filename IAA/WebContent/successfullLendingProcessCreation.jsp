<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SuccessfulLendingPrcessCreation</title>
</head>
<body>
<h1>Ausleihvorgang erfolgreich erstellt</h1><br/>
ID: <s:property value="publicationBean.publicationID"/><br/>
Titel: <s:property value="publicationBean.title" /><br/>
Veröffentlichungsdatum: <s:property value="publicationBean.publicationDate"/><br/>
Edition: <s:property value="publicationBean.edition"/><br/>
Issue <s:property value="publicationBean.issue"/><br/>
Zustand: <s:property value="publicationBean.condition"/><br/>
			
</body>
</html>