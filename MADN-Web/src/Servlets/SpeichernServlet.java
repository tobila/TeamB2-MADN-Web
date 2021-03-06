package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import com.itextpdf.text.DocumentException;

import Backend.DatenzugriffCSV;
import Backend.DatenzugriffPDF;
import Backend.DatenzugriffSerialisiert;
import Backend.DatenzugriffXML;
import Backend.SpielBean;
import Interfaces.iDatenzugriff;
import Interfaces.iBediener;

/**
 * Servlet implementation class SpeichernServlet
 */
@WebServlet("/SpeichernServlet")
public class SpeichernServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpeichernServlet() {
        super();
       
    }

	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String dateiname = request.getParameter("Dateiname");
		String dateiformat = request.getParameter("auswahl");
		
		if(dateiname != null && !dateiname.isEmpty()){
			if(dateiname.contains(".")){
				dateiname = dateiname.substring(0,dateiname.indexOf("."));
			}
			iBediener spiel = (iBediener) request.getServletContext().getAttribute("spiel");
			if(spiel != null){
				iDatenzugriff id = null;
				String pfad =  request.getServletContext().getRealPath("gespeicherteDateien/") + "/";
				if(dateiformat.equals("pdf")){
					id = new DatenzugriffPDF(); 
					dateiname += ".pdf";
					try {
						id.spielfeld((SpielBean) spiel);
					} catch (DocumentException e) {
						e.printStackTrace();
					}
					request.getSession().setAttribute("dateiname",  pfad + dateiname);
					response.sendRedirect("SpeichernLaden_HTML/pdf.jsp");
					return;
				} else if(dateiformat.equals("csv")){
					id = new DatenzugriffCSV(); 
					dateiname += ".csv";
					
				} else if(dateiformat.equals("ser")){
					id = new DatenzugriffSerialisiert(); 
					dateiname += ".ser";	
					try {
						id.speichern("Alfred", ".ser", spiel);
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}} 
//					else if(dateiformat.equals("xml")){
//					id = new DatenzugriffXML(); 
//					dateiname += ".xml";
//				}
				
				try {
					id.speichern(dateiname,dateiformat,spiel);
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("dateiname",  pfad + dateiname);
				response.sendRedirect("SpeichernLaden_HTML/spielGespeichert.jsp");
		
				}
			}
		}
}
