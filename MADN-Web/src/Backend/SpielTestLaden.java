package Backend;

import Interfaces.iBediener;
import Interfaces.iDatenzugriff;

public class SpielTestLaden {

	public static void main(String[] args) {
		iBediener s = new SpielBean ();
//		s.laden("Supertest2","csv");
		
//		iDatenzugriff speicherSer = new DatenzugriffSerialisiert();
//		s=(Spiel)speicherSer.laden("supertest5");
//		s.zugDurchfuehren(2);
		
		s.laden("CSVFinal", "csv");
	
		
		
		
		
		
	}

}
