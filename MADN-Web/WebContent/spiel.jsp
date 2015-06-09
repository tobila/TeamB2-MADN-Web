<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table	{width:100%; height:100%; }
td		{width:9%; height:9%;}
.panel {
position:relative;
width:30%;
padding-top:30%;
}
.content {
position:absolute;
height:100%;
width:100%;
margin-top:-100%;
background-image:url(madnbg.jpg);
background-size: 100% 100%;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spiel</title>
</head>
<body>
<%
		spiel.initSpiel();
	%>
	<center>
		<h1>SPIEL</h1>
		<div class="panel">
			<div class="content">

				<table border="1">
					<tr>
						<td id="sr1"><a href="weiterleiten.jsp?id=1"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("red")) {
									out.print("<img src= 'bilder/Figur_rot.png'>");
								}
								}
							}
						%></a></td>

						<td><a href="spiel_starten.jsp?id=2"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("red")) {
									out.print("<img src= 'bilder/Figur_rot.png'>");
								}
								}
							}
						%></a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp?id=9">9</a></td>
						<td><a href="spiel_starten.jsp?id=10">10</a></td>
						<td><a href="spiel_starten.jsp">11</a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("blue")) {
									out.print("<img src= 'bilder/Figur_blau.png'>");
								}
								}
							}
						%></a></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("blue")) {
									out.print("<img src= 'bilder/Figur_blau.png'>");
								}
								}
							}
						%></a></td>
					</tr>
					<tr>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("red")) {
									out.print("<img src= 'bilder/Figur_rot.png'>");
								}
								}
							}
						%></a></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("red")) {
									out.print("<img src= 'bilder/Figur_rot.png'>");
								}
								}
							}
						%></a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp">8</a></td>
						<td><a href="spiel_starten.jsp">4</a></td>
						<td><a href="spiel_starten.jsp">12</a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("blue")) {
									out.print("<img src= 'bilder/Figur_blau.png'>");
								}
								}
							}
						%></a></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("blue")) {
									out.print("<img src= 'bilder/Figur_blau.png'>");
								}
								}
							}
						%></a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp">7</a></td>
						<td><a href="spiel_starten.jsp">3</a></td>
						<td><a href="spiel_starten.jsp">13</a></td>
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
						<td><a href="spiel_starten.jsp">6</a></td>
						<td><a href="spiel_starten.jsp">2</a></td>
						<td><a href="spiel_starten.jsp">14</a></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><a href="spiel_starten.jsp">1</a></td>
						<td><a href="spiel_starten.jsp">2</a></td>
						<td><a href="spiel_starten.jsp">3</a></td>
						<td><a href="spiel_starten.jsp">4</a></td>
						<td><a href="spiel_starten.jsp">5</a></td>
						<td><a href="spiel_starten.jsp">1</a></td>
						<td><a href="spiel_starten.jsp">15</a></td>
						<td><a href="spiel_starten.jsp">16</a></td>
						<td><a href="spiel_starten.jsp">17</a></td>
						<td><a href="spiel_starten.jsp">18</a></td>
						<td><a href="spiel_starten.jsp">19</a></td>
					</tr>
					<tr>
						<td><a href="spiel_starten.jsp">40</a></td>
						<td><a href="spiel_starten.jsp">4</a></td>
						<td><a href="spiel_starten.jsp">3</a></td>
						<td><a href="spiel_starten.jsp">2</a></td>
						<td><a href="spiel_starten.jsp">1</a></td>
						<td></td>
						<td><a href="spiel_starten.jsp">1</a></td>
						<td><a href="spiel_starten.jsp">2</a></td>
						<td><a href="spiel_starten.jsp">3</a></td>
						<td><a href="spiel_starten.jsp">4</a></td>
						<td><a href="spiel_starten.jsp">20</a></td>
					</tr>
					<tr>
						<td><a href="spiel_starten.jsp">39</a></td>
						<td><a href="spiel_starten.jsp">38</a></td>
						<td><a href="spiel_starten.jsp">37</a></td>
						<td><a href="spiel_starten.jsp">36</a></td>
						<td><a href="spiel_starten.jsp">35</a></td>
						<td><a href="spiel_starten.jsp">1</a></td>
						<td><a href="spiel_starten.jsp">25</a></td>
						<td><a href="spiel_starten.jsp">24</a></td>
						<td><a href="spiel_starten.jsp">23</a></td>
						<td><a href="spiel_starten.jsp">22</a></td>
						<td><a href="spiel_starten.jsp">21</a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp">34</a></td>
						<td><a href="spiel_starten.jsp">2</a></td>
						<td><a href="spiel_starten.jsp">26</a></td>
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
						<td><a href="spiel_starten.jsp">33</a></td>
						<td><a href="spiel_starten.jsp">3</a></td>
						<td><a href="spiel_starten.jsp">27</a></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("yellow")) {
									out.print("<img src= 'bilder/Figur_gelb.png'>");
								}
								}
							}
						%></a></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("yellow")) {
									out.print("<img src= 'bilder/Figur_gelb.png'>");
								}
								}
							}
						%></a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp">32</a></td>
						<td><a href="spiel_starten.jsp">4</a></td>
						<td><a href="spiel_starten.jsp">28</a></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("green")) {
									out.print("<img src= 'bilder/Figur_gruen.png'>");
								}
								}
							}
						%></a></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("green")) {
									out.print("<img src= 'bilder/Figur_gruen.png'>");
								}
								}
							}
						%></a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp">31</a></td>
						<td><a href="spiel_starten.jsp">30</a></td>
						<td><a href="spiel_starten.jsp">29</a></td>
						<td></td>
						<td></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("green")) {
									out.print("<img src= 'bilder/Figur_gruen.png'>");
								}
								}
							}
						%></a></td>
						<td><a href="spiel_starten.jsp"><%
							for (int i = 0; i < spiel.getSpieler().size(); i++) {
								if(spiel.getSpieler().get(i)!=null){
								if (spiel.getSpieler().get(i).getFarbe1().equals("green")) {
									out.print("<img src= 'bilder/Figur_gruen.png'>");
								}
								}
							}
						%></a></td>
					</tr>
				</table>
			</div>
			<p> 
			<button name="Speichern">Speichern</button>
		</div>
		<br />
		<textarea name="log" readonly="readonly"
			style="width: 30%; resize: none;" rows="6">Logging blabla</textarea>
	</center>
	<%@ include file="footer.jsp"%>