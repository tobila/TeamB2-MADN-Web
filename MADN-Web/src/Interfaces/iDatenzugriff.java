package Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import Backend.SpielBean;

import com.itextpdf.text.DocumentException;




public interface iDatenzugriff {

	
	void speichern(String dateiname, String dateiende, Object o) throws IOException;
	
	Object laden(String dateiname);

	 void spielfeld(SpielBean spiel) throws FileNotFoundException, DocumentException;
	
	

}
