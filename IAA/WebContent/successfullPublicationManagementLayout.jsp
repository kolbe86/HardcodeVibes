<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html style="height:100%">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
		<style type="text/css">
	
	body{
		font-size:0.8em;
		font-family: Trebuchet MS, Lucida Sans Unicode, Arial, sans-serif;
		margin:0px;
		padding:0px;
	}
	img{
		border:0px;
	}
	thead td{
		font-weight:bold;
		color:#000;
		background-color:#E2EBED;
	}
	td{
		padding:2px;
	}
	table{
		border:1px solid #000;
		border-collapse: collapse;
	}
	h1{
		font-size:1.3em;
		margin-bottom:0px;
	}
	table,h1,p,#ads{
		margin-left:10px;
	}
	#ads{
		margin-top:20px;
	}
	
	/* These classes are used by the script as rollover effect for table 1 and 2 */
	
	.tableRollOverEffect1{
		background-color:#000;
		color:#FFF;
	}

	.tableRollOverEffect2{
		background-color:#000;
		color:#FFF;
	}
	
	.tableRowClickEffect1{
		background-color:#F00;
		color:#FFF;
	}
	.tableRowClickEffect2{
		background-color:#00F;
		color:#FFF;
	}
	
	</style>
	<script type="text/javascript">
	/************************************************************************************************************
	(C) www.dhtmlgoodies.com, November 2005
	
	This is a script from www.dhtmlgoodies.com. You will find this and a lot of other scripts at our website.	
	
	Terms of use:
	You are free to use this script as long as the copyright message is kept intact. However, you may not
	redistribute, sell or repost it without our permission.
	
	Thank you!
	
	www.dhtmlgoodies.com
	Alf Magne Kalleland
	
	************************************************************************************************************/	
	var arrayOfRolloverClasses = new Array();
	var arrayOfClickClasses = new Array();
	var activeRow = false;
	var activeRowClickArray = new Array();
	
	function highlightTableRow()
	{
		var tableObj = this.parentNode;
		if(tableObj.tagName!='TABLE')tableObj = tableObj.parentNode;

		if(this!=activeRow){
			this.setAttribute('origCl',this.className);
			this.origCl = this.className;
		}
		this.className = arrayOfRolloverClasses[tableObj.id];
		
		activeRow = this;
		
	}
	
	function clickOnTableRow()
	{
		var tableObj = this.parentNode;
		if(tableObj.tagName!='TABLE')tableObj = tableObj.parentNode;		
		
		if(activeRowClickArray[tableObj.id] && this!=activeRowClickArray[tableObj.id]){
			activeRowClickArray[tableObj.id].className='';
		}
		this.className = arrayOfClickClasses[tableObj.id];
		
		activeRowClickArray[tableObj.id] = this;
				
	}
	
	function resetRowStyle()
	{
		var tableObj = this.parentNode;
		if(tableObj.tagName!='TABLE')tableObj = tableObj.parentNode;

		if(activeRowClickArray[tableObj.id] && this==activeRowClickArray[tableObj.id]){
			this.className = arrayOfClickClasses[tableObj.id];
			return;	
		}
		
		var origCl = this.getAttribute('origCl');
		if(!origCl)origCl = this.origCl;
		this.className=origCl;
		
	}
		
	function addTableRolloverEffect(tableId,whichClass,whichClassOnClick)
	{
		arrayOfRolloverClasses[tableId] = whichClass;
		arrayOfClickClasses[tableId] = whichClassOnClick;
		
		var tableObj = document.getElementById(tableId);
		var tBody = tableObj.getElementsByTagName('TBODY');
		if(tBody){
			var rows = tBody[0].getElementsByTagName('TR');
		}else{
			var rows = tableObj.getElementsByTagName('TR');
		}
		for(var no=0;no<rows.length;no++){
			rows[no].onmouseover = highlightTableRow;
			rows[no].onmouseout = resetRowStyle;
			
			if(whichClassOnClick){
				rows[no].onclick = clickOnTableRow;	
			}
		}
		
	}
	</script>
</head>
<body style="height:100%;width:100%;opacity:0.5">

<div style="width:100%;height:60%;background-color:red;">wohooo

<table id="myTable">
	<thead>
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
	<tbody>
		<s:iterator value="publications">
			<tr>

				<td><s:property value="title"/></td>
				<td><s:property value="authors"/></td>
				<td><s:property value="publicationDate"/></td>
				<td><s:property value="keywords"/></td>
				<td><s:property value="condition"/></td>
				<td><s:property value="distributed"/></td>
				<td><s:property value="reserved"/></td>
			</tr>
		</s:iterator>
		</tbody>
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

<script type="text/javascript">
addTableRolloverEffect('myTable','tableRollOverEffect1','tableRowClickEffect1');
addTableRolloverEffect('myTable2','tableRollOverEffect2','tableRowClickEffect2');
</script>


</div>

<div style="width:100%;height:40%;background-color:green;">du da</div>

</body>
</html>