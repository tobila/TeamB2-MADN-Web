package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apple.eawt.Application;

import Backend.SpielBean;

/**
 * Servlet implementation class SpielServlet
 */
@WebServlet("/SpielServlet")
public class SpielServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SpielServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession sess = request.getSession(true);
		
//		SpielBean spiel= (SpielBean) sess.getAttribute("spiel");
		SpielBean spiel = (SpielBean) sess.getServletContext().getAttribute("spiel");
		if(spiel==null){
			this.getServletContext().setAttribute("spiel", new SpielBean());
			getServletContext().setAttribute("spiel", spiel);
		}
		
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			spiel.zugDurchfuehren(id);
		}catch(Exception e){
			spiel.setNaechster(spiel.getAmZug());
		}
//		System.out.println(spiel);
		
		response.sendRedirect("spiel.jsp");
		
	}

}
