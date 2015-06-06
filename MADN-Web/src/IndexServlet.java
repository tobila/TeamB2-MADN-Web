

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Backend.SpielBean;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SpielBean spiel;
	private String name;
	private String farbe;
	private String anzSpieler;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
            }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(true);
		name= request.getParameter("name");
		farbe = request.getParameter("farbe");
		anzSpieler = request.getParameter("anzSpieler");
		
		if(name==null){
			response.sendRedirect("index.jsp");
		}else{
			
			spiel = (SpielBean) sess.getServletContext().getAttribute("spiel");
			if(spiel==null){
				spiel = new SpielBean();
				getServletContext().setAttribute("spiel", spiel);
			}
			
			if(spiel.getSpieler().size()==0){
				sess.setAttribute("anzSpieler",anzSpieler);
			}else{
				if(name.length()==0 || name.length()<2){
					sess.setAttribute("loginFehler", "Kein zulaessiger Benutzername. Ein Benutzername muss aus mindestens 2 Buchstaben oder Zeichen bestehen.");
					response.sendRedirect("index.jsp");
				}else{
					request.getSession(true).setAttribute("name", name);
				}
			}
		}
		
		//anzSpieler = (String) request.getAttribute("anzSpieler");
		int sp = Integer.parseInt(anzSpieler);
		
		if(sess.getAttribute("aktu").equals("1")){
			spiel.SpielerHinzufuegen(name, farbe, null);
		}
		
		sess.setAttribute("aktu", "2");
		if(sp == spiel.getSpieler().size()){
			response.sendRedirect("spiel.jsp");
		}
		out.println("<br/>Warte auf andere Spieler.. <a href='spiel_starten.jsp'>aktualisieren</a>");
		out.println("<br/>Aktuelle anzahl Spieler: "+ spiel.getSpieler().size());
		
		
	


	}

}
