package Backend;

import java.io.Serializable;

import Backend.Spieler.Spielfigur;

public abstract class KI implements Serializable {
	
	
	

	private boolean gezogen= false;
	private static final long serialVersionUID = 1L;
	private Spieler spieler;
	private SpielBean spiel;

	/**
	 * Konstruktor der KI
	 * 
	 * @param spieler
	 * @param spiel
	 */

	public KI(Spieler spieler, SpielBean spiel) {
		this.spieler = spieler;
		this.spiel = spiel;

	}

	/**
	 * Ermittelt die Spielfigur, welche vom Startfeld auf das Erste Spielfeld
	 * gesetzt werden kann
	 * 
	 * @return Spielfigur
	 */

	public Spielfigur KIVersucheRauskommen() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigurNeu(i);
			if (s.getSpielfeld().getID().contains("S") && spieler.getWuerfel().getErgebnis() == 6) {
				
				if(spieler.getFarbe().equals(FarbEnum.RED) && spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}
				if(spieler.getFarbe().equals(FarbEnum.BLUE) && spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}
				if(spieler.getFarbe().equals(FarbEnum.GREEN) && spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}
				if(spieler.getFarbe().equals(FarbEnum.YELLOW) && spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur() != null){
					if(spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur().getFarbe())){
						KIVersucheFigurZiehen();
						return null;
					}
				}

				return s;
			}
		}
		return null;
	}

	/**
	 * Ermittelt die Spielfigur, welche ins Endfeld laufen kann
	 * 
	 * @return Spielfigur
	 */
	public Spielfigur KIVersucheInsEndfeld() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigurNeu(i);

//			int oldPos = spiel.getBrett().getSpielbrett()[s.getSpielfeld().getPosition()].getFelder()[0].getSpielfigur().getSpielfeld().getPosition();
			int oldPos = s.getSpielfeld().getPosition();
			int newPos = oldPos + spieler.getWuerfel().getErgebnis();

			switch (spieler.getFarbe()) {
			case RED:

				if (newPos >= 39) {
					return s;
				}
				break;
			case BLUE:
				if (newPos >= 9) {
					return s;
				}
				break;
			case GREEN:
				if (newPos >= 19) {
					return s;
				}
				break;
			case YELLOW:
				if (newPos >= 29) {
					return s;
				}
				break;
			}
		}
		return null;

	}

	/**
	 * Ermittelt die Spielfigur, welche eine andere Figur schmeissen kann
	 * 
	 * @return Spielfigur
	 */
	public Spielfigur KIVersucheSchmeissen() {
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigurNeu(i);
			int newPos = (s.getSpielfeld().getPosition() + spieler.getWuerfel().getErgebnis())-1;
			
			if(newPos < 40){
				Spielfigur s2 = spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur();
				if (s2 != null && !(s2.getFarbe().equals(s.getFarbe()))) {
					return s;
				}
			}
		}
		return null;
	}

	/**
	 * Ermittelt die Spielfigur, welche einen Zug ausführen kann
	 * 
	 * @return Spielfigur
	 */
	public Spielfigur KIVersucheFigurZiehen() {

		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {

			Spielfigur s = spieler.getSpielfigurNeu(i);
			int newPos = (s.getSpielfeld().getPosition() + spieler.getWuerfel().getErgebnis());
			if(newPos < 40){
//				if (!(s.getSpielfeld().getID().contains("S")) && spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur() == null) {
//					return s;
//				} else{
//					KIVersucheRauskommen();
//				}
				if (s.getSpielfeld().getPosition() != 0 && spiel.getBrett().getSpielbrett()[newPos-1].getFelder()[0].getSpielfigur() == null) {
					return s;
				} 
			}
		}
		return null;

	}
	
	public Spielfigur KIVersucheImEndfeldLaufen(){
		for (int k = 0; k < spieler.getSpielfiguren().length; k++) {
			Spielfigur s = spieler.getSpielfigurNeu(k);

			if(s.getSpielfeld().getID().contains("E")){
				int posEndfeld=Integer.parseInt(s.getSpielfeld().getID().substring(1));
				int erg = spieler.getWuerfel().getErgebnis();
				if(posEndfeld+erg < 5){
					switch (spieler.getFarbe()) {
					case RED:
						for(int i=erg-1; i>0; i--){
							if(spiel.getBrett().getSpielbrett()[39].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//								System.err.println("kein ueberspringen"+(posEndfeld+erg-i));
								return null;
							}
						}
						if(spiel.getBrett().getSpielbrett()[39].getFelder()[posEndfeld+erg].getSpielfigur() != null){
							return null;
						}
						return s;
					case BLUE:
						for(int i=erg-1; i>0; i--){
							if(spiel.getBrett().getSpielbrett()[9].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//								System.err.println("kein ueberspringen"+(posEndfeld+erg-i));
								return null;
							}
						}
						if(spiel.getBrett().getSpielbrett()[9].getFelder()[posEndfeld+erg].getSpielfigur() != null){
							return null;
						}
						return s;
					case GREEN:
						for(int i=erg-1; i>0; i--){
							if(spiel.getBrett().getSpielbrett()[19].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//								System.err.println("kein ueberspringen"+(posEndfeld+erg-i));
								return null;
							}
						}
						if(spiel.getBrett().getSpielbrett()[19].getFelder()[posEndfeld+erg].getSpielfigur() != null){
							return null;
						}
						return s;
					case YELLOW:
						for(int i=erg-1; i>0; i--){
							if(spiel.getBrett().getSpielbrett()[29].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//								System.err.println("kein ueberspringen"+(posEndfeld+erg-i));
								return null;
							}
						}
						if(spiel.getBrett().getSpielbrett()[29].getFelder()[posEndfeld+erg].getSpielfigur() != null){
							return null;
						}
						return s;
					}
				}
			}
		}
		return null;
	}
	
	public Spielfigur KIVersucheZiehenStartpos(){
		for (int i = 0; i < spieler.getSpielfiguren().length; i++) {
			Spielfigur s = spieler.getSpielfigurNeu(i);
			switch (spieler.getFarbe()) {
			case RED:
				if(s.getSpielfeld().getPosition() == 1){
					return s;
				}
				break;
			case BLUE:
				if(s.getSpielfeld().getPosition() == 11){
					return s;
				}
				break;
			case GREEN:
				if(s.getSpielfeld().getPosition() == 21){
					return s;
				}
				break;
			case YELLOW:
				if(s.getSpielfeld().getPosition() == 31){
					return s;
				}
				break;
			}
		}
		return null;
	}
	

	/**
	 * getter für den Spieler
	 * 
	 * @return spieler
	 */
	public Spieler getSpieler() {
		return spieler;
	}

	/**
	 * getter für das Spiel
	 * 
	 * @return spiel
	 */
	public SpielBean getSpiel() {
		return spiel;
	}

	
	public boolean getGezogenButton() {
		return gezogen;
	}

	public void setGezogenButton(boolean gezogen) {
		this.gezogen = gezogen;
	}
	public abstract void kiZug();


}
