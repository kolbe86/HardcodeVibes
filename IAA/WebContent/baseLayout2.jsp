<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body style="height:100%;width:100%;opacity:0.5">

<div style="width:100%;height:15%;background-color:#FF7140"><tiles:insertAttribute name="header" /></div>
<div style="width:16%;height:85%;background-color:pink;float:left">

	<div style="width:100%;height:70%;background-color:#FFCF73;float:left"><tiles:insertAttribute name="menu" /></div>
	<div style="width:100%;height:30%;background-color:#FFCF73;float:left"><tiles:insertAttribute name="dunning" /></div>
</div>
<div style="width:82%;height:55%;float:left;overflow:scroll"><tiles:insertAttribute name="main" /></div>
<div style="width:41%;height:30%;float:left;overflow:scroll"><tiles:insertAttribute name="bottom-left" /></div>
<div style="width:41%;height:30%;float:left;overflow:scroll"><tiles:insertAttribute name="bottom-right" /></div>

</body>
</html>