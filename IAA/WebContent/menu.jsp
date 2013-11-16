<%@taglib uri="/struts-tags" prefix="s"%>

Publikation
<ul>
	<li>
		<a href="<s:url action="publicationCreationLink" />" >Anlegen</a>
	</li>
	<li><a href="<s:url action="searchPublicationLink" />" >Suchen</a></li>	
	<li><a href="<s:url action="listPublicationsLink" />" >Publikationsliste</a></li>	
</ul>
Ausleihvorgang
<ul>
	<li><a href="<s:url action="lendingProcessManagementLink" />" >verwalten</a></li>
</ul>
Stammdaten
<ul>
	<li><a href="<s:url action="publicationTypeStartupAction" />" >Art</a></li>
	<li><a href="<s:url action="keywordStartupAction" />" >Schlagwort</a></li>	
	<li><a href="<s:url action="borrowerStartupAction" />" >Ausleiher</a></li>	
</ul>

