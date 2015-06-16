package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import Backend.Spieler.Spielfigur;
import GUIswing.MngJFrame;
import Interfaces.iBediener;
import Interfaces.iDatenzugriff;

/**
 * Spiel Klasse dient zum "starten" des Spiels
 * 
 * @author Judith, Michi, Doerte, Tobi
 *
 */
public class SpielBean implements iBediener, Serializable {

	private static final long serialVersionUID = 1L;
	private Spielbrett brett;
	private ArrayList<Spieler> spieler;
	private Spieler amZug;
	private Spielfigur geschmissen;
	private Regelwerk regelwerk;
	private String dateiname;
	private MngJFrame gui;
	private String log;
	private int gewaehlteSpieler=0;
	private int gewaehlteKis=0;
	
	
	
	private iDatenzugriff d = new DatenzugriffCSV();
	private iDatenzugriff s = new DatenzugriffSerialisiert();

	/**
	 * Konstruktor der Spielklasse Spielbrett, Regelwerk und Spieler werden
	 * initialisiert
	 */
	public SpielBean() {
		this.brett = new Spielbrett();
		this.regelwerk = new Regelwerk(this);
		spieler = new ArrayList<Spieler>();
		log = "";
	}
	
	public SpielBean(MngJFrame gui){
		this();
		this.gui = gui;
	}

	/**
	 * gibt das Spielbrett zurueck
	 * 
	 * @return brett
	 */
	public Spielbrett getBrett() {
		return brett;
	}

	public int getGewaehlteSpieler(){
		return gewaehlteSpieler;
	}
	
	public void setGewaehlteSpieler(int gewaehlteSpieler ){
		this.gewaehlteSpieler=gewaehlteSpieler;
	}

	public int getGewaehlteKis(){
		return gewaehlteKis;
	}
	
	public void setGewaehlteKis(int gewaehlteKis ){
		this.gewaehlteKis=gewaehlteKis;
	}
	
	
	/**
	 * gibt das Array der Spieler zurueck
	 * 
	 * @return spieler
	 */

	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}

//	public void addSpieler(Spieler s) {
//		spieler.add(s);
//
//	}

	/**
	 * gibt zurueck welcher Spieler am Zug ist
	 * 
	 * @return amZug
	 */

	public Spieler getAmZug() {
		return amZug;
	}

	/**
	 * setzt den Spieler, welcher an der Reihe ist und wuerfelt
	 * 
	 * @param amZug
	 */
	public void setAmZug(Spieler amZug) {
		this.amZug = amZug;
//		System.out.println(getAmZug().toString() + " ist am Zug");
		setLogging(getAmZug().toString() + " ist am Zug");
		if(gui != null)
			gui.getAusgabe().setText(gui.getAusgabe().getText()+"\n"+getAmZug().toString() + " ist am Zug");
		getAmZug().getWuerfel().wuerfeln();
//		getAmZug().getWuerfel().wuerfel2();
//		getAmZug().getWuerfel().wurf6();
		setLogging(getAmZug().getWuerfel().getErgebnis()+" gewuerfelt");
		if(gui != null)
			gui.getAusgabe().setText(gui.getAusgabe().getText()+"\n"+getAmZug().getWuerfel().getErgebnis()+" gewuerfelt");

		if (amZug.getKi() != null) {
			amZug.getKi().kiZug();
		} else {
//			System.out.println(amZug.getKienum());
		}
		
		setIconBild(getAmZug().getWuerfel().getErgebnis());
		// System.out.println(brett.toString());
	}

	/**
	 * ermittelt Spieler der als naechstes am Zug ist
	 * 
	 * @param amZug
	 */
	public void setNaechster(Spieler amZug) {
		for (int i = 0; i <= spieler.size() - 1; i++) {
			if (amZug.equals(spieler.get(i))) {
				if (i == spieler.size() - 1) {
					setAmZug(spieler.get(0));
					return;
				}
				setAmZug(spieler.get(i + 1));
				return;
			}
		}
	}

	@Override
	public void SpielerHinzufuegen(String name, String farbe, String ki) {
		KIEnum ai = null;
		if (ki != null && !ki.equals("null")) {
			switch (ki.toUpperCase()) {
			case "AGGRESSIV":
				ai = KIEnum.AGGRESSIV;
				break;

			case "DEFENSIV":
				ai = KIEnum.DEFENSIV;
				break;

			default:
				throw new RuntimeException("Entweder `AGGRESSIV' oder `DEFENSIV' ");
			}
		}

		if (farbe != null) {
			FarbEnum f = null;
			switch (farbe.toUpperCase()) {
			case "RED":
				f = FarbEnum.RED;
				break;
			case "BLUE":
				f = FarbEnum.BLUE;
				break;
			case "GREEN":
				f = FarbEnum.GREEN;
				break;
			case "YELLOW":
				f = FarbEnum.YELLOW;
				break;
			default:
				throw new RuntimeException("Farbwahl bitte auf Englisch");
			}
			if (spieler.size() >= 4) {
				throw new RuntimeException("keine Plaetze mehr verfuegbar");
			}
			if (name == null) {
				throw new RuntimeException("ungueltige Eingabe");
			}
			for (Spieler s : spieler) {
				if (s.getFarbe().equals(farbe)) {
					throw new RuntimeException("Farbe schon vergeben");
				}
			}
			spieler.add(new Spieler(name, f, ai, this));
		}
	}

	@Override
	public void initSpiel() {
		setLogging("Spiel gestartet\n---------------------");
		for (Spieler s : spieler) {
			FarbEnum farbe = s.getFarbe();
			switch (farbe) {
			case RED:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i+1).setSpielfeld(brett.getSpielbrett()[0].getFelder()[i + 1]);
					brett.getSpielbrett()[0].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			case BLUE:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i+1).setSpielfeld(brett.getSpielbrett()[10].getFelder()[i + 1]);
					brett.getSpielbrett()[10].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			case GREEN:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i+1).setSpielfeld(brett.getSpielbrett()[20].getFelder()[i + 1]);
					brett.getSpielbrett()[20].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			case YELLOW:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i+1).setSpielfeld(brett.getSpielbrett()[30].getFelder()[i + 1]);
					brett.getSpielbrett()[30].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				break;
			}
		}
		
//		System.out.println(brett.toString());
		setAmZug(spieler.get(0));
		
	}

	@Override
	public void initTestSpiel() {
		for (Spieler s : spieler) {
			FarbEnum farbe = s.getFarbe();
			switch (farbe) {
			case RED:
				s.getSpielfigurNeu(0).setSpielfeld(brett.getSpielbrett()[0].getFelder()[1]);
				brett.getSpielbrett()[0].getFelder()[1].setSpielfigur(s.getSpielfigurNeu(0));

				s.getSpielfigurNeu(1).setSpielfeld(brett.getSpielbrett()[39].getFelder()[0]);
				brett.getSpielbrett()[39].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(1));

				s.getSpielfigurNeu(2).setSpielfeld(brett.getSpielbrett()[3].getFelder()[0]);
				brett.getSpielbrett()[3].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(2));

				s.getSpielfigurNeu(3).setSpielfeld(brett.getSpielbrett()[20].getFelder()[0]);
				brett.getSpielbrett()[20].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(3));
				break;
			case GREEN:
				for (int i = 1; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigur(i).setSpielfeld(brett.getSpielbrett()[20].getFelder()[i + 1]);
					brett.getSpielbrett()[20].getFelder()[i + 1].setSpielfigur(s.getSpielfigur(i + 1));
				}
				s.getSpielfigur(0).setSpielfeld(brett.getSpielbrett()[5].getFelder()[0]);
				brett.getSpielbrett()[5].getFelder()[0].setSpielfigur(s.getSpielfigur(0));
				break;
			}
		}
		// System.out.println(brett.toString());
		//setAmZug(spieler.get(0));
	}

	@Override
	public void initTestSpielZugAggressiv() {
		for (Spieler s : spieler) {
			FarbEnum farbe = s.getFarbe();
			switch (farbe) {
			case RED:
				s.getSpielfigurNeu(0).setSpielfeld(brett.getSpielbrett()[0].getFelder()[1]);
				brett.getSpielbrett()[0].getFelder()[1].setSpielfigur(s.getSpielfigurNeu(0));

				s.getSpielfigurNeu(1).setSpielfeld(brett.getSpielbrett()[39].getFelder()[0]);
				brett.getSpielbrett()[39].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(1));

				s.getSpielfigurNeu(2).setSpielfeld(brett.getSpielbrett()[3].getFelder()[0]);
				brett.getSpielbrett()[5].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(2));

				s.getSpielfigurNeu(3).setSpielfeld(brett.getSpielbrett()[20].getFelder()[0]);
				brett.getSpielbrett()[20].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(3));
				break;
			case GREEN:
				for (int i = 0; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigurNeu(i).setSpielfeld(brett.getSpielbrett()[20].getFelder()[i + 1]);
					brett.getSpielbrett()[20].getFelder()[i + 1].setSpielfigur(s.getSpielfigurNeu(i));
				}
			}
		}
		// System.out.println(brett);
		setAmZug(spieler.get(0));
	}

	@Override
	public void initTestSpielZugDefensiv() {
		for (Spieler s : spieler) {
			FarbEnum farbe = s.getFarbe();
			switch (farbe) {
			case RED:
				s.getSpielfigurNeu(0).setSpielfeld(brett.getSpielbrett()[0].getFelder()[1]);
				brett.getSpielbrett()[0].getFelder()[1].setSpielfigur(s.getSpielfigurNeu(0));

				s.getSpielfigurNeu(1).setSpielfeld(brett.getSpielbrett()[39].getFelder()[2]);
				brett.getSpielbrett()[39].getFelder()[2].setSpielfigur(s.getSpielfigurNeu(1));

				s.getSpielfigurNeu(2).setSpielfeld(brett.getSpielbrett()[3].getFelder()[0]);
				brett.getSpielbrett()[3].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(2));

				s.getSpielfigurNeu(3).setSpielfeld(brett.getSpielbrett()[20].getFelder()[0]);
				brett.getSpielbrett()[20].getFelder()[0].setSpielfigur(s.getSpielfigurNeu(3));
				break;
			case GREEN:
				for (int i = 1; i < s.getSpielfiguren().length; i++) {
					s.getSpielfigurNeu(i).setSpielfeld(brett.getSpielbrett()[20].getFelder()[i + 1]);
					brett.getSpielbrett()[20].getFelder()[i + 1].setSpielfigur(s.getSpielfigurNeu(i));
				}
				s.getSpielfigur(0).setSpielfeld(brett.getSpielbrett()[5].getFelder()[0]);
				brett.getSpielbrett()[5].getFelder()[0].setSpielfigur(s.getSpielfigur(0));
				break;
			}
		}
		// System.out.println(brett);
		setAmZug(spieler.get(0));
	}

	/**
	 * ruft im Regelwerk die Funktion AktionsWahl auf um damit den Spielzug zu
	 * bestimmen
	 * 
	 * @param id
	 *            der Spielfigur
	 */
	public void zugDurchfuehren(int ID) {
		setGeschmissen(null);
		regelwerk.aktionsWahl(getAmZug(), getAmZug().getSpielfigur(ID), getAmZug().getWuerfel().getErgebnis());
//		setIconBild(getAmZug().getWuerfel().getErgebnis());
//		System.out.println(brett.toString());
	}
	@Override
	public int setIconBild(int erg){
		if(gui != null)
			gui.setIconNeu(erg);
		return erg;
	}
	/**
	 * Ist eine Testklasse um zu testen, dass die Figuren geschmissen werden
	 * können
	 * 
	 * @param id
	 *            der Spielfigur
	 */
	public void zugDurchfuehrenSchmeissenTest(int ID) {
		regelwerk.aktionsWahl(spieler.get(1), spieler.get(1).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		System.out.println(brett.toString());
	}

	/**
	 * Ist eine Testklasse um zu Testen, ob die Spielfiguren richtig ins Endfeld
	 * laufen
	 * 
	 * @param id
	 *            der Spielfigur
	 */
	public void zugDurchfuehrenEndfeldTest(int ID) {
		for (int i = 1; i <= 21; i++) {
			regelwerk.aktionsWahl(spieler.get(0), spieler.get(0).getSpielfigur(ID), 2);
		}
		System.out.println(brett.toString());
	}

	/**
	 * gibt das Regelwerk zurueck
	 * 
	 * @return regelwerk
	 */
	public Regelwerk getRegelwerk() {
		return regelwerk;
	}

	@Override
	public String toString() {
		String s = "";
		s += brett.toString();
		return s;
	}

	@Override
	public Object laden(String dateiname, String dateiende) {
		if (dateiende.equals("csv")) {
			// this.brett = new Spielbrett();
			spieler.clear();
			String t = (String) d.laden(dateiname);
			String[] x = t.split("\n");
			String[] a = x[0].split("_");
			int i = 1;

			while (a[0].equals("Spieler")) {
				SpielerHinzufuegen(a[1], a[2], a[3]);

				a = x[i].split("_");
				i++;
			}
			initSpiel();
			// hier Spieler am Zug einbauen!!
			// i++;
			if (a[0].contains("AmZug")) {
//				System.err.println(a[3]);
				for (Spieler searched : this.getSpieler()) {

					if ((searched.getFarbe() == FarbEnum.RED && a[3].equals("RED"))) {
						setAmZug(searched);
					}
					if ((searched.getFarbe() == FarbEnum.BLUE && a[3].equals("BLUE"))) {
						setAmZug(searched);
					}
					if ((searched.getFarbe() == FarbEnum.GREEN && a[3].equals("GREEN"))) {
						setAmZug(searched);
					}
					if ((searched.getFarbe() == FarbEnum.YELLOW && a[3].equals("YELLOW"))) {
						setAmZug(searched);
					}
				}
//				System.err.println(getAmZug());
			}
			a = x[i].split("_");
			// hier SPieler am zug einbauen!!

			while (!a[2].equals("null")) {
				if (!a[0].contains("S")) {
					Spieler spieler = null;
					int id = -1;
					System.out.println(this.getSpieler().size());
					for (Spieler search : this.getSpieler()) {
						if ((search.getFarbe() == FarbEnum.RED && a[4].equals("RED")) || (search.getFarbe() == FarbEnum.BLUE && a[4].equals("BLUE"))
								|| (search.getFarbe() == FarbEnum.GREEN && a[4].equals("GREEN")) || (search.getFarbe() == FarbEnum.YELLOW && a[4].equals("YELLOW")))
							spieler = search;
					}
					if (spieler == null) {
						throw new RuntimeException("Behinderter Fehler beim Laden von Spielfiguren");
					}
					if (a[2].contains("1")) {
						id = 1;
					} else if (a[2].contains("2")) {
						id = 2;
					} else if (a[2].contains("3")) {
						id = 3;
					} else if (a[2].contains("4")) {
						id = 4;
					}
					spieler.getSpielfigur(id).getSpielfeld().setSpielfigur(null);
					spieler.getSpielfigur(id).setSpielfeld(this.getBrett().getSpielbrett()[Integer.parseInt(a[0])].getFelder()[0]);
					spieler.getSpielfigur(id).getSpielfeld().setSpielfigur(spieler.getSpielfigur(id));
				}
				i++;
				a = x[i].split("_");
			}
			return null;
		} else {
			if (dateiende.equals("ser")) {

				return s.laden(dateiende);

			}
		}

		return null;
	}
	public int getWuerfel(){
		return amZug.getWuerfel().getErgebnis();
	}

	@Override
	public void Speichern(String dateiname, String dateiende) throws IOException {
		if (dateiende.equals("csv")) {
			String s = "";
			for (Spieler spieler : this.getSpieler()) {
				s += spieler + "\n";
			}

			s += "AmZug_" + getAmZug() + "\n";

			for (int i = 0; i < getBrett().getSpielbrett().length; i++) {
				switch (i) {
				case 0:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 10:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 20:

					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 30:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 40:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 39:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;

				case 9:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 19:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;
				case 29:
					for (int j = 0; j <= 4; j++) {
						s += getBrett().getSpielbrett()[i].getFelder()[j].toString();
					}
					break;

				default:
					s += getBrett().getSpielbrett()[i].getFelder()[0].toString();
					break;
				}

			}

			d.speichern(dateiname, dateiende, s);

		} else {
			if (dateiende.equals("ser")) {
				s.speichern(dateiname, dateiende, this);
			}
		}

	}

	public String getDateiname() {
		return dateiname;
	}

	public void setGui(MngJFrame gui) {
		this.gui = gui;
	}

	public MngJFrame getGui() {
		return gui;
	}
	public Spielfigur getGeschmissen() {
		return geschmissen;
	}

	public void setGeschmissen(Spielfigur geschmissen) {
		this.geschmissen = geschmissen;
	}
	
	public void setLogging(String s){
		this.log=getLogging()+"\n"+s;
	}
	public String getLogging(){
		return log;
	}

}
