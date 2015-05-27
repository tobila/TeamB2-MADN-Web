package Interfaces;

import java.io.IOException;

public interface iBediener {
	
	/**
	 * Methode um einen Spieler hinzuzufuegen
	 * @param name des Spielers 
	 * @param farbe der gewaehlten Spilfigur 
	 */
	public void SpielerHinzufuegen(String name, String farbe, String ki);
	
	/**
	 * Methode um das Spiel zu initialisieren 
	 */
	public void initSpiel();
	
	public void zugDurchfuehren(int ID);
	public void zugDurchfuehrenSchmeissenTest(int ID);
	public void zugDurchfuehrenEndfeldTest(int ID);

	void initTestSpiel();
	int getWuerfel();

	void initTestSpielZugAggressiv();
	void initTestSpielZugDefensiv();

	Object laden(String dateiname, String dateiende);
	void Speichern(String dateiname, String dateiende) throws IOException;

	int setIconBild(int erg);
	
	
	
}
