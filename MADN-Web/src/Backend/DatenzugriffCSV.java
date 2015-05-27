package Backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import Interfaces.iDatenzugriff;

import com.itextpdf.text.DocumentException;

public class DatenzugriffCSV implements iDatenzugriff, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SpielBean spiel;
	private Spieler spieler;
	private String dateiname;

//	public DatenzugriffCSV() {
//		this.spiel = spiel;
//		setDateiname(dateiname);
//	}

	public void setDateiname(String dateiname){
		this.dateiname=dateiname;
	}
	@Override
	public void speichern(String dateiname, String dateiende, Object o) throws IOException {
		
		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new FileWriter(dateiname+".csv"));
			
			String s = null;
			try{
				s = (String)o;
			}catch(Exception e){
				System.err.println("Kein String �bergeben");
			}
			pw.write(s);
			pw.flush();
			pw.close();

		} catch (NullPointerException e) {
			throw new IOException("UNerwartetes Dateiende");
		} catch (NumberFormatException e) {
			throw new IOException("Falsches Elementformat ");
		} catch (IndexOutOfBoundsException e) {
			throw new IOException("zu wenig Datenelemente");
		}
	}
	
	
	@Override
	public Object laden(String dateiname) {
		BufferedReader reader = null; 
		try{
			reader = new BufferedReader(new FileReader(dateiname+".csv"));
			String s = reader.readLine();
			String erg = "";
			while ( s != null){
				erg += s+"\n";
				s= reader.readLine();
			} return erg;
			
//			Spieler s = new Spieler (reader);
//
//			spiel.setAmZug(s);
//			System.out.println(spiel.getSpieler().toString());
//			spiel.getSpieler().clear();
//			spiel.addSpieler(s);
//			System.out.println(s);
//			System.out.println(spiel.getSpieler().toString());
		}
		catch (Exception e ){
			e.printStackTrace();
		}
		return null;
		}
	@Override
	public void spielfeld(SpielBean spiel) throws FileNotFoundException,
			DocumentException {
		// TODO Auto-generated method stub
		
	}
}