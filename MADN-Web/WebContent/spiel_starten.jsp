<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spiel starten..</title>
</head>
<body>
<div style="width:100%;" align="center">
<%
	if(spiel.getSpieler().size() == 0){
		application.setAttribute("anzSpieler", request.getParameter("anzSpieler"));
	}
	
	String anzSpieler = application.getAttribute("anzSpieler").toString();
	int sp = Integer.parseInt(anzSpieler);
	
	if(session.getAttribute("aktu").equals("1")){
		String farbe = request.getParameter("farbe");
		String name = request.getParameter("name");
	
		spiel.SpielerHinzufuegen(name, farbe, null);
	}
	
	session.setAttribute("aktu", "2");
	if(sp == spiel.getSpieler().size()){
		response.sendRedirect("spiel.jsp");
	}
%>
<br/>Warte auf andere Spieler.. <a href="spiel_starten.jsp">aktualisieren</a>
<br/>Aktuelle anzahl Spieler: <% out.print(spiel.getSpieler().size()); %>
</div>
<%@ include file="footer.jsp" %>