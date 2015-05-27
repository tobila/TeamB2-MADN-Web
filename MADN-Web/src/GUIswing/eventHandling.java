package GUIswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.DocumentException;

import Backend.DatenzugriffPDF;
import Backend.DatenzugriffSerialisiert;
import Backend.FarbEnum;
import Backend.Mail;
import Backend.SpielBean;
import Backend.Spieler;
import Interfaces.iBediener;
import Interfaces.iDatenzugriff;

/**
 * Klasse EventHandling von Manager JFrame
 * 
 * @author Michi, Doerte, Tobi
 *
 */

public class eventHandling extends JFrame implements ActionListener, iBediener, CaretListener, Serializable {

	private static final long serialVersionUID = 1L;
	private JButton ButtonStart;
	private JButton ButtonSpeichern;
	private JButton ButtonLaden;
	private JButton ButtonUeber;
	private JButton ButtonBeenden;
	private JButton ButtonSchliessen;
	private JButton ButtonOk;
	private JButton ButtonWuerfel;
	private static JButton schliessen;
	private MngJFrame frame;
	private JFrame dialogfenster = new JFrame("Startfenster");
	private JButton[] figurenRot;
	private JButton[] figurenGruen;
	private JButton[] figurenGelb;
	private JButton[] figurenBlau;
	private JButton ziehen;
	private int spielfigurID = 0;
	private JButton aktuelleFigur;
	private JButton btn;
	private JButton buttonKiWeiter;
	private JButton aussetzen;
	private JButton ButtonPDF;
	private JButton ButtonHauptmenu;
	private String mailSer = "";
	private String mailPdf = "";
	
	public void setButtonPDF(JButton PDF){
		this.ButtonPDF = PDF;
	}

	public void setButtonHauptmenu(JButton Hauptmenu){
		this.ButtonHauptmenu=Hauptmenu;
	}
	public void setButtonAussetzen(JButton aussetzen) {
		this.aussetzen = aussetzen;
	}

	public void setButtonKiWeiter(JButton kiWeiter) {
		buttonKiWeiter = kiWeiter;
	}

	public void setFigurenGruen(JButton[] figurenGruen) {
		this.figurenGruen = figurenGruen;
	}

	public void setFigurenGelb(JButton[] figurenGelb) {
		this.figurenGelb = figurenGelb;
	}

	public void setFigurenBlau(JButton[] figurenBlau) {
		this.figurenBlau = figurenBlau;
	}

	public eventHandling(MngJFrame frame) {
		this.frame = frame;
		setButtonSchliessen(schliessen);
	}

	public eventHandling(JButton btn) {
		this.btn = btn;
	}

	public void setButtonZiehen(JButton ziehen) {
		this.ziehen = ziehen;
	}

	public void setFigurenRot(JButton[] figurenRot) {
		this.figurenRot = figurenRot;
	}

	public void setButtonOk(JButton ok) {
		this.ButtonOk = ok;
	}

	public void setButtonStart(JButton start) {
		this.ButtonStart = start;
	}

	public void setButtonWuerfel(JButton wuerfel) {
		this.ButtonWuerfel = wuerfel;
	}

	public void setButtonSpeichern(JButton speichern) {
		this.ButtonSpeichern = speichern;
	}

	public void setButtonLaden(JButton laden) {
		this.ButtonLaden = laden;
	}

	public void setButtonUeber(JButton ueber) {
		this.ButtonUeber = ueber;
	}

	public void setButtonBeenden(JButton beenden) {
		this.ButtonBeenden = beenden;
	}

	public void setButtonSchliessen(JButton schliessen) {
		this.ButtonSchliessen = schliessen;
	}

	
	/**
	 * Methode enthaelt alle Button Events
	 */
	@Override
	public void actionPerformed(ActionEvent a_event) {
		Object EventSource = a_event.getSource();
		SpielBean sp = frame.getSpiel();
		Spieler lokalAmZug = sp.getAmZug();
		

		if(EventSource == frame.getMail()){
			mailSer = null;
			mailPdf = null;
			frame.getAnhang1().setText("Anhang 1: ---");
			frame.getAnhang2().setText("Anhang 2: ---");
			frame.mailFenster();
		}
		if(EventSource == frame.getMailAnhang()[0]){
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream("Spielstand." + "ser"));
				oos.writeObject(frame.getSpiel());
			} catch (Exception e) {
				e.printStackTrace();
			}
			frame.getAnhang1().setText("Anhang 1: Spielstand.ser");
			mailSer = "Spielstand.ser";
		}
		if(EventSource == frame.getMailAnhang()[1]){
			iDatenzugriff pdf = new DatenzugriffPDF();
			try {
				pdf.spielfeld(frame.getSpiel());
			} catch (FileNotFoundException | DocumentException e) {
				e.printStackTrace();
			}
			frame.getAnhang2().setText("Anhang 2: Spielstand.pdf");
			mailPdf = "Spielstand.pdf";
		}
		if(EventSource == frame.getMailSenden()){
			String text;
			
			text= " Hallo Spieler, \n im Anhang befindet sich Dein aktueller Spielstand deines Mensch ärger dich nicht Spiel. \n Mit freundlichen Grüßen \n dein Team B2   ";
			new Mail(frame.getMailAn().getText(),"Spielstand MADN", text, mailSer, mailSer, mailPdf, mailPdf, frame);
			frame.getMailFrame().setVisible(false);
		}
		
		if (EventSource == ButtonBeenden) {
			System.exit(0);
		}
		if (EventSource == ButtonWuerfel) {
		}
		if (EventSource == ButtonSpeichern) {
			JFileChooser chooser = new JFileChooser();
			chooser.showSaveDialog(null);
			if(chooser.getSelectedFile() == null) return;
			
			ObjectOutputStream oos = null;
			try {
				if(chooser.getSelectedFile().toString().contains(".ser"))
					oos = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile().toString()));
				else
					oos = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile().toString() + ".ser"));
				oos.writeObject(frame.getSpiel());
			} catch (Exception e) {
				e.printStackTrace();
			}
			frame.getAusgabe().setText(frame.getAusgabe().getText()+"\nSpiel erfolgreich gespreichert!");
		}
		
		if (EventSource == ButtonOk) {
			String[] spielerNamen = new String[4];
			String[] spielerFarbe = new String[4];
			for (int i = 0; i < 4; i++) {
				spielerNamen[i] = frame.getNamen()[i].getText();
				spielerFarbe[i] = frame.getFarbe()[i].getSelectedItem().toString();
			}

			if (spielerFarbe[0].equals(spielerFarbe[1]) && !spielerNamen[0].equals("") && !spielerNamen[1].equals("")) {
				frame.gleicheFarbeDialog();
				return;
			}
			if (spielerFarbe[0].equals(spielerFarbe[2]) && !spielerNamen[0].equals("") && !spielerNamen[2].equals("")) {
				frame.gleicheFarbeDialog();
				return;
			}
			if (spielerFarbe[0].equals(spielerFarbe[3]) && !spielerNamen[0].equals("") && !spielerNamen[3].equals("")) {
				frame.gleicheFarbeDialog();
				return;
			}
			if (spielerFarbe[1].equals(spielerFarbe[2]) && !spielerNamen[1].equals("") && !spielerNamen[2].equals("")) {
				frame.gleicheFarbeDialog();
				return;
			}
			if (spielerFarbe[1].equals(spielerFarbe[3]) && !spielerNamen[1].equals("") && !spielerNamen[3].equals("")) {
				frame.gleicheFarbeDialog();
				return;
			}
			if (spielerFarbe[2].equals(spielerFarbe[3]) && !spielerNamen[2].equals("") && !spielerNamen[3].equals("")) {
				frame.gleicheFarbeDialog();
				return;
			}

			for (int i = 0; i < 4; i++) {
				if (!frame.getNamen()[i].getText().equals("")) {
					if (frame.getKI()[i].getSelectedItem().toString().equals("KI Aggressiv")) {
						frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "aggressiv");
						frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
					} else if (frame.getKI()[i].getSelectedItem().toString().equals("KI Defensiv")) {
						frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "defensiv");
						frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
					} else {
						frame.getSpiel().SpielerHinzufuegen(frame.getNamen()[i].getText(), frame.getFarbe()[i].getSelectedItem().toString(), "null");
						frame.figurButton(frame.getFarbe()[i].getSelectedItem().toString());
					}
				}
			}

			frame.getSpiel().initSpiel();
			frame.getDialogFenster().setVisible(false);
			frame.getDialogFenster().dispose();
			frame.spielFenster();
			String s = "";
			for (int i = 0; i < sp.getSpieler().size(); i++) {
				s += "Spieler " + (i + 1) + ": " + sp.getSpieler().get(i) + "\n";
			}
			frame.getAusgabe().setText(
					"****************************************************************\n" + "NEUES SPIEL ANGELEGT\n" + s + "****************************************************************\n"
							+ sp.getAmZug() + " ist am Zug\n" + sp.getAmZug().getWuerfel().getErgebnis() + " gewuerfelt");

		}

		if (EventSource == ButtonStart) {

			frame.dialogFenster();
			frame.hide();
		}
		if (EventSource == ButtonUeber) {
			{

				JFrame ueber = new JFrame();
				ueber.setLayout(null);
				ueber.setResizable(false);
				ueber.setTitle("Ueber uns");
				ueber.setSize(300, 150);
				ueber.setLocationRelativeTo(null);
				ueber.setAlwaysOnTop(true);
				JLabel text = new JLabel("Autoren: \n Doerte, Michael, Tobi");
				text.setBounds(getWidth() / 2, 0, 500, 100);
				JButton schliessen = new JButton("schlie�en");
				schliessen.addActionListener(this);
				schliessen.setBounds(100, 75, 100, 30);
				ueber.add(text);
				ueber.add(schliessen);
				ueber.setVisible(true);
			}
			if (EventSource == ButtonSchliessen) {
				System.exit(0);
			}

		}

		if (EventSource == ButtonLaden) {
			DatenzugriffSerialisiert s = new DatenzugriffSerialisiert();
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("serialized *.ser", "ser");
			chooser.setFileFilter(filter);
			chooser.showOpenDialog(null);
			if(chooser.getSelectedFile() == null) return;
			
			frame.setS((SpielBean)s.laden(chooser.getSelectedFile().toString()));
			frame.getSpiel().setGui(frame);
			sp = frame.getSpiel();
			lokalAmZug = sp.getAmZug();

			frame.spielFenster();
			frame.setIconNeu(frame.getSpiel().getSpieler().get(0).getWuerfel().getErgebnis());
			frame.getAusgabe().setText("Spiel erfolgreich geladen\n----------------------\n"
									  + sp.getAmZug() + " ist am Zug\n" + sp.getAmZug().getWuerfel().getErgebnis() + " gewuerfelt");

			for (int i=0; i<frame.getSpiel().getSpieler().size(); i++) {
				Spieler spieler = frame.getSpiel().getSpieler().get(i);
				switch(spieler.getFarbe()){
				case RED:
					for(int k=0; k<4; k++){
						int pos = spieler.getSpielfigurNeu(k).getSpielfeld().getPosition();
						if(pos!=0){
							frame.getFields()[pos-1].add(frame.getFigurenRed()[k]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("S")){
							int posStartfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getRed()[posStartfeld-1].add(frame.getFigurenRed()[spieler.getSpielfigurNeu(k).getID()-1]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("E")){
							int posEndfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getRed()[posEndfeld+3].add(frame.getFigurenRed()[spieler.getSpielfigurNeu(k).getID()-1]);
						}
						frame.getFigurenRed()[k].setVisible(true);
					}
					break;
				case BLUE:
					for(int k=0; k<4; k++){
						int pos = spieler.getSpielfigurNeu(k).getSpielfeld().getPosition();
						if(pos!=0){
							frame.getFields()[pos-1].add(frame.getFigurenBlue()[k]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("S")){
							int posStartfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getBlue()[posStartfeld-1].add(frame.getFigurenBlue()[spieler.getSpielfigurNeu(k).getID()-1]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("E")){
							int posEndfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getBlue()[posEndfeld+3].add(frame.getFigurenBlue()[spieler.getSpielfigurNeu(k).getID()-1]);
						}
						frame.getFigurenBlue()[k].setVisible(true);
					}
					break;
				case GREEN:
					for(int k=0; k<4; k++){
						int pos = spieler.getSpielfigurNeu(k).getSpielfeld().getPosition();
						if(pos!=0){
							frame.getFields()[pos-1].add(frame.getFigurenGreen()[k]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("S")){
							int posStartfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getGreen()[posStartfeld-1].add(frame.getFigurenGreen()[spieler.getSpielfigurNeu(k).getID()-1]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("E")){
							int posEndfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getGreen()[posEndfeld+3].add(frame.getFigurenGreen()[spieler.getSpielfigurNeu(k).getID()-1]);
						}
						frame.getFigurenGreen()[k].setVisible(true);
					}
					break;
				case YELLOW:
					for(int k=0; k<4; k++){
						int pos = spieler.getSpielfigurNeu(k).getSpielfeld().getPosition();
						if(pos!=0){
							frame.getFields()[pos-1].add(frame.getFigurenYellow()[k]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("S")){
							int posStartfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getYellow()[posStartfeld-1].add(frame.getFigurenYellow()[spieler.getSpielfigurNeu(k).getID()-1]);
						}else if(spieler.getSpielfigurNeu(k).getSpielfeld().getID().contains("E")){
							int posEndfeld=Integer.parseInt(spieler.getSpielfigurNeu(k).getSpielfeld().getID().substring(1));
							frame.getYellow()[posEndfeld+3].add(frame.getFigurenYellow()[spieler.getSpielfigurNeu(k).getID()-1]);
						}
						frame.getFigurenYellow()[k].setVisible(true);
					}
					break;
				}
			}

		
		}

		if (EventSource == figurenRot[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenRot[0];
			}
		}

		if (EventSource == figurenRot[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenRot[1];
			}
		}

		if (EventSource == figurenRot[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenRot[2];
			}
		}

		if (EventSource == figurenRot[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.RED) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenRot[3];
			}
		}

		if (EventSource == figurenBlau[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenBlau[0];
			}
		}

		if (EventSource == figurenBlau[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenBlau[1];
			}
		}

		if (EventSource == figurenBlau[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenBlau[2];
			}
		}

		if (EventSource == figurenBlau[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.BLUE) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenBlau[3];
			}
		}

		if (EventSource == figurenGelb[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenGelb[0];
			}
		}

		if (EventSource == figurenGelb[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenGelb[1];
			}
		}

		if (EventSource == figurenGelb[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenGelb[2];
			}
		}

		if (EventSource == figurenGelb[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.YELLOW) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenGelb[3];
			}
		}

		if (EventSource == figurenGruen[0]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 1;
				aktuelleFigur = figurenGruen[0];
			}
		}

		if (EventSource == figurenGruen[1]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 2;
				aktuelleFigur = figurenGruen[1];
			}
		}

		if (EventSource == figurenGruen[2]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 3;
				aktuelleFigur = figurenGruen[2];
			}
		}

		if (EventSource == figurenGruen[3]) {
			if (lokalAmZug.getFarbe().equals(FarbEnum.GREEN) && lokalAmZug.getKi() == null) {
				frame.getZiehen().setEnabled(true);
				spielfigurID = 4;
				aktuelleFigur = figurenGruen[3];
			}
		}

		if (EventSource == buttonKiWeiter) {
			frame.getKiWeiter().setEnabled(false);
			if (sp.getAmZug().getWuerfel().getErgebnis() == 6) {
				sp.setAmZug(sp.getAmZug());
			} else {
				sp.setNaechster(sp.getAmZug());
			}
		}

		if (EventSource == ziehen) {
			frame.getS().zugDurchfuehren(spielfigurID);
			int newPos = lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getPosition();

			/*---Ins Endfeld laufen--*/
			switch (lokalAmZug.getSpielfigur(spielfigurID).getFarbe()) {
			case RED:
				if (lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")) {
					int posEndfeld = Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getRed()[posEndfeld + 3].add(aktuelleFigur);
				} else if (lokalAmZug.getSpielfigur(spielfigurID).istAufStartfeld() && lokalAmZug.getWuerfel().getErgebnis() != 6) {
					return;
				} else {
					frame.getFields()[newPos - 1].add(aktuelleFigur);
				}
				break;
			case BLUE:
				if (lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")) {
					int posEndfeld = Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getBlue()[posEndfeld + 3].add(aktuelleFigur);
				} else if (lokalAmZug.getSpielfigur(spielfigurID).istAufStartfeld() && lokalAmZug.getWuerfel().getErgebnis() != 6) {
					return;
				} else {
					frame.getFields()[newPos - 1].add(aktuelleFigur);
				}
				break;
			case GREEN:
				if (lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")) {
					int posEndfeld = Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getGreen()[posEndfeld + 3].add(aktuelleFigur);
				} else if (lokalAmZug.getSpielfigur(spielfigurID).istAufStartfeld() && lokalAmZug.getWuerfel().getErgebnis() != 6) {
					return;
				} else {
					frame.getFields()[newPos - 1].add(aktuelleFigur);
				}
				break;
			case YELLOW:
				if (lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().contains("E")) {
					int posEndfeld = Integer.parseInt(lokalAmZug.getSpielfigur(spielfigurID).getSpielfeld().getID().substring(1));
					frame.getYellow()[posEndfeld + 3].add(aktuelleFigur);
				} else if (lokalAmZug.getSpielfigur(spielfigurID).istAufStartfeld() && lokalAmZug.getWuerfel().getErgebnis() != 6) {
					return;
				} else {
					frame.getFields()[newPos - 1].add(aktuelleFigur);
				}
				break;
			}

			/*---Schmeissen--*/
			if (sp.getGeschmissen() != null) {
				switch (sp.getGeschmissen().getFarbe()) {
				case RED:
					if (sp.getGeschmissen().getSpielfeld().getID().contains("1")) {
						frame.getRed()[0].add(figurenRot[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("2")) {
						frame.getRed()[1].add(figurenRot[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("3")) {
						frame.getRed()[2].add(figurenRot[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("4")) {
						frame.getRed()[3].add(figurenRot[sp.getGeschmissen().getID() - 1]);
					}
					break;
				case BLUE:
					if (sp.getGeschmissen().getSpielfeld().getID().contains("1")) {
						frame.getBlue()[0].add(figurenBlau[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("2")) {
						frame.getBlue()[1].add(figurenBlau[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("3")) {
						frame.getBlue()[2].add(figurenBlau[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("4")) {
						frame.getBlue()[3].add(figurenBlau[sp.getGeschmissen().getID() - 1]);
					}
					break;
				case GREEN:
					if (sp.getGeschmissen().getSpielfeld().getID().contains("1")) {
						frame.getGreen()[0].add(figurenGruen[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("2")) {
						frame.getGreen()[1].add(figurenGruen[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("3")) {
						frame.getGreen()[2].add(figurenGruen[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("4")) {
						frame.getGreen()[3].add(figurenGruen[sp.getGeschmissen().getID() - 1]);
					}
					break;
				case YELLOW:
					if (sp.getGeschmissen().getSpielfeld().getID().contains("1")) {
						frame.getYellow()[0].add(figurenGelb[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("2")) {
						frame.getYellow()[1].add(figurenGelb[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("3")) {
						frame.getYellow()[2].add(figurenGelb[sp.getGeschmissen().getID() - 1]);
					} else if (sp.getGeschmissen().getSpielfeld().getID().contains("4")) {
						frame.getYellow()[3].add(figurenGelb[sp.getGeschmissen().getID() - 1]);
					}
					break;
				}

			}
//			System.out.println("geschmissen " + sp.getGeschmissen());

			frame.getpCen().repaint();
			ziehen.setEnabled(false);
			if (sp.getRegelwerk().getGewonnen()) {
				frame.gewonnenDialog();
			}

		}

		if (EventSource == aussetzen) {
			sp.setNaechster(sp.getAmZug());
		}
		
		if(EventSource == ButtonPDF){
			iDatenzugriff pdf = new DatenzugriffPDF();
			try {
				pdf.spielfeld(frame.getSpiel());
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Datein laden
	 */
	public Object laden(String dateiname, String dateieinde) {
		iBediener s = new SpielBean();
		return s.laden(dateiname, "");

	}

	public void actionPerformedNew(ActionEvent a_event2) {
		Object EventSourceNew = a_event2.getSource();
		if (EventSourceNew == ButtonSchliessen) {
			System.exit(0);
		}
	}

	@Override
	public void SpielerHinzufuegen(String name, String farbe, String ki) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initSpiel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void zugDurchfuehren(int ID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void zugDurchfuehrenSchmeissenTest(int ID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void zugDurchfuehrenEndfeldTest(int ID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initTestSpiel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initTestSpielZugAggressiv() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initTestSpielZugDefensiv() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Speichern(String dateiname, String dateiende) throws IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * "Spiel starten" Button ausgrauen falls kein Spieler
	 * eingegeben wurde
	 */
	@Override
	public void caretUpdate(CaretEvent e) {
		JTextField field = (JTextField) e.getSource();

		String text = field.getText();
		btn.setEnabled(!text.trim().isEmpty());
	}

	@Override
	public int getWuerfel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setIconBild(int erg) {
		// TODO Auto-generated method stub
		return 0;
	}

}
