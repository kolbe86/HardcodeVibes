<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
	<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<!-- Header -->
	<tiles:insertAttribute name="header"/>
	<!-- Content -->
	<tiles:insertAttribute name="content"/>
</body>
</html>