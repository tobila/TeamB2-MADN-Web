package Backend;

import java.io.Serializable;

public class KI_Defensiv extends KI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KI_Defensiv(Spieler spieler, SpielBean spiel) {
		super(spieler, spiel);

	}

	/**
	 * gibt eine Spielfigur weiter in zugDurchführen der Klasse Spiel mit
	 * folgender Priorität: 1.Versuchen raus zu kommen, wenn nicht dann 2.
	 * Versuche ins Endfeld zu kommen, wenn nicht dann 3. Versuche Figur zu
	 * ziehen, wenn nicht dann 4. schmeissen wenn nicht dann ist der nächste
	 * Spieler am Zug
	 * 
	 */

	@Override
	public void kiZug() {
		int id = 0;
		boolean keinZug = false;

		if (KIVersucheInsEndfeld() != null) {
			id = KIVersucheInsEndfeld().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheImEndfeldLaufen() != null) {
			id = KIVersucheImEndfeldLaufen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheRauskommen() != null) {
			id = KIVersucheRauskommen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheZiehenStartpos() != null) {
			id = KIVersucheZiehenStartpos().getID();
			super.getSpiel().zugDurchfuehren(id);

		}else if (KIVersucheSchmeissen() != null) {
			id = KIVersucheSchmeissen().getID();
			super.getSpiel().zugDurchfuehren(id);

		} else if (KIVersucheFigurZiehen() != null) {
			id = KIVersucheFigurZiehen().getID();
			super.getSpiel().zugDurchfuehren(id);
		}else {
			super.getSpiel().setNaechster(super.getSpieler());
			keinZug = true;
		}if (!keinZug) {
			super.getSpiel().getGui().getKiWeiter().setEnabled(true);
			super.getSpiel().getGui()
					.KIFigurenZiehen(super.getSpieler().getSpielfigur(id));
			setGezogenButton(true);
		}
	}

}
