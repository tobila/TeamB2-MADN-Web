package Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import Backend.SpielBean;


import com.itextpdf.text.DocumentException;




public interface iDatenzugriff {

	
	void speichern(String dateiname, String dateiende, Object o) throws IOException, JAXBException;
	
	Object laden(String dateiname) throws ClassNotFoundException, FileNotFoundException, IOException, JAXBException;

	 void spielfeld(SpielBean spiel) throws FileNotFoundException, DocumentException;
	
	

}
