package Backend;

import Interfaces.iBediener;

/**
 * Klasse zum Spielstart
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class SpielTest {



	/**
	 * Main Methode 
	 * @param args
	 */
	public static void main(String[] args) {
		
		iBediener s = new SpielBean ();
//		s.SpielerHinzufuegen("Ki", "red", "aggressiv");
//		s.SpielerHinzufuegen("Ki2", "Blue", "defensiv");
//		s.SpielerHinzufuegen("Rosa", "red",null);
//		s.SpielerHinzufuegen("Helmut", "blue",null);
		s.SpielerHinzufuegen("Reiner", "Green",null);
//		s.SpielerHinzufuegen("Ole", "Yellow",null);
		s.initSpiel();
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehren(1);
//		s.zugDurchfuehrenSchmeissenTest(1);
//		s.zugDurchfuehrenEndfeldTest(1);
		
		
		
//		s.initTestSpiel();
		
//		s.initTestSpielZugDefensiv();
//		s.initTestSpielZugAggressiv();

		//s.Speichern("csv");
		
		
	}

}
