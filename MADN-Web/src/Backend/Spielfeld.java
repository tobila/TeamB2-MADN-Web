package Backend;

import java.io.Serializable;

import Backend.Spieler.Spielfigur;

/**
 * Klasse zur Verwaltung der Spielfelder
 * 
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class Spielfeld implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter = 0;
	private String id;
	private Spielfigur spielfigur;
	private FarbEnum farbe = null;
	private int position = 0;

	/**
	 * Default Kontruktor setzt die ID auf das Spielfeld
	 */
	public Spielfeld() {
		counter++;
		setID("",
				counter - Startfeld.getCounterStart()
						- Endfeld.getCounterEnde());
	}

	/**
	 * 
	 * @param prefix
	 * @param id
	 */
	public void setID(String prefix, int id) {
		this.id = prefix + id;
	}

	/**
	 * setzt die Farbe fuer das passende Spielfeld
	 * 
	 * @param farbe
	 */
	public void setFarbe(FarbEnum farbe) {
		this.farbe = farbe;
	}

	/**
	 * gibt die Farbe des Enums zurück
	 * 
	 * @return farbe
	 */
	public FarbEnum getFarbe() {
		return farbe;
	}

	/**
	 * gibt die ID des Spielfeldes zurueck
	 * 
	 * @return ID des Spielfeldes
	 */
	public String getID() {
		return id;
	}

	/**
	 * gibt die Position des Spielfeldes zurueck
	 * 
	 * @return position
	 */
	public int getPosition() {
		if(id.contains("S") || id.contains("E")){
			return 0;
		}
		this.position = Integer.parseInt(id);
		return position;
	}

	public void setPosition(int position){
		this.position = position;
	}
	
	/**
	 * setzt die Spielfigur
	 * 
	 * @param spielfigur
	 */
	public void setSpielfigur(Spielfigur spielfigur) {
		this.spielfigur = spielfigur;
	}

	/**
	 * gibt die Spielfigur zurueck
	 * 
	 * @return spielfigur
	 */
	public Spielfigur getSpielfigur() {
		return spielfigur;
	}

	@Override
	public String toString() {
		if (spielfigur == null)
			return this.getID() + "_" + this.getFarbe() + "_null" +"\n";
		else
			return this.getID() + "_" + this.getFarbe() + "_"
					+ spielfigur.toString()+ "\n";
	}
}
