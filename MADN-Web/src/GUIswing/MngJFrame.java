package GUIswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Backend.SpielBean;
import Backend.Spieler.Spielfigur;
import Interfaces.iBediener;


/**
 * Manager JFrame enthaelt gesamte GUI
 * 
 * @author Michi, Doerte, Tobi
 */
public class MngJFrame extends JFrame implements Serializable{

	private static final long serialVersionUID = 1L;
	private JButton start;
	private JButton laden;
	private JButton ueber;
	private JButton beenden;
	private JButton ok;
	private JButton ziehen;
	private JButton kiWeiter;
	private JButton aussetzen;
	private JButton speichern;
	private JButton wuerfel;
	private JTextArea ausgabe;
	private JFrame dialogfenster;
	private JTextField namen[];
	private JComboBox farbwahl[];
	private JComboBox kiwahl[];
	private JFrame fmSpiel;
	private JPanel mainPanel;
	private JPanel pCen;
	private JPanel[] red;
	private JPanel[] blue;
	private JPanel[] green;
	private JPanel[] yellow;
	private JPanel[] fields;
	private JButton[] figurenRed;
	private JButton[] figurenBlue;
	private JButton[] figurenGreen;
	private JButton[] figurenYellow;
	private JButton PDF;
	private JButton mail;
	private JFrame mailFrame;
	private JPanel mailPanel;
	private JTextField mailAn;
	private JButton[] mailAnhang;
	private JButton mailSenden;
	private JLabel anhang1;
	private JLabel anhang2;
	private JButton Hauptmenu;

	private eventHandling e;
	private iBediener s;

	
	public MngJFrame() {
		this.e = new eventHandling(this);
		setTitle("Mensch ärger dich nicht");
		initComponents();
		startFenster();
		this.e.setButtonBeenden(beenden);
		this.e.setButtonLaden(laden);
		this.e.setButtonStart(start);
		this.e.setButtonUeber(ueber);
		this.e.setButtonOk(ok);
		this.e.setButtonWuerfel(wuerfel);
		
		s = new SpielBean(this);
	}

	/**
	 * initialisiert alle Komponenten
	 */
	private void initComponents() {
		ausgabe = new JTextArea(6, 0);
		start = new JButton("Start");
		laden = new JButton("Laden");
		beenden = new JButton("Beenden");
		ueber = new JButton("Ueber");
		ok = new JButton("Spiel starten");
		wuerfel = new JButton();
		ziehen = new JButton("Ziehen");
		kiWeiter = new JButton("KI Weiter");
		kiWeiter.setEnabled(false);
		aussetzen = new JButton("aussetzen");
		speichern= new JButton ("speichern");
		dialogfenster = new JFrame("Startfenster");
		namen = new JTextField[4];
		farbwahl = new JComboBox[4];
		kiwahl = new JComboBox[4];
		fmSpiel = new JFrame();
		mainPanel = new JPanel();
		pCen = new JPanel();
		red = new JPanel[8];
		blue = new JPanel[8];
		green = new JPanel[8];
		yellow = new JPanel[8];
		fields = new JPanel[40];
		figurenRed = new JButton[4];
		figurenBlue = new JButton[4];
		figurenGreen = new JButton[4];
		figurenYellow = new JButton[4];
		PDF = new JButton("PDF speichern");
		mail = new JButton("Mail senden");
		mailFrame = new JFrame();
		mailPanel = new JPanel();
		mailAn = new JTextField("E-Mail-Adresse");
		mailAnhang = new JButton[2];
		mailAnhang[0] = new JButton("Spielstand.ser hinzufuegen");
		mailAnhang[1] = new JButton("Spielstand.pdf hinzufuegen");
		mailSenden = new JButton("Senden");
		anhang1 = new JLabel("Anhang 1: ---");
		anhang2 = new JLabel("Anhang 2: ---");
		
		for (int i = 0; i < 8; i++) {
			red[i] = new JPanel();
			red[i].setBackground(Color.RED);
			red[i].setLayout(null);
			blue[i] = new JPanel();
			blue[i].setBackground(Color.BLUE);
			blue[i].setLayout(null);
			green[i] = new JPanel();
			green[i].setBackground(Color.GREEN);
			green[i].setLayout(null);
			yellow[i] = new JPanel();
			yellow[i].setBackground(Color.YELLOW);
			yellow[i].setLayout(null);
			pCen.add(red[i]);
			pCen.add(blue[i]);
			pCen.add(green[i]);
			pCen.add(yellow[i]);
		}
		for (int i = 0; i < 40; i++) {
			fields[i] = new JPanel();
			fields[i].setBackground(Color.DARK_GRAY);
			fields[i].setLayout(null);
			pCen.add(fields[i]);
		}
		figurenSetzen();
		
	}

	/**
	 * Oeffnet erstes Startfenster zur bedienung des Spiels
	 */
	private void startFenster() {
//		initStartBild();
		setTitle("Mensch aergere dich nicht");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());


		start.addActionListener(e);
		laden.addActionListener(e);
		beenden.addActionListener(e);
		ueber.addActionListener(e);

		panel3.add(start, BorderLayout.CENTER);
		panel3.add(laden, BorderLayout.CENTER);
		panel3.add(beenden, BorderLayout.CENTER);
		panel3.add(ueber, BorderLayout.CENTER);
		getContentPane().add(panel3, BorderLayout.PAGE_END);
	}

	public void setS(iBediener s) {
		this.s = s;
	}

	/**
	 * Initialisiert Startbild im Startfenster
	 */
	private void initStartBild(){
		setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;
			private Image img;
			{

				img = getToolkit().createImage("bilder/bgBild.jpg");

				MediaTracker mt = new MediaTracker(this);
				mt.addImage(img, 1);
				try {
					mt.waitForAll();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			protected void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		});
	}

	/**
	 * Dialogfenster zum anlegen der Spieler
	 * und des Spiels
	 */
	public void dialogFenster() {

		JPanel panel = new JPanel();
		dialogfenster.setSize(500, 500);
		dialogfenster.add(panel);
		panel.setLayout(new GridLayout(6, 3));

		JLabel name = new JLabel("Name");
		JLabel farbe = new JLabel("Farbe");
		JLabel ki1 = new JLabel("KI/Mensch");
		panel.add(name);
		panel.add(farbe);
		panel.add(ki1);
		// panel.add(ki2);
		
		
		ok.setEnabled(false);

		String f[] = { "Red", "Yellow", "Blue", "Green" };
		String k[] = { "Mensch", "KI Aggressiv", "KI Defensiv" };
		for (int i = 0; i < namen.length; i++) {
			namen[i] = new JTextField();
			namen[i].addCaretListener(new eventHandling(ok));
			panel.add(namen[i]);
			farbwahl[i] = new JComboBox(f);
			panel.add(farbwahl[i]);

			kiwahl[i] = new JComboBox(k);
			panel.add(kiwahl[i]);
		}

		panel.add(ok);
		ok.addActionListener(e);
		e.setButtonOk(ok);

		dialogfenster.setAlwaysOnTop(true);
		dialogfenster.setContentPane(panel);
		dialogfenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.paintComponents(panel.getGraphics());
		dialogfenster.setVisible(true);
		dialogfenster.pack();
	}

	
	/**
	 * Oeffnet das Spielbrett mit allen notwendigen Elementen
	 */
	public void spielFenster() {
		fmSpiel.add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(pCen, BorderLayout.CENTER);
		pCen.setLayout(null);
		pCen.setBackground(Color.WHITE);


		/* Spielfeld aus JPanel */

		for (int i = 0; i < 8; i++) {
			pCen.add(red[i]);
			pCen.add(blue[i]);
			pCen.add(green[i]);
			pCen.add(yellow[i]);
		}

		red[0].setBounds(20, 20, 30, 30);
		red[1].setBounds(70, 20, 30, 30);
		red[2].setBounds(20, 70, 30, 30);
		red[3].setBounds(70, 70, 30, 30);
		red[4].setBounds(70, 270, 30, 30);
		red[5].setBounds(120, 270, 30, 30);
		red[6].setBounds(170, 270, 30, 30);
		red[7].setBounds(220, 270, 30, 30);

		blue[0].setBounds(470, 20, 30, 30);
		blue[1].setBounds(520, 20, 30, 30);
		blue[2].setBounds(470, 70, 30, 30);
		blue[3].setBounds(520, 70, 30, 30);
		blue[4].setBounds(270, 70, 30, 30);
		blue[5].setBounds(270, 120, 30, 30);
		blue[6].setBounds(270, 170, 30, 30);
		blue[7].setBounds(270, 220, 30, 30);

		green[0].setBounds(470, 470, 30, 30);
		green[1].setBounds(520, 470, 30, 30);
		green[2].setBounds(470, 520, 30, 30);
		green[3].setBounds(520, 520, 30, 30);
		green[4].setBounds(470, 270, 30, 30);
		green[5].setBounds(420, 270, 30, 30);
		green[6].setBounds(370, 270, 30, 30);
		green[7].setBounds(320, 270, 30, 30);

		yellow[0].setBounds(20, 470, 30, 30);
		yellow[1].setBounds(70, 470, 30, 30);
		yellow[2].setBounds(20, 520, 30, 30);
		yellow[3].setBounds(70, 520, 30, 30);
		yellow[4].setBounds(270, 470, 30, 30);
		yellow[5].setBounds(270, 420, 30, 30);
		yellow[6].setBounds(270, 370, 30, 30);
		yellow[7].setBounds(270, 320, 30, 30);

		fields[0].setBounds(20, 220, 30, 30);
		fields[1].setBounds(70, 220, 30, 30);
		fields[2].setBounds(120, 220, 30, 30);
		fields[3].setBounds(170, 220, 30, 30);
		fields[4].setBounds(220, 220, 30, 30);

		fields[5].setBounds(220, 170, 30, 30);
		fields[6].setBounds(220, 120, 30, 30);
		fields[7].setBounds(220, 70, 30, 30);
		fields[8].setBounds(220, 20, 30, 30);

		fields[9].setBounds(270, 20, 30, 30);
		fields[10].setBounds(320, 20, 30, 30);

		fields[11].setBounds(320, 70, 30, 30);
		fields[12].setBounds(320, 120, 30, 30);
		fields[13].setBounds(320, 170, 30, 30);
		fields[14].setBounds(320, 220, 30, 30);

		fields[15].setBounds(370, 220, 30, 30);
		fields[16].setBounds(420, 220, 30, 30);
		fields[17].setBounds(470, 220, 30, 30);
		fields[18].setBounds(520, 220, 30, 30);

		fields[19].setBounds(520, 270, 30, 30);
		fields[20].setBounds(520, 320, 30, 30);

		fields[21].setBounds(470, 320, 30, 30);
		fields[22].setBounds(420, 320, 30, 30);
		fields[23].setBounds(370, 320, 30, 30);
		fields[24].setBounds(320, 320, 30, 30);

		fields[25].setBounds(320, 370, 30, 30);
		fields[26].setBounds(320, 420, 30, 30);
		fields[27].setBounds(320, 470, 30, 30);
		fields[28].setBounds(320, 520, 30, 30);

		fields[29].setBounds(270, 520, 30, 30);
		fields[30].setBounds(220, 520, 30, 30);

		fields[31].setBounds(220, 470, 30, 30);
		fields[32].setBounds(220, 420, 30, 30);
		fields[33].setBounds(220, 370, 30, 30);
		fields[34].setBounds(220, 320, 30, 30);

		fields[35].setBounds(170, 320, 30, 30);
		fields[36].setBounds(120, 320, 30, 30);
		fields[37].setBounds(70, 320, 30, 30);
		fields[38].setBounds(20, 320, 30, 30);
		fields[39].setBounds(20, 270, 30, 30);

		
		ausgabe.setEditable(false);
		mainPanel.add(new JScrollPane(ausgabe), BorderLayout.SOUTH);

		
		JPanel pWest = new JPanel();
		pWest.setLayout(new BorderLayout());
		
		wuerfel.setSize(100,100);
		pWest.add(wuerfel);
		
		
		mainPanel.add(pWest, BorderLayout.WEST);

		JPanel pEast = new JPanel();
		pEast.setLayout(new GridLayout(6,1));
		
		ziehen.setEnabled(false);
		pEast.add(ziehen);
		
		kiWeiter.addActionListener(e);
		e.setButtonKiWeiter(kiWeiter);
		pEast.add(kiWeiter);
		
		
		aussetzen.setEnabled(true);
		aussetzen.addActionListener(e);
		e.setButtonAussetzen(aussetzen);
		pEast.add(aussetzen);
		
		speichern.setEnabled(true);
		speichern.addActionListener(e);
		e.setButtonSpeichern(speichern);
		pEast.add(speichern);
		
		PDF.setEnabled(true);
		PDF.addActionListener(e);
		e.setButtonPDF(PDF);
		pEast.add(PDF);
		
		mail.setEnabled(true);
		mail.addActionListener(e);
		pEast.add(mail);
		
//		Hauptmenu.setEnabled(true);
//		Hauptmenu.addActionListener(e);
//		e.setButtonHauptmenu(Hauptmenu);
//		pEast.add(Hauptmenu);
		
		mainPanel.add(pEast, BorderLayout.EAST);
		ziehen.addActionListener(e);
		e.setButtonZiehen(ziehen);

		fmSpiel.setSize(820, 690);
		fmSpiel.setResizable(false);
		fmSpiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fmSpiel.setVisible(true);
	}
	
	/**
	 * Erstellt das Wuerfelergebnis als JButton mit Bild
	 * @param erg Wuerfelergebnis
	 */
	public void setIconNeu(int erg){
		ImageIcon erg1 = new ImageIcon("bilder/erg1.png");
		ImageIcon erg2 = new ImageIcon("bilder/erg2.png");
		ImageIcon erg3 = new ImageIcon("bilder/erg3.png");
		ImageIcon erg4 = new ImageIcon("bilder/erg4.png");
		ImageIcon erg5 = new ImageIcon("bilder/erg5.png");
		ImageIcon erg6 = new ImageIcon("bilder/erg6.png");
		if(erg==1){
			wuerfel.setIcon(erg1);
			wuerfel.repaint();
		}
		if(erg==2){
			wuerfel.setIcon(erg2);
			wuerfel.repaint();
		}
		if(erg==3){
			wuerfel.setIcon(erg3);
			wuerfel.repaint();
		}
		if(erg==4){
			wuerfel.setIcon(erg4);
			wuerfel.repaint();
		}
		if(erg==5){
			wuerfel.setIcon(erg5);
			wuerfel.repaint();
		}
		if(erg==6){
			wuerfel.setIcon(erg6);
			wuerfel.repaint();
		}
	}
	


	public static void main(String[] args) {

		MngJFrame main = new MngJFrame();
		main.setVisible(true);

	}

	/**
	 * Setzt Spielfiguren die benoetigt werden sichtbar
	 * @param farbe Spielerfarbe
	 */
	public void figurButton(String farbe) {
		farbe=farbe.toUpperCase();
		switch (farbe) {
		case "RED":
			for (int i = 0; i < 4; i++) {
				figurenRed[i].setVisible(true);
			}
			break;

		case "BLUE":
			for (int i = 0; i < 4; i++) {
				figurenBlue[i].setVisible(true);
			}
			break;

		case "GREEN":
			for (int i = 0; i < 4; i++) {
				figurenGreen[i].setVisible(true);
			}
			break;
		case "YELLOW":
			for (int i = 0; i < 4; i++) {
				figurenYellow[i].setVisible(true);
			}
			break;
		}
	}
	
	/**
	 * setzt alle Spielfiguren auf ihre Startposition
	 */
	public void figurenSetzen(){
		for (int i = 0; i < 4; i++) {
			figurenRed[i] = new JButton("" + (i + 1));
			figurenRed[i].setSize(30, 30);
			figurenRed[i].setForeground(Color.RED);
			red[i].add(figurenRed[i]);
			figurenRed[i].addActionListener(e);
			e.setFigurenRot(figurenRed);
			figurenRed[i].setVisible(false);
			
			figurenBlue[i] = new JButton("" + (i + 1));
			figurenBlue[i].setSize(30, 30);
			figurenBlue[i].setForeground(Color.BLUE);
			blue[i].add(figurenBlue[i]);
			figurenBlue[i].addActionListener(e);
			e.setFigurenBlau(figurenBlue);
			figurenBlue[i].setVisible(false);
			
			figurenGreen[i] = new JButton("" + (i + 1));
			figurenGreen[i].setSize(30, 30);
			figurenGreen[i].setForeground(Color.GREEN);
			green[i].add(figurenGreen[i]);
			figurenGreen[i].addActionListener(e);
			e.setFigurenGruen(figurenGreen);
			figurenGreen[i].setVisible(false);
			
			figurenYellow[i] = new JButton("" + (i + 1));
			figurenYellow[i].setSize(30, 30);
			figurenYellow[i].setForeground(Color.YELLOW);
			yellow[i].add(figurenYellow[i]);
			figurenYellow[i].addActionListener(e);
			e.setFigurenGelb(figurenYellow);
			figurenYellow[i].setVisible(false);
		}
	}
	
	
	/**
	 * Aktualisiert die Spielfigur der gezogenen KI
	 * auf dem Spielfeld
	 * @param spielfigur gezogene Spielfigur
	 */
	public void KIFigurenZiehen(Spielfigur spielfigur){
		int newPos=spielfigur.getSpielfeld().getPosition();
		SpielBean spiel = (SpielBean) s;

		

		switch(spielfigur.getFarbe()){
		case RED:
			if(spielfigur.getSpielfeld().getID().contains("E")){
				int posEndfeld=Integer.parseInt(spielfigur.getSpielfeld().getID().substring(1));
				red[posEndfeld+3].add(figurenRed[spielfigur.getID()-1]);
				pCen.repaint();
				return;
			}
			fields[newPos-1].add(figurenRed[spielfigur.getID()-1]);
			break;
		case BLUE:
			if(spielfigur.getSpielfeld().getID().contains("E")){
				int posEndfeld=Integer.parseInt(spielfigur.getSpielfeld().getID().substring(1));
				blue[posEndfeld+3].add(figurenBlue[spielfigur.getID()-1]);
				pCen.repaint();
				return;
			}
			fields[newPos-1].add(figurenBlue[spielfigur.getID()-1]);
			break;
		case GREEN:
			if(spielfigur.getSpielfeld().getID().contains("E")){
				int posEndfeld=Integer.parseInt(spielfigur.getSpielfeld().getID().substring(1));
				green[posEndfeld+3].add(figurenGreen[spielfigur.getID()-1]);
				pCen.repaint();
				return;
			}
			fields[newPos-1].add(figurenGreen[spielfigur.getID()-1]);
			break;
		case YELLOW:
			if(spielfigur.getSpielfeld().getID().contains("E")){
				int posEndfeld=Integer.parseInt(spielfigur.getSpielfeld().getID().substring(1));
				yellow[posEndfeld+3].add(figurenYellow[spielfigur.getID()-1]);
				pCen.repaint();
				return;
			}
			fields[newPos-1].add(figurenYellow[spielfigur.getID()-1]);
			break;
		}
	
		if(spiel.getGeschmissen() != null){
			switch(spiel.getGeschmissen().getFarbe()){
			case RED:
				if(spiel.getGeschmissen().getSpielfeld().getID().contains("1")){
					red[0].add(figurenRed[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("2")){
					red[1].add(figurenRed[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("3")){
					red[2].add(figurenRed[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("4")){
					red[3].add(figurenRed[spiel.getGeschmissen().getID()-1]);
				}
				break;
			case BLUE:
				if(spiel.getGeschmissen().getSpielfeld().getID().contains("1")){
					blue[0].add(figurenBlue[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("2")){
					blue[1].add(figurenBlue[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("3")){
					blue[2].add(figurenBlue[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("4")){
					blue[3].add(figurenBlue[spiel.getGeschmissen().getID()-1]);
				}
				break;
			case GREEN:
				if(spiel.getGeschmissen().getSpielfeld().getID().contains("1")){
					green[0].add(figurenGreen[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("2")){
					green[1].add(figurenGreen[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("3")){
					green[2].add(figurenGreen[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("4")){
					green[3].add(figurenGreen[spiel.getGeschmissen().getID()-1]);
				}
				break;
			case YELLOW:
				if(spiel.getGeschmissen().getSpielfeld().getID().contains("1")){
					yellow[0].add(figurenYellow[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("2")){
					yellow[1].add(figurenYellow[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("3")){
					yellow[2].add(figurenYellow[spiel.getGeschmissen().getID()-1]);
				}else if(spiel.getGeschmissen().getSpielfeld().getID().contains("4")){
					yellow[3].add(figurenYellow[spiel.getGeschmissen().getID()-1]);
				}
				break;
			}
		}
		
		pCen.repaint();
	}
	
	/**
	 * Zeigt ein gewonnen-Dialogfenster an
	 */
	public void gewonnenDialog(){
		JOptionPane.showMessageDialog(null, "gewonnen", "Gewonnen", JOptionPane.INFORMATION_MESSAGE, null);
	}
	
	/**
	 * Zeigt Dialogfenster zum vermeiden von doppelten farben
	 */
	public void gleicheFarbeDialog(){
		JOptionPane.showMessageDialog(null,"Keine doppelten Farben erlaubt!", "Warnung", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Oeffnet neues Fenster fuer Mailversand
	 */
	public void mailFenster(){
		mailFrame.add(mailPanel);
		mailPanel.setLayout(new GridLayout(6,1));
		mailPanel.add(mailAn);
		mailPanel.add(mailAnhang[0]);
		mailPanel.add(mailAnhang[1]);
		mailPanel.add(anhang1);
		mailPanel.add(anhang2);
		mailPanel.add(mailSenden);
		
		mailAnhang[0].addActionListener(e);
		mailAnhang[1].addActionListener(e);
		mailSenden.addActionListener(e);
		
		mailFrame.setAlwaysOnTop(true);
		mailFrame.setVisible(true);
		mailFrame.pack();
		mailFrame.setResizable(false);
	}
	

	public JButton getZiehen() {
		return ziehen;
	}
	
	public JButton getKiWeiter() {
		return kiWeiter;
	}

	public JFrame getDialogFenster() {
		return dialogfenster;
	}

	public JTextField[] getNamen() {
		return namen;
	}

	public JComboBox[] getFarbe() {
		return farbwahl;
	}

	public JComboBox[] getKI() {
		return kiwahl;
	}

	public SpielBean getSpiel() {
		return (SpielBean) s;
	}

	public JTextArea getAusgabe() {
		return ausgabe;
	}

	public JPanel[] getBlue() {
		return blue;
	}

	public JPanel[] getGreen() {
		return green;
	}

	public JPanel[] getYellow() {
		return yellow;
	}

	public JPanel getpCen() {
		return pCen;
	}

	public JButton[] getFigurenBlue() {
		return figurenBlue;
	}

	public JButton[] getFigurenGreen() {
		return figurenGreen;
	}

	public JButton[] getFigurenYellow() {
		return figurenYellow;
	}

	public iBediener getS() {
		return s;
	}

	public JPanel[] getFields() {
		return fields;
	}

	public JButton[] getFigurenRed() {
		return figurenRed;
	}
	public JButton getAussetzen() {
		return aussetzen;
	}
	public JPanel[] getRed() {
		return red;
	}

	public JButton getPDF() {
		return PDF;
	}

	public JButton getMail() {
		return mail;
	}
	public JTextField getMailAn() {
		return mailAn;
	}

	public JButton[] getMailAnhang() {
		return mailAnhang;
	}

	public JButton getMailSenden() {
		return mailSenden;
	}

	public JLabel getAnhang1() {
		return anhang1;
	}

	public JLabel getAnhang2() {
		return anhang2;
	}

	public JFrame getMailFrame() {
		return mailFrame;
	}
}
