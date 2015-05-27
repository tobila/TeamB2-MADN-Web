package Backend;

import java.io.Serializable;

/** Diee Klasse stellt das Spielbrett dar
 * @author Judth, Michi,Tobi,Doerte
 * @version 1
 */
public class Spielbrett implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FeldWrapper spielbrett[];
	
	
	/** Default-Kontruktor erzeugt beim Aufruf ein Array Objekt  vom DatenTyp FeldWrapper 
	 * welches die 40 Spielfelder vom Spielbrett darstellen.
	 * **/
	
	public Spielbrett() {

		spielbrett = new FeldWrapper[40];
		for (int i = 0; i < spielbrett.length; i++) {
			switch (i + 1) {
			case (1):
				spielbrett[i] = new FeldWrapper(true, false, FarbEnum.RED);
			break;
			case (11):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.BLUE);
			break;
			case (21):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.GREEN);
			break;
			case (31):
				spielbrett[i] = new FeldWrapper(true, false,FarbEnum.YELLOW);
			break;
			case (10):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.BLUE);
			break;
			case (20):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.GREEN);
			break;
			case (30):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.YELLOW);
			break;
			case (40):
				spielbrett[i] = new FeldWrapper(false, true,FarbEnum.RED);
			break;
			default:
				spielbrett[i] = new FeldWrapper(false, false,null);
			}

		}

	}
	
	
	/** gibt das Array Spielbrett, also die 40 Felder zurueck
	 * @return Spielbrett
	 */
	public FeldWrapper[] getSpielbrett() {
		return spielbrett;
	}
	
	
	
	@Override 
	public String toString(){
		String s="";
		for(FeldWrapper w:spielbrett){
			s+=w.toString()+"\n";
		}
		return s;
	}
}
