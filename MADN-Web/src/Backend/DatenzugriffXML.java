package Backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.itextpdf.text.DocumentException;

import sun.awt.FwDispatcher;
import Interfaces.iDatenzugriff;
import Backend.SpielBean;

public class DatenzugriffXML implements iDatenzugriff {

	@Override
	public void speichern(String dateiname, String dateiende, Object o) throws IOException, JAXBException {
		
		
		FileWriter fw = null;
			try{
				JAXBContext context = JAXBContext.newInstance( SpielBean.class );
				Marshaller m = context.createMarshaller();
				m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
				//m.marshal( s, System.out );
				fw=new FileWriter(dateiende + ".xml");
				m.marshal(o, fw);
			}
			finally {
				try{
					fw.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		
		}
				
	

	@Override
	public Object laden(String dateipfad) throws ClassNotFoundException,
			FileNotFoundException, IOException, JAXBException {

		JAXBContext context=JAXBContext.newInstance(SpielBean.class);
		Unmarshaller um = context.createUnmarshaller();
		SpielBean s = (SpielBean)um.unmarshal(new FileReader(dateipfad));
		
		
		
		return s;
	}

	@Override
	public void spielfeld(Backend.SpielBean spiel)
			throws FileNotFoundException, DocumentException {
		// TODO Auto-generated method stub
		
	}


}