package Backend;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import Interfaces.iDatenzugriff;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DatenzugriffPDF implements iDatenzugriff, Serializable {

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;









	@Override
	public  void spielfeld(SpielBean spiel) throws FileNotFoundException, DocumentException {
		
		Rectangle pageSize = new Rectangle(216f, 720f);

		Document document = new Document(pageSize, 36f, 72f, 108f, 180f);

		PdfWriter.getInstance(document, new FileOutputStream("Spielstand.pdf"));
		document.open();

		PdfPTable table1 = new PdfPTable(1);
		table1.addCell("Spielstand");

		PdfPTable table = new PdfPTable(11);
		table.setWidthPercentage(1000 / 6.23f);

		PdfPCell cell;

		for (int i = 1; i < 122; i++) {
			cell = new PdfPCell(new Phrase(" "));

			if ((i == 1)) {
				 if (spiel.getBrett().getSpielbrett()[0].getFelder()[1]
							.getSpielfigur() != null) {
					 cell = new PdfPCell(new Phrase(" "));
						cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						
						table.addCell(cell);
						}else{
							cell.setBackgroundColor(BaseColor.RED);
							table.addCell(cell);
							
						}
			} else if (i == 12){
				 if (spiel.getBrett().getSpielbrett()[0].getFelder()[2]
							.getSpielfigur() != null) {
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						
						table.addCell(cell);
						}else{
							cell.setBackgroundColor(BaseColor.RED);
							table.addCell(cell);
							
						}
			}else if (i == 13) {
				 if (spiel.getBrett().getSpielbrett()[0].getFelder()[3]
							.getSpielfigur() != null) {
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						}else{
							cell.setBackgroundColor(BaseColor.RED);
							table.addCell(cell);
							
						}
			}else if (i==2) {
				 if (spiel.getBrett().getSpielbrett()[0].getFelder()[4]
							.getSpielfigur() != null) {
					 	cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						}else{
							cell.setBackgroundColor(BaseColor.RED);
							table.addCell(cell);
							
						}
				 
		}else if(i==60){
			 if (spiel.getBrett().getSpielbrett()[39].getFelder()[1]
						.getSpielfigur() != null) {
				 cell.setBorderWidth(2f);
					cell.setBorderColor(BaseColor.RED);
					table.addCell(cell);
					}else{
						cell.setBackgroundColor(BaseColor.RED);
						table.addCell(cell);
						
					}
		}else if(i==59){
			 if (spiel.getBrett().getSpielbrett()[39].getFelder()[2]
						.getSpielfigur() != null) {
				 cell.setBorderWidth(2f);
					cell.setBorderColor(BaseColor.RED);
					table.addCell(cell);
					}else{
						cell.setBackgroundColor(BaseColor.RED);
						table.addCell(cell);
						
					}
		}else if(i==58){
			 if (spiel.getBrett().getSpielbrett()[39].getFelder()[3]
						.getSpielfigur() != null) {
				 cell.setBorderWidth(2f);
					cell.setBorderColor(BaseColor.RED);
					table.addCell(cell);
					}else{
						cell.setBackgroundColor(BaseColor.RED);
						table.addCell(cell);
						
					}
		}else if(i==57){
			 if (spiel.getBrett().getSpielbrett()[39].getFelder()[4]
						.getSpielfigur() != null) {
				 cell.setBorderWidth(2f);
					cell.setBorderColor(BaseColor.RED);
					table.addCell(cell);
					}else{
						cell.setBackgroundColor(BaseColor.RED);
						table.addCell(cell);
						
					} 
			 
		}else if(i==45){
				 if (spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[0].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
		}else if(i==46){
					 if (spiel.getBrett().getSpielbrett()[1].getFelder()[0].getSpielfigur() != null) {
						 switch(spiel.getBrett().getSpielbrett()[1].getFelder()[0].getSpielfigur().getFarbe()){
						 case RED:
							 	cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.RED);
								table.addCell(cell);
								break;
								
						 case GREEN:	
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.GREEN);
								table.addCell(cell);
								break;
						 case BLUE:
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.BLUE);
								table.addCell(cell);
								break;
						 case YELLOW:
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.YELLOW);
								table.addCell(cell);
								break;
						 }
							}else{
								cell.setBackgroundColor(BaseColor.DARK_GRAY);
								table.addCell(cell);
								
							}
		}else if(i==47){
			 if (spiel.getBrett().getSpielbrett()[2].getFelder()[0].getSpielfigur() != null) {
				 switch(spiel.getBrett().getSpielbrett()[2].getFelder()[0].getSpielfigur().getFarbe()){
				 case RED:
					 	cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						break;
						
				 case GREEN:	
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.GREEN);
						table.addCell(cell);
						break;
				 case BLUE:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.BLUE);
						table.addCell(cell);
						break;
				 case YELLOW:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.YELLOW);
						table.addCell(cell);
						break;
				 }
					}else{
						cell.setBackgroundColor(BaseColor.DARK_GRAY);
						table.addCell(cell);
						
					}
		}else if(i==48){
			 if (spiel.getBrett().getSpielbrett()[3].getFelder()[0].getSpielfigur() != null) {
				 switch(spiel.getBrett().getSpielbrett()[3].getFelder()[0].getSpielfigur().getFarbe()){
				 case RED:
					 	cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						break;
						
				 case GREEN:	
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.GREEN);
						table.addCell(cell);
						break;
				 case BLUE:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.BLUE);
						table.addCell(cell);
						break;
				 case YELLOW:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.YELLOW);
						table.addCell(cell);
						break;
				 }
					}else{
						cell.setBackgroundColor(BaseColor.DARK_GRAY);
						table.addCell(cell);
						
					}
		}else if(i==49){
			 if (spiel.getBrett().getSpielbrett()[4].getFelder()[0].getSpielfigur() != null) {
				 switch(spiel.getBrett().getSpielbrett()[4].getFelder()[0].getSpielfigur().getFarbe()){
				 case RED:
					 	cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						break;
						
				 case GREEN:	
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.GREEN);
						table.addCell(cell);
						break;
				 case BLUE:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.BLUE);
						table.addCell(cell);
						break;
				 case YELLOW:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.YELLOW);
						table.addCell(cell);
						break;
				 }
					}else{
						cell.setBackgroundColor(BaseColor.DARK_GRAY);
						table.addCell(cell);
						
					}
		}else if(i==38){
			 if (spiel.getBrett().getSpielbrett()[5].getFelder()[0].getSpielfigur() != null) {
				 switch(spiel.getBrett().getSpielbrett()[5].getFelder()[0].getSpielfigur().getFarbe()){
				 case RED:
					 	cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						break;
						
				 case GREEN:	
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.GREEN);
						table.addCell(cell);
						break;
				 case BLUE:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.BLUE);
						table.addCell(cell);
						break;
				 case YELLOW:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.YELLOW);
						table.addCell(cell);
						break;
				 }
					}else{
						cell.setBackgroundColor(BaseColor.DARK_GRAY);
						table.addCell(cell);
						
					}
		}else if(i==27){
			 if(spiel.getBrett().getSpielbrett()[6].getFelder()[0].getSpielfigur() != null){
				 switch(spiel.getBrett().getSpielbrett()[6].getFelder()[0].getSpielfigur().getFarbe()){
				 case RED:
					 	cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.RED);
						table.addCell(cell);
						break;
						
				 case GREEN:	
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.GREEN);
						table.addCell(cell);
						break;
				 case BLUE:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.BLUE);
						table.addCell(cell);
						break;
				 case YELLOW:
					 cell.setBorderWidth(2f);
						cell.setBorderColor(BaseColor.YELLOW);
						table.addCell(cell);
						break;
				 }
					}else{
						cell.setBackgroundColor(BaseColor.DARK_GRAY);
						table.addCell(cell);
						
					}
			 }else if(i==16){
						 if (spiel.getBrett().getSpielbrett()[7].getFelder()[0].getSpielfigur() != null) {
							 switch(spiel.getBrett().getSpielbrett()[7].getFelder()[0].getSpielfigur().getFarbe()){
							 case RED:
								 	cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.RED);
									table.addCell(cell);
									break;
									
							 case GREEN:	
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.GREEN);
									table.addCell(cell);
									break;
							 case BLUE:
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.BLUE);
									table.addCell(cell);
									break;
							 case YELLOW:
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.YELLOW);
									table.addCell(cell);
									break;
							 }
								}else{
									cell.setBackgroundColor(BaseColor.DARK_GRAY);
									table.addCell(cell);
									
								}
			 }else if(i==5){
				 if (spiel.getBrett().getSpielbrett()[8].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[8].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==6){
				 if (spiel.getBrett().getSpielbrett()[9].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[9].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==7){
				 if (spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[10].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==18){
				 if (spiel.getBrett().getSpielbrett()[11].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[11].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==29){
				 if (spiel.getBrett().getSpielbrett()[12].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[12].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==40){
				 if (spiel.getBrett().getSpielbrett()[13].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[13].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==51){
				 if (spiel.getBrett().getSpielbrett()[14].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[14].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==52){
				 if (spiel.getBrett().getSpielbrett()[15].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[15].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==53){
				 if (spiel.getBrett().getSpielbrett()[16].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[16].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==54){
				 if (spiel.getBrett().getSpielbrett()[17].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[17].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==55){
				 if (spiel.getBrett().getSpielbrett()[18].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[18].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==66){
				 if (spiel.getBrett().getSpielbrett()[19].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[19].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==77){
				 if (spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[20].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==76){
				 if (spiel.getBrett().getSpielbrett()[21].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[21].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==75){
				 if (spiel.getBrett().getSpielbrett()[22].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[22].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==74){
				 if (spiel.getBrett().getSpielbrett()[23].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[23].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==73){
				 if (spiel.getBrett().getSpielbrett()[24].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[24].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==84){
				 if (spiel.getBrett().getSpielbrett()[25].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[25].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==95){
				 if (spiel.getBrett().getSpielbrett()[26].getFelder()[0].getSpielfigur() != null) {
							switch(spiel.getBrett().getSpielbrett()[26].getFelder()[0].getSpielfigur().getFarbe()){
							 case RED:
								 	cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.RED);
									table.addCell(cell);
									break;
									
							 case GREEN:	
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.GREEN);
									table.addCell(cell);
									break;
							 case BLUE:
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.BLUE);
									table.addCell(cell);
									break;
							 case YELLOW:
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.YELLOW);
									table.addCell(cell);
									break;
							 }}else{
									cell.setBackgroundColor(BaseColor.DARK_GRAY);
									table.addCell(cell);
						}
			 }else if(i==106){
				 if(spiel.getBrett().getSpielbrett()[27].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[27].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			
			 }else if(i==117){
				 if (spiel.getBrett().getSpielbrett()[28].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[28].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==116){
				 if (spiel.getBrett().getSpielbrett()[29].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[29].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==115){
				 if (spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[30].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==104){
				 if (spiel.getBrett().getSpielbrett()[31].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[31].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==93){
				 if (spiel.getBrett().getSpielbrett()[32].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[32].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==82){
				 if (spiel.getBrett().getSpielbrett()[33].getFelder()[0].getSpielfigur() != null){
					 switch(spiel.getBrett().getSpielbrett()[33].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==71){
				 if (spiel.getBrett().getSpielbrett()[34].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[34].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==70){
				 if (spiel.getBrett().getSpielbrett()[35].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[35].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==69){
				 if (spiel.getBrett().getSpielbrett()[36].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[36].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==68){
				 if(spiel.getBrett().getSpielbrett()[37].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[37].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==67){
				 if (spiel.getBrett().getSpielbrett()[38].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[38].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
			 }else if(i==56){
				 if(spiel.getBrett().getSpielbrett()[39].getFelder()[0].getSpielfigur() != null) {
					 switch(spiel.getBrett().getSpielbrett()[39].getFelder()[0].getSpielfigur().getFarbe()){
					 case RED:
						 	cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.RED);
							table.addCell(cell);
							break;
							
					 case GREEN:	
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.GREEN);
							table.addCell(cell);
							break;
					 case BLUE:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.BLUE);
							table.addCell(cell);
							break;
					 case YELLOW:
						 cell.setBorderWidth(2f);
							cell.setBorderColor(BaseColor.YELLOW);
							table.addCell(cell);
							break;
					 }
						}else{
							cell.setBackgroundColor(BaseColor.DARK_GRAY);
							table.addCell(cell);
							
						}
		
						} else if ((i == 10)) {
							 if (spiel.getBrett().getSpielbrett()[10].getFelder()[1]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.BLUE);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.BLUE);
										table.addCell(cell);
										
									}
						} else if (i == 11){
							 if (spiel.getBrett().getSpielbrett()[10].getFelder()[2]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.BLUE);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.BLUE);
										table.addCell(cell);
										
									}
						}else if (i == 17) {
							 if (spiel.getBrett().getSpielbrett()[9].getFelder()[1]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.BLUE);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.BLUE);
										table.addCell(cell);
										
									}
						}else if (i==21) {
							 if (spiel.getBrett().getSpielbrett()[10].getFelder()[3]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.BLUE);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.BLUE);
										table.addCell(cell);
										
									}
							 
					}else if(i==22){
						 if (spiel.getBrett().getSpielbrett()[10].getFelder()[4]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.BLUE);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.BLUE);
									table.addCell(cell);
									
								}
					}else if(i==28){
						 if (spiel.getBrett().getSpielbrett()[9].getFelder()[2]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.BLUE);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.BLUE);
									table.addCell(cell);
									
								}
					}else if(i==39){
						 if (spiel.getBrett().getSpielbrett()[9].getFelder()[3]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.BLUE);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.BLUE);
									table.addCell(cell);
									
								}
					}else if(i==50){
						 if (spiel.getBrett().getSpielbrett()[9].getFelder()[4]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.BLUE);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.BLUE);
									table.addCell(cell);
									
								}
							
						} else if ((i == 110)) {
							 if (spiel.getBrett().getSpielbrett()[20].getFelder()[1]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.GREEN);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.GREEN);
										table.addCell(cell);
										
									}
						} else if (i == 109){
							 if (spiel.getBrett().getSpielbrett()[20].getFelder()[2]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.GREEN);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.GREEN);
										table.addCell(cell);
										
									}
						}else if (i == 121) {
							 if (spiel.getBrett().getSpielbrett()[20].getFelder()[3]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.GREEN);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.GREEN);
										table.addCell(cell);
										
									}
						}else if (i==120) {
							 if (spiel.getBrett().getSpielbrett()[20].getFelder()[4]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.GREEN);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.GREEN);
										table.addCell(cell);
										
									}
							 
					}else if(i==65){
						 if (spiel.getBrett().getSpielbrett()[19].getFelder()[1]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.GREEN);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.GREEN);
									table.addCell(cell);
									
								}
					}else if(i==64){
						 if (spiel.getBrett().getSpielbrett()[19].getFelder()[2]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.GREEN);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.GREEN);
									table.addCell(cell);
									
								}
					}else if(i==63){
						 if (spiel.getBrett().getSpielbrett()[19].getFelder()[3]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.GREEN);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.GREEN);
									table.addCell(cell);
									
								}
					}else if(i==62){
						 if (spiel.getBrett().getSpielbrett()[19].getFelder()[4]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.GREEN);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.GREEN);
									table.addCell(cell);
									
								}
							
							
							

						}else if (i == 100) {
							 if (spiel.getBrett().getSpielbrett()[30].getFelder()[1]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.YELLOW);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.YELLOW);
										table.addCell(cell);
										
									}
						} else if (i == 101){
							 if (spiel.getBrett().getSpielbrett()[30].getFelder()[2]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.YELLOW);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.YELLOW);
										table.addCell(cell);
										
									}
						}else if (i == 111) {
							 if (spiel.getBrett().getSpielbrett()[30].getFelder()[3]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.YELLOW);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.YELLOW);
										table.addCell(cell);
										
									}
						}else if (i==112) {
							 if (spiel.getBrett().getSpielbrett()[30].getFelder()[4]
										.getSpielfigur() != null) {
								 cell.setBorderWidth(2f);
									cell.setBorderColor(BaseColor.YELLOW);
									table.addCell(cell);
									}else{
										cell.setBackgroundColor(BaseColor.YELLOW);
										table.addCell(cell);
										
									}
							 
					}else if(i==72){
						 if (spiel.getBrett().getSpielbrett()[29].getFelder()[4]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.YELLOW);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.YELLOW);
									table.addCell(cell);
									
								}
					}else if(i==83){
						 if (spiel.getBrett().getSpielbrett()[29].getFelder()[3]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.YELLOW);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.YELLOW);
									table.addCell(cell);
									
								}
					}else if(i==94){
						 if (spiel.getBrett().getSpielbrett()[29].getFelder()[2]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.YELLOW);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.YELLOW);
									table.addCell(cell);
									
								}
					}else if(i==105){
						 if (spiel.getBrett().getSpielbrett()[19].getFelder()[1]
									.getSpielfigur() != null) {
							 cell.setBorderWidth(2f);
								cell.setBorderColor(BaseColor.YELLOW);
								table.addCell(cell);
								}else{
									cell.setBackgroundColor(BaseColor.YELLOW);
									table.addCell(cell);
									
								}

						} else {
							cell = new PdfPCell(new Phrase(" "));
							cell.setBackgroundColor(BaseColor.WHITE);
							table.addCell(cell);

						}
			}
		document.add(table);

		document.close();
	}









	@Override
	public void speichern(String dateiname, String dateiende, Object o)
			throws IOException {
		// TODO Auto-generated method stub
		
	}









	@Override
	public Object laden(String dateiname) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
