<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body style="height:100%;width:100%;opacity:0.5">

<div style="width:100%;height:15%;background-color:#025167;"><tiles:insertAttribute name="header" /></div>
<div style="width:16%;height:85%;background-color:pink;float:left">

	<div style="width:100%;height:50%;background-color:#FFCF73;float:left"><tiles:insertAttribute name="menu" /></div>
	<div style="width:100%;height:50%;background-color:aqua;float:left"><tiles:insertAttribute name="dunning" /></div>
</div>
<div style="width:84%;height:45%;background-color:red;float:left"><tiles:insertAttribute name="main" /></div>
<div style="width:42%;height:40%;background-color:green;float:left"><tiles:insertAttribute name="bottom-left" /></div>
<div style="width:42%;height:40%;background-color:yellow;float:left"><tiles:insertAttribute name="bottom-right" /></div>

</body>
</html>