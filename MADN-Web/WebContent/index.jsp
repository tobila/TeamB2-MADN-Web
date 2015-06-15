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
	<form method='get' action='IndexServlet'>
	
	<%
	
	if(spiel.getSpieler().size() == 0){
		application.setAttribute("anzSpieler", request.getParameter("anzSpieler"));
		application.setAttribute("anzKi", request.getParameter("anzKi"));
	}
	String anzSpieler = application.getAttribute("anzSpieler").toString();
	int sp = Integer.parseInt(anzSpieler);
	
	
	String anzKi = application.getAttribute("anzKi").toString();
	int ki = Integer.parseInt(anzKi);
	
	
	int ergebnis=ki+sp;
	if(sp+ki>4){
		out.println("<html><head></head><body><div>");
		out.println("Maximal 4 Spieler auswählen <a href='login.jsp'> zurück </a>");
		out.println("<br/>Aktuelle anzahl Spieler: "+ergebnis);
		out.println("</div></body></html>");
		
	}
	if(sp==0){
		spiel.setGewählteKis(ki);
		 spiel.setGewählteSpieler(sp);
		 out.println("<input id='senden' type='submit' value='OK'>");
		 session.setAttribute("aktu", "1");
	}
	
	if(ergebnis<=4&& sp!=0){
	 spiel.setGewählteKis(ki);
	 spiel.setGewählteSpieler(sp);
	 session.setAttribute("aktu", "1");
	 application.setAttribute("init", "0");
		
		out.println("<span> Farbe wählen:</span>"); 
		out.println("<select name=\"farbe\">");
		
		out.println("<option value='red'>RED</option>"); 
		out.println("<option value='blue'>BLUE</option>"); 
		out.println("<option value='green'>GREEN</option>"); 
		out.println("<option value='yellow'>YELLOW</option>");
		
		
		
		out.println("</select>");
		out.println("<br />");
		out.println("<span> Name:</span>"); 
		out.println("<input name='name' type='text' size='20'>");
		out.println("<input id='senden' type='submit' value='OK'>"); 
		
	
	

	}
%>

	
	
	</form>
</div>

<%@ include file="footer.jsp" %>
