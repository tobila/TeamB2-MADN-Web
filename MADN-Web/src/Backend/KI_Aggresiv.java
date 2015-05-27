package Backend;

import java.io.Serializable;

public class KI_Aggresiv extends KI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KI_Aggresiv(Spieler spieler, SpielBean spiel) {
		super(spieler, spiel);
	}

	/**
	 * gibt eine Spielfigur weiter in zugDurchführen der Klasse Spiel mit
	 * folgender Priorität:1. schmeissen wenn nicht dann 2. Versuchen raus zu
	 * kommen wenn nicht dann 3. Versuche ins Endfeld wenn nicht dann 4. Figur
	 * im Spielfeld ziehen wenn nicht dann ist der nächste Spieler am Zug
	 */

	@Override
	public void kiZug() {
		int id = 0;
		boolean keinZug = false;
		if (KIVersucheSchmeissen() != null) {
			id = KIVersucheSchmeissen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheRauskommen() != null) {
			id = KIVersucheRauskommen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheZiehenStartpos() != null) {
			id = KIVersucheZiehenStartpos().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheInsEndfeld() != null) {
			id = KIVersucheInsEndfeld().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheImEndfeldLaufen() != null) {
			id = KIVersucheImEndfeldLaufen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheFigurZiehen() != null) {
			id = KIVersucheFigurZiehen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else{
			super.getSpiel().setNaechster(super.getSpieler());
			keinZug = true;
		}
		
		if(!keinZug){
			super.getSpiel().getGui().getKiWeiter().setEnabled(true);
			super.getSpiel().getGui().KIFigurenZiehen(super.getSpieler().getSpielfigur(id));
			setGezogenButton(true);
		}
	}

}
