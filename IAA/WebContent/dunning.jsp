<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head><title>Simple jsp page</title></head>
  <body>
  <s:form action="marioTestLink">
  		<s:submit label="Test-Knopf"/>
  </s:form>
  
  
  <p><a href="<s:url action="marioTestLink" />" >TEST TEST TEST</a></p></body>
</html>