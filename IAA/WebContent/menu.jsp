<%@taglib uri="/struts-tags" prefix="s"%>

Publikation
<ul>
	<li>
		<a href="<s:url action="publicationCreationLink" />" >anlegen</a>
	</li>
	<li><a href="<s:url action="publicationManagementLink" />" >verwalten</a></li>	
</ul>
Ausleihvorgang
<ul>
	<li><a href="<s:url action="lendingProcessManagementLink" />" >verwalten</a></li>
</ul>
Stammdaten
<ul>
	<li><a href="<s:url action="basicDataTypeLink" />" >Art</a></li>
	<li><a href="<s:url action="basicDataWordLink" />" >Schlagwort</a></li>	
	<li><a href="<s:url action="basicDataLenderLink" />" >Ausleiher</a></li>	
</ul>
