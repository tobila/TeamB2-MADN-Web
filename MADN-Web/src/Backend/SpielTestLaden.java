package Backend;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import Interfaces.iBediener;
import Interfaces.iDatenzugriff;

public class SpielTestLaden {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, JAXBException {
		iBediener s = new SpielBean ();
//		s.laden("Supertest2","csv");
		
//		iDatenzugriff speicherSer = new DatenzugriffSerialisiert();
//		s=(Spiel)speicherSer.laden("supertest5");
//		s.zugDurchfuehren(2);
		
		s.laden("CSVFinal", "csv");
	
		
		
		
		
		
	}

}
