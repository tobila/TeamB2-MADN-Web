package Backend;

import java.io.Serializable;

import Backend.Spieler.Spielfigur;

/**
 * Klasse zur Verwaltung der Spielregeln
 * 
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class Regelwerk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpielBean spiel;
	private boolean gewonnen;

	/**
	 * Konstruktor des Regelwekes, bekommt das Spiel uebergeben
	 * 
	 * @param spiel
	 */

	public Regelwerk(SpielBean spiel) {
		this.spiel = spiel;
	}

	/**
	 * Methode, um eine Spielfigur vom Startfeld auf ihr erstes Spielfeld zu
	 * setzten
	 * 
	 * @param spieler
	 * @param spielfigur
	 */

	public void aktionsWahl(Spieler spieler, Spielfigur spielfigur, int ergebnis) {
//		if (spielfigur.getSpielfeld().getID().contains("S") && ergebnis==6){
		if (spielfigur.getSpielfeld().getID().contains("S")){
			rauskommen(spieler, spielfigur);
		}else if(spielfigur.getSpielfeld().getID().contains("E")){
			imEndfeldLaufen(spieler,spielfigur,ergebnis);
		} else 
			figurZiehen(spieler, spielfigur);

	}

	public void rauskommen(Spieler spieler, Spielfigur spielfigur) {

		if (spieler.getFarbe().equals(FarbEnum.RED)) {
			// if (spieler.getWuerfel().getErgebnis() == 6) {
			if (spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur() == null) {
				spiel.getBrett().getSpielbrett()[0].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[0].getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			} else if (spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur() != null) {
				if (spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur().getFarbe())) {
//					System.out.println("Feld von eigener Spielfigur besetzt!");
					spiel.setLogging("Feld von eigener Spielfigur besetzt!");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Feld von eigener Spielfigur besetzt!");
				} else {
					schmeissen(spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur());
					spiel.getBrett().getSpielbrett()[0].getFelder()[spielfigur.getID()].setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[0].getFelder()[0]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
					
				}
			}
			// }
		}
		if (spieler.getFarbe().equals(FarbEnum.BLUE)) {
			// if (spieler.getWuerfel().getErgebnis() == 6) {
			if (spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur() == null) {
				spiel.getBrett().getSpielbrett()[10].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[10].getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			} else if (spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur() != null) {
				if (spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur().getFarbe())) {
//					System.out.println("Feld von eigener Spielfigur besetzt!");
					spiel.setLogging("Feld von eigener Spielfigur besetzt!");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Feld von eigener Spielfigur besetzt!");
				} else {
					schmeissen(spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur());
					spiel.getBrett().getSpielbrett()[10].getFelder()[spielfigur.getID()].setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[10].getFelder()[0]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
			// }
		}
		if (spieler.getFarbe().equals(FarbEnum.GREEN)) {
			// if (spieler.getWuerfel().getErgebnis() == 6) {
			if (spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur() == null) {
				spiel.getBrett().getSpielbrett()[20].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[20].getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			} else if (spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur() != null) {
				if (spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur().getFarbe())) {
//					System.out.println("Feld von eigener Spielfigur besetzt!");
					spiel.setLogging("Feld von eigener Spielfigur besetzt!");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Feld von eigener Spielfigur besetzt!");
				} else {
					schmeissen(spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur());
					spiel.getBrett().getSpielbrett()[20].getFelder()[spielfigur.getID()].setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[20].getFelder()[0]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
			// }
		}
		if (spieler.getFarbe().equals(FarbEnum.YELLOW)) {
			// if (spieler.getWuerfel().getErgebnis() == 6) {
			if (spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur() == null) {
				spiel.getBrett().getSpielbrett()[30].getFelder()[spielfigur.getID()].setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[30].getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			} else if (spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur() != null) {
				if (spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur().getFarbe())) {
//					System.out.println("Feld von eigener Spielfigur besetzt!");
					spiel.setLogging("Feld von eigener Spielfigur besetzt!");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Feld von eigener Spielfigur besetzt!");
				} else {
					schmeissen(spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur());
					spiel.getBrett().getSpielbrett()[30].getFelder()[spielfigur.getID()].setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[30].getFelder()[0]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
			// }
		}
		if(spiel.getAmZug().getKi()==null){
		spiel.setAmZug(spieler);
		}
	}

	/**
	 * Methode, um eine Spielfigur auf den Spielfeldern zu bewegen
	 * 
	 * @param spieler
	 * @param spielfigur
	 */

	private void figurZiehen(Spieler spieler, Spielfigur spielfigur) {
		if (spielfigur.istAufStartfeld() && spieler.getWuerfel().getErgebnis() == 6) {
			rauskommen(spieler, spielfigur);
			return;
		}else if(spielfigur.istAufStartfeld() && spieler.getWuerfel().getErgebnis() != 6){
//			System.out.println("Rauskommen nicht moeglich!");
			
			return;
		}
		
		int oldPos = spielfigur.getSpielfeld().getPosition() - 1;
		int newPos = oldPos + spieler.getWuerfel().getErgebnis();

		if (newPos >= 40) {
			spielfigur.setHatUmrundet(true);
			newPos -= 40;
		}

		if (spielfigur.hatUmrundet()) {
			switch (spielfigur.getFarbe()) {
			case RED:
				newPos++;
				if (newPos <= 4) {
					insEndfeldLaufen(spieler, spielfigur, newPos);
					
				}
				return;
			case BLUE:
				if (newPos >= 10) {
					newPos -= 9;
					if (newPos <= 4) {
						insEndfeldLaufen(spieler, spielfigur, newPos);
						return;
					}
				}
				break;
			case GREEN:
				if (newPos >= 20) {
					newPos -= 19;
					if (newPos <= 4) {
						insEndfeldLaufen(spieler, spielfigur, newPos);
						return;
					}
				}
				break;
			case YELLOW:
				if (newPos >= 30) {
					newPos -= 29;
					if (newPos <= 4) {
						insEndfeldLaufen(spieler, spielfigur, newPos);
						return;
					}
				}
				break;
			}
		}

		if (spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur() == null) {
			spielfigur.getSpielfeld().setSpielfigur(null);
			spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0]);
			spielfigur.getSpielfeld().setSpielfigur(spielfigur);
		} else if (spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur() != null) {
			if (spieler.getFarbe().equals(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur().getFarbe())) {
//				System.out.println("Feld von eigener Spielfigur besetzt!");
				spiel.setLogging("Feld von eigener Spielfigur besetzt!");
				if(spiel.getGui() != null)
					spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Feld von eigener Spielfigur besetzt!");
				return;
			} else {
				schmeissen(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0].getSpielfigur());
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[newPos].getFelder()[0]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			}
		}

		if (spieler.getWuerfel().getErgebnis() != 6 && spiel.getAmZug().getKi()==null) {
			spiel.setNaechster(spieler);
		} else if(spiel.getAmZug().getKi()==null){
			spiel.setAmZug(spieler);
		}

	}

	/**
	 * 
	 * Methode, um die Spielfigur auf die Endfelder zu bewegen newPos ist die
	 * neue Position auf den Endfeldern
	 * 
	 * @param spieler
	 * @param spielfigur
	 * @param newPos
	 */

	private void insEndfeldLaufen(Spieler spieler, Spielfigur spielfigur, int newPos) {
		switch (spielfigur.getFarbe()) {
		case RED:
			for (int i = 1; i <= newPos; i++) {
				if (spiel.getBrett().getSpielbrett()[39].getFelder()[i].getSpielfigur() != null) {
//					System.out.println("Ueberspringen nicht moeglich");
					spiel.setLogging("Ueberspringen nicht moeglich");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Ueberspringen im Endfeld nicht moeglich!");
					return;
				}
			}
			spielfigur.getSpielfeld().setSpielfigur(null);
			spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[39].getFelder()[newPos]);
			spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			break;
		case BLUE:
			for (int i = 1; i <= newPos; i++) {
				if (spiel.getBrett().getSpielbrett()[9].getFelder()[i].getSpielfigur() != null) {
//					System.out.println("Ueberspringen nicht moeglich");
					spiel.setLogging("Ueberspringen nicht moeglich");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Ueberspringen im Endfeld nicht moeglich!");
					return;
				}
			}
			spielfigur.getSpielfeld().setSpielfigur(null);
			spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[9].getFelder()[newPos]);
			spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			break;
		case GREEN:
			for (int i = 1; i <= newPos; i++) {
				if (spiel.getBrett().getSpielbrett()[19].getFelder()[i].getSpielfigur() != null) {
//					System.out.println("Ueberspringen nicht moeglich");
					spiel.setLogging("Ueberspringen nicht moeglich");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Ueberspringen im Endfeld nicht moeglich!");
					return;
				}
			}
			spielfigur.getSpielfeld().setSpielfigur(null);
			spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[19].getFelder()[newPos]);
			spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			break;
		case YELLOW:
			for (int i = 1; i <= newPos; i++) {
				if (spiel.getBrett().getSpielbrett()[29].getFelder()[i].getSpielfigur() != null) {
//					System.out.println("Ueberspringen nicht moeglich");
					spiel.setLogging("Ueberspringen nicht moeglich");
					if(spiel.getGui() != null)
						spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ "Ueberspringen im Endfeld nicht moeglich!");
					return;
				}
			}
			spielfigur.getSpielfeld().setSpielfigur(null);
			spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[29].getFelder()[newPos]);
			spielfigur.getSpielfeld().setSpielfigur(spielfigur);
			break;
		}

		if(!spielBeendet(spieler)){
			if (spieler.getWuerfel().getErgebnis() != 6 && spiel.getAmZug().getKi()==null) {
				spiel.setNaechster(spieler);
			} else if(spiel.getAmZug().getKi()==null){
				spiel.setAmZug(spieler);
			}
		}else{
//			System.out.println(spieler.toString()+" hat gewonnen!");
			spiel.setLogging(spieler.toString()+" hat gewonnen!");
			if(spiel.getGui() != null)
				spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ spieler.toString() +" hat gewonnen!");
		}
	}

	/**
	 * Methode ueberprüft, ob das neue Spielfeld frei oder besetzt ist, ist es
	 * besetzt von einer anderen Spielfigur, wird diese auf ihr Startfeld
	 * gesetzt
	 * 
	 * @param spielfigur
	 */
	private void schmeissen(Spielfigur spielfigur) {
		spielfigur.getSpielfeld().setSpielfigur(null);
		switch (spielfigur.getFarbe()) {
		case RED:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[0].getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[0].getFelder()[i].getSpielfigur() == null) {
					spielfigur.getSpielfeld().setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[0].getFelder()[i]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
			spiel.setLogging(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
//			System.out.println(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			if(spiel.getGui() != null)
				spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ spielfigur.toString() +"Wurde auf Startfeld geschmissen");
			break;
		case BLUE:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[10].getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[10].getFelder()[i].getSpielfigur() == null) {
					spielfigur.getSpielfeld().setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[10].getFelder()[i]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
//			System.out.println(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			spiel.setLogging(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			if(spiel.getGui() != null)
				spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ spielfigur.toString() +"Wurde auf Startfeld geschmissen");
			break;
		case GREEN:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[20].getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[20].getFelder()[i].getSpielfigur() == null) {
					spielfigur.getSpielfeld().setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[20].getFelder()[i]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
//			System.out.println(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			spiel.setLogging(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			if(spiel.getGui() != null)
				spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ spielfigur.toString() +"Wurde auf Startfeld geschmissen");
			break;
		case YELLOW:
			for (int i = 0; i < spiel.getBrett().getSpielbrett()[30].getFelder().length; i++) {
				if (spiel.getBrett().getSpielbrett()[30].getFelder()[i].getSpielfigur() == null) {
					spielfigur.getSpielfeld().setSpielfigur(null);
					spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[30].getFelder()[i]);
					spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				}
			}
//			System.out.println(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			spiel.setLogging(spielfigur.toString() + " Wurde auf Startfeld geschmissen");
			if(spiel.getGui() != null)
				spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+ spielfigur.toString() +"Wurde auf Startfeld geschmissen");
			break;
		}
		spiel.setGeschmissen(spielfigur);
	}

	// TODO: Methode im Endfeld vorlaufen!
	private void imEndfeldLaufen(Spieler spieler, Spielfigur spielfigur, int erg){
		int posEndfeld=Integer.parseInt(spielfigur.getSpielfeld().getID().substring(1));
		boolean gelaufen = false;
		switch (spielfigur.getFarbe()) {
		case RED:
			if(posEndfeld+erg < 5){
				for(int i=erg-1; i>0; i--){
					if(spiel.getBrett().getSpielbrett()[39].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//						System.err.println("kein ueberspringen"+(posEndfeld+erg-i));
						spiel.setLogging("kein ueberspringen");
						if(spiel.getGui() != null)
							spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+"kein Ueberspringen");
						return;
					}
				}
				if(spiel.getBrett().getSpielbrett()[39].getFelder()[posEndfeld+erg].getSpielfigur() != null){
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[39].getFelder()[posEndfeld+erg]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				gelaufen = true;
			}
			break;
		case BLUE:
			if(posEndfeld+erg < 5){
				for(int i=erg-1; i>0; i--){
					if(spiel.getBrett().getSpielbrett()[9].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//						System.err.println("besetzt/kein ueberspringen"+(posEndfeld+erg-i));
						spiel.setLogging("kein ueberspringen");
						if(spiel.getGui() != null)
							spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+"kein Ueberspringen");
						return;
					}
				}
				if(spiel.getBrett().getSpielbrett()[9].getFelder()[posEndfeld+erg].getSpielfigur() != null){
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[9].getFelder()[posEndfeld+erg]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				gelaufen = true;
			}
			break;
		case GREEN:
			if(posEndfeld+erg < 5){
				for(int i=erg-1; i>0; i--){
					if(spiel.getBrett().getSpielbrett()[19].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//						System.out.println("besetzt/kein ueberspringen");
						spiel.setLogging("kein ueberspringen");
						if(spiel.getGui() != null)
							spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+"kein Ueberspringen");
						return;
					}
				}
				if(spiel.getBrett().getSpielbrett()[19].getFelder()[posEndfeld+erg].getSpielfigur() != null){
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[19].getFelder()[posEndfeld+erg]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				gelaufen = true;
			}
			break;
		case YELLOW:
			if(posEndfeld+erg < 5){
				for(int i=erg-1; i>0; i--){
					if(spiel.getBrett().getSpielbrett()[29].getFelder()[posEndfeld+erg-i].getSpielfigur() != null){
//						System.out.println("besetzt/kein ueberspringen");
						spiel.setLogging("kein ueberspringen");
						if(spiel.getGui() != null)
							spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+"kein Ueberspringen");
						return;
					}
				}
				if(spiel.getBrett().getSpielbrett()[29].getFelder()[posEndfeld+erg].getSpielfigur() != null){
					return;
				}
				spielfigur.getSpielfeld().setSpielfigur(null);
				spielfigur.setSpielfeld(spiel.getBrett().getSpielbrett()[29].getFelder()[posEndfeld+erg]);
				spielfigur.getSpielfeld().setSpielfigur(spielfigur);
				gelaufen = true;
			}
			break;
		}
		
		if(!spielBeendet(spieler)){
			if(gelaufen == true){
				if (spieler.getWuerfel().getErgebnis() != 6 && spiel.getAmZug().getKi()==null) {
					spiel.setNaechster(spieler);
				} else if(spiel.getAmZug().getKi()==null){
					spiel.setAmZug(spieler);
				}
			}
		}else {
//			System.out.println(spieler.toString()+" hat gewonnen!");
			spiel.setLogging(spieler.toString()+" hat gewonnen!");
			if(spiel.getGui() != null)
				spiel.getGui().getAusgabe().setText(spiel.getGui().getAusgabe().getText()+"\n"+spieler.toString()+" hat gewonnen!");
		}
	}
	
	private boolean spielBeendet(Spieler spieler){
		int anzBesetzt=0;
		switch(spieler.getFarbe()){
		case RED:
			for(int i=1; i<5; i++){
				if(spiel.getBrett().getSpielbrett()[39].getFelder()[i].getSpielfigur() != null){
					anzBesetzt++;
				}
			}
			if(anzBesetzt == 4) {
				gewonnen = true;
				return true;
			}
			break;
		case BLUE:
			for(int i=1; i<5; i++){
				if(spiel.getBrett().getSpielbrett()[9].getFelder()[i].getSpielfigur() != null){
					anzBesetzt++;
				}
			}
			if(anzBesetzt == 4){
				gewonnen = true;
				return true;
			}
			break;
		case GREEN:
			for(int i=1; i<5; i++){
				if(spiel.getBrett().getSpielbrett()[19].getFelder()[i].getSpielfigur() != null){
					anzBesetzt++;
				}
			}
			if(anzBesetzt == 4){
				gewonnen = true;
				return true;
			}
			break;
		case YELLOW:
			for(int i=1; i<5; i++){
				if(spiel.getBrett().getSpielbrett()[29].getFelder()[i].getSpielfigur() != null){
					anzBesetzt++;
				}
			}
			if(anzBesetzt == 4){
				gewonnen = true;
				return true;
			}
			break;
		}
		return false;
	}
	
	public boolean getGewonnen(){
		return gewonnen;
	}

}
