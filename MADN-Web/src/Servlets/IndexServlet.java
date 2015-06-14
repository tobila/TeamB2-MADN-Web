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
	private String anzSpieler;
	private String anzKi;
       
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
		anzSpieler = (request.getParameter("anzSpieler") != null ? request.getParameter("anzSpieler") : "0");
		anzKi= (request.getParameter("anzKi") != null ? request.getParameter("anzKi") : "0");

		
		int anzKis= Integer.parseInt(anzKi);
		SpielBean spiel = (SpielBean) sess.getServletContext().getAttribute("spiel");
		
		
		if(name==null){
			response.sendRedirect("index.jsp");
		}else{
			
			if(spiel==null){
				this.getServletContext().setAttribute("spiel", new SpielBean());
				getServletContext().setAttribute("spiel", spiel);
			}
				
			
			
			if(spiel.getSpieler().size()==0){
//				sess.setAttribute("anzSpieler", anzSpieler);
				getServletContext().setAttribute("anzSpieler", anzSpieler);
			}else{
				if(name.length()==0 || name.length()<2){
					sess.setAttribute("loginFehler", "Kein zulaessiger Benutzername. Ein Benutzername muss aus mindestens 2 Buchstaben oder Zeichen bestehen.");
					response.sendRedirect("index.jsp");
				}else{
					request.getSession(true).setAttribute("name", name);
				}
			}
		}
		
		
	
		String anzSp = getServletContext().getAttribute("anzSpieler").toString();
		int sp = Integer.parseInt(anzSp);
		
		if(sess.getAttribute("aktu").equals("1")){
			String lFarbe = farbe;
			String lName = name;
			
			if(anzKi.equals("0")){
				spiel.SpielerHinzufuegen(lName, lFarbe, null);
			} 
			
			if(anzKis+sp>4){
				sess.setAttribute("loginFehler", "Das Spiel kann nur aus insgesammt 4 Mitspielern bestehen.");
				
				response.sendRedirect("index.jsp");
				
			}else if(anzKis!=0) {
				boolean red= false;
				boolean blue= false;
				boolean yellow= false;
				boolean green= false;
				int z=0;
				
				switch(anzKis) {
				case 1:
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).equals("red")){
							
							red=true;
						}
						if(spiel.getSpieler().get(i).equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).equals("yellow")){
							yellow=true;
						}
					}
						if(red==false && z<2){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							
							z++;
							
						}if(blue==false&& z<2){
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
						
							z++;
							
						}if(green==false&& z<2){
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							
							z++;
							
						}if(yellow==false&& z<2){
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							
							z++;
							
						}
					
					
				break;
				case 2: 
					 z=0;
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).equals("red")){
							red=true;
						}
						if(spiel.getSpieler().get(i).equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).equals("yellow")){
							yellow=true;
						}
					}
						if(red==false&z<=2){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							z++;
						}if(blue==false& z<=2){
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
							z++;
						}if(green==false& z<=2){
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							z++;
						} if(yellow==false & z<=2){
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							z++;
						}
					
				break;
				case 3:
					 z=0;
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).equals("red")){
							red=true;
						}
						if(spiel.getSpieler().get(i).equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).equals("yellow")){
							yellow=true;
						}
						if(red==false&&z<=3){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							z++;
						}else if(blue==false&& z<=3){
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
							z++;
						}else if(green==false&& z<=3){
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							z++;
						}else if(yellow==false&&z<=3){
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							z++;
						}
					}
				case 4:
					z=0;
					for(int i=0; i<spiel.getSpieler().size();i++){
						if(spiel.getSpieler().get(i).equals("red")){
							red=true;
							
						}
						if(spiel.getSpieler().get(i).equals("blue")){
							blue=true;
						}
						if(spiel.getSpieler().get(i).equals("green")){
							green=true;
						}
						if(spiel.getSpieler().get(i).equals("yellow")){
							yellow=true;
						}
						if(red==false&&z<=4){
							spiel.SpielerHinzufuegen( "ki1","red", "AGGRESSIV");
							z++;
						}else if(blue==false&& z<=4){
							spiel.SpielerHinzufuegen( "ki1","blue", "AGGRESSIV");
							z++;
						}else if(green==false&& z<=4){
							spiel.SpielerHinzufuegen( "ki1","green", "AGGRESSIV");
							z++;
						}else if(yellow==false&&z<=4){
							spiel.SpielerHinzufuegen( "ki1","yellow", "AGGRESSIV");
							z++;
						}
					}
					break;
				
				}
				
				
			}
			
			/* if (!anzSpieler.equals("0") && anzKis!=0){
			spiel.SpielerHinzufuegen(name, farbe, null);
			} */
			
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
		
			
		
		if(sp == spiel.getSpieler().size()){
			response.sendRedirect("spiel.jsp");
		}
		
		//System.out.println(spiel.getSpieler().size());
		
	     String uri = request.getRequestURI();
	     if (request.getQueryString() != null)
	         uri += "?" + request.getQueryString();
		
		out.println("<html><head></head><body><div>");
		out.println("Warte auf andere Spieler.. <a href='" + uri + "'> aktualisieren </a>");
		out.println("<br/>Aktuelle anzahl Spieler: "+ spiel.getSpieler().size());
		out.println("</div></body></html>");
		out.close();
		
		
	


	}

}