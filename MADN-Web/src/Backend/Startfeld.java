package Backend;

import java.io.Serializable;

import Backend.Spieler.Spielfigur;

/**
 * Klasse fuer die Startfelder
 * erbt von der Oberklsse Spielfeld
 * @author Judith, Michi,Tobi,Doerte
 *
 */


public class Startfeld extends Spielfeld implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counterStart = 0;
	
	/**
	 * Der oeffentliche Konstruktor 
	 * @param farbe gibt die Farbe des Spielfeldes an
	 */
	public Startfeld (FarbEnum farbe){
		super();
		super.setFarbe(farbe);
		super.setID("S",(counterStart%4)+1);
		counterStart++;
		
	}
	
	public static int getCounterStart (){
		return counterStart;
	}

}
