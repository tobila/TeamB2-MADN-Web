<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MADN</title>
</head>
<body>
<div style="text-align: center;">
<h1>Mensch Ärgere Dich Nicht</h1>
</div>

<div style="width:100%;" align="center">
	<form method='get' action='index.jsp'><% 
		
			out.println("<span> Anzahl Spieler auswählen:</span>"); 
			out.println("<select name=\"anzSpieler\">");
			out.println("<option>0</option>"); 
			out.println("<option>1</option>"); 
			out.println("<option>2</option>"); 
			out.println("<option>3</option>"); 
			out.println("<option>4</option>");
			
			
			
			out.println("</select>");
			out.println("<br />");
			out.println("<span>Anzahl Ki Auswählen:</span>");
			
			out.println("<select name=anzKi>"); 
			out.println("<option>0</option>"); 
			out.println("<option>1</option>"); 
			out.println("<option>2</option>"); 
			out.println("<option>3</option>"); 
			out.println("<option>4</option>");
			
			out.println("</select>");
		
		session.setAttribute("aktu", "1");
	%>
	</br>
	<input id='senden' type='submit' value='OK'>
	</form>
	</div>
<%@ include file="footer.jsp" %>
