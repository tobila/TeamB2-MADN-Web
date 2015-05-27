package Backend;

import java.io.IOException;

import Interfaces.iBediener;

public class SpielTestSpeichern {

	private DatenzugriffSerialisiert speichern;
	
	public static void main(String[] args) throws IOException {
		
		iBediener s = new SpielBean ();

		s.SpielerHinzufuegen("Rosa", "red",null);
		
		s.SpielerHinzufuegen("Helmut", "blue",null);
		s.SpielerHinzufuegen("Reiner", "Green",null);
		s.SpielerHinzufuegen("Ole", "Yellow",null);
		s.initSpiel();
	
		s.zugDurchfuehren(1);
		s.zugDurchfuehren(1);
		s.Speichern("CSVFinal", "csv");
//		DatenzugriffSerialisiert speichernSer= new DatenzugriffSerialisiert((Spiel) s);
//		s.Speichern("supertest5", "ser");
//		s.Speichern("Supertest2", "csv");
//		s.Speichern("supertest4", "ser", s);

		
		
		

	}

}
