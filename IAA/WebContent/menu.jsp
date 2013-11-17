<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
Startseite
<ul>
	<li><a href="<s:url action="mainPageStartupAction" />" >anzeigen</a></li>
</ul>

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
	<li><a href="<s:url action="lendingProcessStartupAction" />" >verwalten</a></li>
</ul>
Stammdaten
<ul>
	<li><a href="<s:url action="publicationTypeStartupAction" />" >Art</a></li>
	<li><a href="<s:url action="keywordStartupAction" />" >Schlagwort</a></li>	
	<li><a href="<s:url action="borrowerStartupAction" />" >Ausleiher</a></li>	
</ul>

