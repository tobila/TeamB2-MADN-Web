<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
img {
  width:100%;
  height:auto;
}
table	{width:100%; height:100%; }
td		{width:9%; height:9%; text-align: center;}
.panel {
position:relative;
width:40%;
padding-top:40%;
}
.content {
position:absolute;
height:100%;
width:100%;
margin-top:-100%;
background-image:url(bilder/madnbg.jpg);
background-size: 100% 100%;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spiel</title>
</head>
<body>
<% 
if(session.getAttribute("init").equals("0")){
	spiel.initSpiel();
}
session.setAttribute("init", "1");
%>
	<center>
		
		<div class="menu">
			<%if(request.getParameter("id") != null)
				out.print("<a href='SpielServlet?id="+request.getParameter("id").toString()+"'><button>Zug durchführen</button></a>");
			else
				out.print("<a href='SpielServlet'><button disabled='disabled'>Zug durchführen</button></a>");%>
			<a href=SaveFormular.jsp target="new"><button>Speichern</button></a> 
		</div>
		<br />
		
		<div class="panel">
			<div class="content">

				<table border="0">
					<tr>
						<td id="sr1" ><%
							if(spiel.getBrett().getSpielbrett()[0].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[0].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>

						<td id="sr2"><%
							if(spiel.getBrett().getSpielbrett()[0].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[0].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[8].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[8].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[8].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[9].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[9].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[9].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td id="sb1"><%
							if(spiel.getBrett().getSpielbrett()[10].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[10].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
						<td id="sb2"><%
							if(spiel.getBrett().getSpielbrett()[10].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[10].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
					</tr>
					<tr>
						<td id="sr3"><%
							if(spiel.getBrett().getSpielbrett()[0].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[0].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td id="sr4"><%
							if(spiel.getBrett().getSpielbrett()[0].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[0].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[7].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[7].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[7].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="eb1"><%
							if(spiel.getBrett().getSpielbrett()[9].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[9].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[11].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[11].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[11].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td id="sb3"><%
							if(spiel.getBrett().getSpielbrett()[10].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[10].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
						<td id="sb4"><%
							if(spiel.getBrett().getSpielbrett()[10].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[10].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[6].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[6].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[6].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="eb2"><%
							if(spiel.getBrett().getSpielbrett()[9].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[9].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[12].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[12].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[12].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[5].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[5].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[5].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="eb3"><%
							if(spiel.getBrett().getSpielbrett()[9].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[9].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[13].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[13].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[13].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><%
							if(spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[1].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[1].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[1].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[2].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[2].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[2].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[3].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[3].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[3].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[4].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[4].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[4].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="eb4"><%
							if(spiel.getBrett().getSpielbrett()[9].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[9].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[14].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[14].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[14].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[15].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[15].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[15].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[16].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[16].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[16].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[17].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[17].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[17].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[18].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[18].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[18].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
					</tr>
					<tr>
						<td><%
							if(spiel.getBrett().getSpielbrett()[39].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[39].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[39].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="er1"><%
							if(spiel.getBrett().getSpielbrett()[39].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[39].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td id="er2"><%
							if(spiel.getBrett().getSpielbrett()[39].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[39].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td id="er3"><%
							if(spiel.getBrett().getSpielbrett()[39].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[39].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td id="er4"><%
							if(spiel.getBrett().getSpielbrett()[39].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[39].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
							}
						%></td>
						<td></td>
						<td id="eg4"><%
							if(spiel.getBrett().getSpielbrett()[19].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[19].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
						<td id="eg3"><%
							if(spiel.getBrett().getSpielbrett()[19].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[19].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
						<td id="eg2"><%
							if(spiel.getBrett().getSpielbrett()[19].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[19].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
						<td id="eg1"><%
							if(spiel.getBrett().getSpielbrett()[19].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[19].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[19].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[19].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[19].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
					</tr>
					<tr>
						<td><%
							if(spiel.getBrett().getSpielbrett()[38].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[38].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[38].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[37].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[37].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[37].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[36].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[36].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[36].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[35].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[35].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[35].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[34].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[34].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[34].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="ey4"><%
							if(spiel.getBrett().getSpielbrett()[29].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[29].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[24].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[24].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[24].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[23].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[23].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[23].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[22].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[22].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[22].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[21].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[21].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[21].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[33].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[33].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[33].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="ey3"><%
							if(spiel.getBrett().getSpielbrett()[29].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[29].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[25].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[25].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[25].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[32].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[32].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[32].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="ey2"><%
							if(spiel.getBrett().getSpielbrett()[29].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[29].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[26].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[26].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[26].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td id="sy1"><%
							if(spiel.getBrett().getSpielbrett()[30].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[30].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="sy2"><%
							if(spiel.getBrett().getSpielbrett()[30].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[30].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[31].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[31].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[31].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="ey1"><%
							if(spiel.getBrett().getSpielbrett()[29].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[29].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[27].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[27].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[27].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td id="sg1"><%
							if(spiel.getBrett().getSpielbrett()[20].getFelder()[1].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[20].getFelder()[1].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
						<td id="sg2"><%
							if(spiel.getBrett().getSpielbrett()[20].getFelder()[2].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[20].getFelder()[2].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
					</tr>
					<tr>
						<td id="sy3"><%
							if(spiel.getBrett().getSpielbrett()[30].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[30].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td id="sy4"><%
							if(spiel.getBrett().getSpielbrett()[30].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[30].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[29].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[29].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[29].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td><%
							if(spiel.getBrett().getSpielbrett()[28].getFelder()[0].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[28].getFelder()[0].getSpielfigur().getID();
								FarbEnum farbe = spiel.getBrett().getSpielbrett()[28].getFelder()[0].getSpielfigur().getFarbe();
								if(farbe.equals(FarbEnum.RED))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_rot.png'></a>");
								else if(farbe.equals(FarbEnum.BLUE))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_blau.png'></a>");
								else if(farbe.equals(FarbEnum.GREEN))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
								else if(farbe.equals(FarbEnum.YELLOW))
									out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gelb.png'></a>");
							}
						%></td>
						<td></td>
						<td></td>
						<td id="sg3"><%
							if(spiel.getBrett().getSpielbrett()[20].getFelder()[3].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[20].getFelder()[3].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
						<td id="sg4"><%
							if(spiel.getBrett().getSpielbrett()[20].getFelder()[4].getSpielfigur() != null){
								int id = spiel.getBrett().getSpielbrett()[20].getFelder()[4].getSpielfigur().getID();
								out.print("<a href='spiel.jsp?id="+id+"'><img src='bilder/Figur_gruen.png'></a>");
							}
						%></td>
					</tr>
				</table>
			</div>
			
		
			
		</div>
			
		<br />
		<textarea name="log" readonly="readonly"
			style="width: 40%; resize: none;" rows="6">Logging blabla</textarea>
	</center>
	<%@ include file="footer.jsp"%>