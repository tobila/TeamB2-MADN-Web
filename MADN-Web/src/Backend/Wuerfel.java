package Backend;

import java.io.Serializable;
import java.util.Random;
/**
 * klasse zum Wuerfeln
 * @author Judith, Michi,Tobi,Doerte
 *
 */

public class Wuerfel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ergebnis;
	
	
	/**
	 * methode zum Wuerfeln
	 * @return eine Zufallszahl zwischen 1 und 6
	 */
	public int  wuerfeln(){
		
		ergebnis= new Random().nextInt(6);
		ergebnis=ergebnis+1;
		String[] zahlen = { "Eins","Zwei","Drei","Vier","Fuenf","Sechs" };
//		System.out.println(zahlen[ergebnis-1] + " gewuerfelt");
		
		return ergebnis;
	}
	
	public void wuerfel2(){
		this.ergebnis = 2;
//		System.out.println("2 gewuerfelt");
	}
	
	/**
	 * gibt das Ergebnis vom Wuerfel zurueck
	 * @return eine Zahl zwischen 1 und 6
	 */
	public int getErgebnis(){
//		wuerfel();
		return ergebnis;
	}
	
	
	/**
	 * Pseudowuerfel zum testen 
	 * @return  6
	 */
	public void wurf6(){
//		System.out.println("gewuerfelt");
		ergebnis = 6;
//		return 6;
	}
}
	

