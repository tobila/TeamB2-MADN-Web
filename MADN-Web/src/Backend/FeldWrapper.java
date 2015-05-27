package Backend;

import java.io.Serializable;

import Backend.Spieler.Spielfigur;
/**
 *Wrapper Klasse fuer das einfuegen von Start und Endfeldern des Spiels
 *
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class FeldWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spielfeld [] felder;
	private Spielfigur spielfigur;
	
	
	/**
	 *  Der oeffentliche Konstruktor mit Start und Endfeld erstellung.
	 * @param istStart gibt an, ob es ein Startfeld sein soll
	 * @param istEnde gibt an, ob es ein Endfeld sein soll
	 * @param farbe gibt die Farbe des Feldes an
	 */
	public FeldWrapper(boolean istStart, boolean istEnde,FarbEnum farbe) {
		if (istStart) {
			felder = new Spielfeld[5];
			felder[0] = new Spielfeld();
			for (int i = 1; i < felder.length; i++) {
				
				felder[i] = new Startfeld(farbe);
			}
		} else if (istEnde) {
			felder = new Spielfeld[5];
			felder[0] = new Spielfeld();
			for (int i = 1; i < felder.length; i++) {
				felder[i] = new Endfeld(farbe);
			}
		} else {
			felder = new Spielfeld[1];
			felder[0] = new Spielfeld();
		}
	}
	
	/**
	 * methode um auf Start und Endfelder zugreifen zu koennen
	 * @return gibt die Inhalte der Start/Endfelder zurueck
	 */
	
	public Spielfeld[] getFelder(){
		return felder;
	}
	
	@Override
	public String toString(){
		String s="";
		for(Spielfeld x:felder){
			s+=x.toString()+"\n\t";
			
		}
		return s;
	}
}
