<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MADN</title>
</head>
<body>

<div style="width:100%;" align="center">
	<form method='post' action='spiel_starten.jsp'>
	<% 
		if(spiel.getSpieler().size() == 0){
			out.println("Anzahl Spieler auswählen:"); 
			out.println("<select name=anzSpieler>"); 
			out.println("<option>1</option>"); 
			out.println("<option>2</option>"); 
			out.println("<option>3</option>"); 
			out.println("<option>4</option>"); 
			out.println("</select>");
		}
		session.setAttribute("aktu", "1");
	%>
	
	<br/>
	Farbe auswählen: 
	<select name='farbe'>
	<option value='red'>RED</option>
	<option value='blue'>BLUE</option>
	<option value='green'>GREEN</option>
	<option value='yellow'>YELLOW</option>
	</select>
	<br/>
	Name: <input name='name' type='text' size='20'></input>
	<input id='senden' type='submit' value='OK'></input>
	</form>
</div>
<%@ include file="footer.jsp" %>
