<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>
</head>
<body>
<h3>Lege ein neues Magazin an</h3>

<s:form action="magazineCreationAction">

 	  <s:textfield name="magazineBean.title" label="Titel" value="Sport Bild"/>
 	  <s:textfield  name="magazineBean.authors" label="Autoren" value="Lothar Matthäus"/>
 	  <s:textfield name="magazineBean.publicationDate"  label ="Veroeffentlichungsdatum" value="23.06.1999"/>
 	  <s:textfield name="magazineBean.keywords"  label ="Schlagwörter" value="Tor des Montas"/>
 	  <s:textfield name="magazineBean.condition"  label ="Zustand" value="Alt"/>
 	  <s:textfield name="magazineBean.isbn"  label ="385-2-39275-193-6"/>
 	  <s:textfield name="magazineBean.publisher"  label ="Verlag" value="Axel Springer"/>
 	  <s:textfield name="magazineBean.issue"  label ="Ausgabe" value="Heft Nr. 23"/>
 	   
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>