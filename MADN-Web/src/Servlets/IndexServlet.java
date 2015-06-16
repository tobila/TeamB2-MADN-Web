package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apple.eawt.Application;

import Backend.SpielBean;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String farbe;
	private static int z;
	private static boolean ki;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
            }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession sess = request.getSession(true);
		
		name= (request.getParameter("name") != null ? request.getParameter("name") : "");
		farbe = (request.getParameter("farbe") != null ? request.getParameter("farbe") : "");

				
		
		
		
		
		
		
		
		SpielBean spiel = (SpielBean) sess.getServletContext().getAttribute("spiel");
			
			if(spiel==null){
				this.getServletContext().setAttribute("spiel", new SpielBean());
				getServletContext().setAttribute("spiel", spiel);
			}
				
			
		
			
					request.getSession(true).setAttribute("name", name);
					request.getSession(true).setAttribute("farbe", farbe);
		
					
	
	
		
		
		if(sess.getAttribute("aktu").equals("1")){
			String lFarbe = farbe;
			String lName = name;
		
	
		
			
			if(spiel.getGewaehlteKis()==0){
				spiel.SpielerHinzufuegen(lName, lFarbe, null);
				
			}if (spiel.getGewaehlteSpieler() != 0 && ki==true) {
				System.out.println("spieler 0, ki true");
					spiel.SpielerHinzufuegen(name, farbe, null);
				}
			
			if(spiel.getGewaehlteKis()!=0 && spiel.getGewaehlteSpieler()==0 && ki==false){
				ki=true;
				System.out.println("spieler 0");
				switch(spiel.getGewaehlteKis()){
				case 1:spiel.SpielerHinzufuegen("ki1", "red", "DEFENSIV");
				break;
				
				case 2:
					spiel.SpielerHinzufuegen("ki1", "red", "AGGRESSIV");
					spiel.SpielerHinzufuegen("ki1", "blue", "AGGRESSIV");
					System.out.println("case2ki");
					break;
					
				case 3:
					spiel.SpielerHinzufuegen("ki1", "red", "AGGRESSIV");
					spiel.SpielerHinzufuegen("ki1", "blue", "AGGRESSIV");
					spiel.SpielerHinzufuegen("ki1", "green", "AGGRESSIV");
					System.out.println("spieler 3");
					break;
				case 4:
					spiel.SpielerHinzufuegen("ki1", "red", "AGGRESSIV");
					spiel.SpielerHinzufuegen("ki1", "blue", "AGGRESSIV");
					spiel.SpielerHinzufuegen("ki1", "green", "AGGRESSIV");
					spiel.SpielerHinzufuegen("ki1", "yellow", "AGGRESSIV");
					break;
				}
			}
			
		}if(spiel.getGewaehlteKis()!=0 && spiel.getGewaehlteSpieler()!=0 && ki==false) {
			System.out.println("sspieler 1 und ki");
			spiel.SpielerHinzufuegen(name, farbe, null);
				boolean red= false;
				boolean blue= false;
				boolean yellow= false;
				boolean green= false;
				ki= true;
				
				switch (spiel.getGewaehlteKis()) {
				
				case 1:
					
					
					if (spiel.getSpieler() != null) {

						for (int i = 0; i < spiel.getSpieler().size(); i++) {
							if (spiel.getSpieler().get(i).getFarbe1()
									.equals("red")) {
								System.out.println("redtrue");
								red = true;
							}
							if (spiel.getSpieler().get(i).getFarbe1()
									.equals("blue")) {
								blue = true;
							}
							if (spiel.getSpieler().get(i).getFarbe1()
									.equals("green")) {
								green = true;
							}
							if (spiel.getSpieler().get(i).getFarbe1()
									.equals("yellow")) {
								yellow = true;
							}
						}
					}
					if (red == false && z==0) {
						spiel.SpielerHinzufuegen("ki1", "red", "AGGRESSIV");
						System.out.println("kired");
						z++;
					}
					if (blue == false&& z==0) {
						spiel.SpielerHinzufuegen("ki1", "blue", "AGGRESSIV");
						z++;
					}
					if (green == false&& z==0) {
						spiel.SpielerHinzufuegen("ki1", "green", "AGGRESSIV");
						z++;
					}
					if (yellow == false && z==0) {
						spiel.SpielerHinzufuegen("ki1", "yellow", "AGGRESSIV");
						z++;
					}
					
					
				break;
				
				case 2: 
				
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).getFarbe1().equals("red")){
			
							red=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("yellow")){
							yellow=true;
						}
					}
						if(red==false&& z<2){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							z++;
						}if(blue==false&&z<2){
							System.out.println("kiblue");
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
							z++;
						}if(green==false&&z<2){
							System.out.println("green");
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							z++;
						} if(yellow==false&&z<2){
							System.out.println("yellow");
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							z++;
						}
					
				break;
				case 3:
					System.out.println("case3");
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).getFarbe1().equals("red")){
							red=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("yellow")){
							yellow=true;
						}
						if(red==false&&z<3){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							System.out.println("casered");
							z++;
						}if(blue==false&&z<3){
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
							System.out.println("caseblue");
							z++;
						}if(green==false&&z<3){
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							System.out.println("casegreen");
							z++;
						}if(yellow==false&&z<3){
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							System.out.println("caseyellow");
							z++;
						}
					}
				case 4:
					
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).getFarbe1().equals("red")){
							red=true;
							
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).getFarbe1().equals("yellow")){
							yellow=true;
						}
						if(red==false&&z<4){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							z++;
						}else if(blue==false&&z<4){
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
							z++;
						}else if(green==false&&z<4){
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							z++;
						}else if(yellow==false&&z<4){
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							z++;
						}
					}
					break;
				
				}
				
				
			}
		
		
		if(sess.getAttribute("aktu").equals("1")){
			ServletContext sc = this.getServletContext();
			for(int i=1; i<=4; i++){
				if(sc.getAttribute("s"+i) == null){
					sc.setAttribute("s"+i, sess.getId());
					sc.setAttribute("farbeS"+i, farbe);
					break;
				}
			}
			
			System.out.println(sess.getId()); 
		}
		sess.setAttribute("aktu", "2");
		
			
		
		int sp= spiel.getGewaehlteKis()+spiel.getGewaehlteSpieler(); 
		if(sp == spiel.getSpieler().size()){
			response.sendRedirect("spiel.jsp");
		}
		
		//System.out.println(spiel.getSpieler().size());
		int spielerAnzahl=spiel.getGewaehlteKis()+spiel.getGewaehlteSpieler();
	     String uri = request.getRequestURI();
	     if (request.getQueryString() != null)
	         uri += "?" + request.getQueryString();
		
		out.println("<html><head></head><body><div>");
		out.println("Warte auf andere Spieler.. <a href='" + uri + "'> aktualisieren </a>");
		out.println("<br/>Aktuelle anzahl Spieler: "+ spiel.getSpieler().size());
		out.println("<br/>SpielerAnzahl: "+ spielerAnzahl);
		out.println("</div></body></html>");
		out.close();
		
		
	


	}

}