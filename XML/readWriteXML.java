import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import java.io.*;

public class readWriteXML extends DefaultHandler{
	
	private boolean name ;
	private boolean type ;
	private boolean description;
	private boolean defaults;
	private boolean shorthand;
	private StringBuilder nameAttributes;
	private StringBuilder typeAttributes;
	private StringBuilder descriptionAttributes;
	private StringBuilder defaultAttributes;
	private StringBuilder shortHandAttributes;
	
	public readWriteXML(){
		nameAttributes= new StringBuilder();
		typeAttributes=new StringBuilder();
		descriptionAttributes = new StringBuilder();
		defaultAttributes = new StringBuilder();
		shortHandAttributes = new StringBuilder();
		name = false;
		type = false;
		description = false;
		defaults = false;
		shorthand = false;		
	}
	
	DefaultHandler handler = new DefaultHandler(){
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("name")) {
			name = true;
			
		}

		if (qName.equalsIgnoreCase("type")) {
			type = true;
			
		}

		if (qName.equalsIgnoreCase("description")) {
			description = true;
			 
		}
		
		if (qName.equalsIgnoreCase("defaults")) {
			defaults = true;
		}
		if (qName.equalsIgnoreCase("shorthand")) {
			shorthand = true;
		}
			
	}
	
	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		System.out.println("End Element :" + qName);
		

	}
	
	
	public void characters(char ch[], int start, int length) throws SAXException {

		if (name) {
			System.out.println("name : " + new String(ch, start, length));
			name = false;
			nameAttributes.append(ch,start,length);
			nameAttributes.append(" ");
			
		}

		if (type) {
			System.out.println("type : " + new String(ch, start, length));
			type = false;
			typeAttributes.append(ch,start,length);
			typeAttributes.append("");
		}

		if (description) {
			System.out.println("description : " + new String(ch, start, length));
			description = false;
			descriptionAttributes.append(ch,start,length);
			descriptionAttributes.append("");
		}
		
		if (defaults) {
			System.out.println("defaults : " + new String(ch, start, length));
			defaults = false;
		}
		
		if (shorthand) {
			System.out.println("shorthand : " + new String(ch, start, length));
			shorthand= false;
		}
	}
	};
	
	public String getNames(){
		return nameAttributes.toString();
	}
	public String getType(){
		String s = "";
		return s;
	}
	public String getDescription(){
		
		String s = "";
		return s;
	}
	public String getDefault(){
		String s="";
		return s;
	}
	public String getShortHand(){
		String s="";
		return s;
	}
   public static void main(String argv[]) {
	readWriteXML rw = new readWriteXML();
	
    try {
	InputStream xmlInput = new FileInputStream("readXML.xsl");
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
	
	
	
	saxParser.parse(xmlInput,rw.handler);

	//DefaultHandler handler = new DefaultHandler() {
	} catch (Exception e) {
       e.printStackTrace();
     }
	 System.out.println(rw.getNames());
	}


}