<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<table>
	<tr>
		<th>Building</th>
		<th>Room Number</th>
		<th>Seats</th>
		<th>Beamer</th>
	</tr>
		<s:iterator value="rooms">
			<tr>
				<td><s:property value="building"/></td>
				<td><s:property value="roomNumber"/></td>
				<td><s:property value="seats"/></td>
				<td><s:property value="beamer"/></td>
			</tr>
		</s:iterator>
</table>