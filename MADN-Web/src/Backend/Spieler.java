package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

/**
 * Klasse fuer die Verwaltung eines Spieler
 * 
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class Spieler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Spielfigur[] spielfigur;

	private FarbEnum farbe;
	private String name;
	private Wuerfel wuerfel;
	private KI ki;
	private KIEnum kienum;

	/**
	 * Konstruktor mit Erstellung der Spielfiguren
	 * 
	 * @param name des Spielers
	 * @param farbe gewaehlte Farbe der Spielfigur
	 * @param brett das Spielbrett
	 * @param regel die Regeln fuer das Spiel
	 */
	public Spieler(String name, FarbEnum farbe, KIEnum ki, SpielBean spiel) {
		setFarbe(farbe);
		setName(name);
		wuerfel = new Wuerfel();

		if (ki != null) {
			if (ki.equals(KIEnum.AGGRESSIV)) {
				this.ki = new KI_Aggresiv(this, spiel);
			} else if (ki.equals(KIEnum.DEFENSIV)) {
				this.ki = new KI_Defensiv(this, spiel);
			}
		}
		this.kienum = ki;

		this.spielfigur = new Spielfigur[4];
		for (int i = 0; i < 4; i++) {
			spielfigur[i] = new Spielfigur(i + 1, getFarbe());
		}

	}
//	public Spieler (BufferedReader reader) throws IOException{
//		try{
//		reader.readLine();
//		String line = reader.readLine();
//		String [] fields = line.split("_");
//		setName(fields[0]);
//			}
//		
//		catch (NullPointerException e){
//			throw new IOException("Unerwartetes Dateiende");
//		}
//		catch (NumberFormatException e){
//			throw new IOException("Falsches Elementformat");
//		}
//		catch (IndexOutOfBoundsException e){
//			throw new IOException("zu wenig Datenelemente");
//		}
//	}
	public KIEnum getKienum() {
		return kienum;
	}

	/**
	 * gibt die Zufallszahl des Wuerfels zurueck
	 * 
	 * @return gewuerfelte Zahl
	 */
	public Wuerfel getWuerfel() {
		return wuerfel;
	}

	/**
	 * gibt die Farbe des farbEnums wieder
	 * 
	 * @return farbe des Enums
	 */

	public FarbEnum getFarbe() {
		return farbe;
	}
	
	public String getFarbe1(){
		switch(farbe){
		case BLUE:
			return "blue";
		case GREEN:
			return "green";
		case RED:
			return "red";
		case YELLOW:
			return "yellow";
		default:
			break;
			
		}
		return null;
	}

	/**
	 * gibt des Namen des Spielers zurueck
	 * 
	 * @return name name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * setzt die gewuehlte Farbe des Spielers
	 * 
	 * @param farbe gewaehlte farbe des Spielers
	 */
	private void setFarbe(FarbEnum farbe) {
		this.farbe = farbe;
	}

	/**
	 * setzt den Namen des Spielers
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gibt die Spielfigur mit gewuenschter ID zurueck
	 * 
	 * @param i
	 * @return Spielfigur mit angegebener ID
	 */
	public Spielfigur getSpielfigur(int i) {
		i = i - 1;
		if (i < 0) {
			i = 0;
		}
		return spielfigur[i];

	}

	
	public Spielfigur getSpielfigurNeu(int i) {
		return spielfigur[i];

	}
	
	/**
	 * gibt das Array der SPielfigur zurueck
	 * 
	 * @return spielfigur
	 */
	public Spielfigur[] getSpielfiguren() {
		return spielfigur;
	}

	public KI getKi() {
		return ki;
	}

	@Override
	public String toString() {
		if(getKienum() == null)
			return "Spieler_" + getName() + "_" + getFarbe();
		return "Spieler_" + getName() + "_" + getFarbe() + "_KI-"+ getKienum();
	}

	/**
	 * Innere Klasse Spielfigur
	 * 
	 * @author Judy, Michi,Tobi,Doerte
	 *
	 */

	public class Spielfigur implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int ID;
		private Spielfeld spielfeld;
		private FarbEnum farbe;
		private boolean hatUmrundet;

		/**
		 * Kontruktor der Inneren Klasse kann nur ueber die Spielerklasse
		 * aufgerufen werden
		 * 
		 * @param ID uebergibt jeder erstellte Spielfigur eine ID
		 */

		private Spielfigur(int ID, FarbEnum farbe) {
			this.ID = ID;
			this.spielfeld = null;
			this.farbe = farbe;
			this.setHatUmrundet(false);
		}

		/**
		 * Gibt die Farbe der Spielfigur zurueck
		 * 
		 * @return farbe
		 */
		public FarbEnum getFarbe() {
			return farbe;
		}

		public void setFarbe(FarbEnum farbe) {
			this.farbe = farbe;
		}

		/**
		 * gibt die ID der Spielfigur zurueck
		 * 
		 * @return ID der Spielfigur
		 */
		public int getID() {
			return ID;
		}

		/**
		 * gibt das Spielfeld zurück
		 * 
		 * @return Spielfeld
		 */
		public Spielfeld getSpielfeld() {
			return spielfeld;
		}

		/**
		 * setzt das Spielfeld
		 * 
		 * @param spielfeld
		 */
		public void setSpielfeld(Spielfeld spielfeld) {
			if (spielfeld != null) {
				this.spielfeld = spielfeld;
			}
		}

		public boolean istAufStartfeld() {
			if (this.getSpielfeld().getID().contains("S")) {
				return true;
			}
			return false;
		}

		public boolean hatUmrundet() {
			return hatUmrundet;
		}

		public void setHatUmrundet(boolean hatUmrundet) {
			this.hatUmrundet = hatUmrundet;
		}

		@Override
		public String toString() {
			return "Spielfigur" + "" + getID() + "_" + getName() + "_" + getFarbe();
		}

	}

}
