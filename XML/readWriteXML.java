import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import java.io.*;
import edu.jsu.mcis.*;

/**
 *Creates a new class to parse an XML file.
 *Class extends from DefaultHandler superclass.
 */

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
	private ArgsParser ap;
	private String aname;
	private String adescription;
	private String ashorthand;
	private String adefault;
	private Argument.Type atype;
	
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
		ap =	new ArgParser();	
		aname="";
		adescription="";
		ashorthand="";
		atype= Argument.Type.STRING;
	}
	
	/**
	 *New instance of DefaultHandler class is created called "handler".
	 */
	DefaultHandler handler = new DefaultHandler(){
	/**
	 * This method prints start element tags for xml formatting
	 * if attribute name, type, description, defaults, and shorthand are equal
	 * to the specified string in the corresponding java file.
	 * @param uri 
	 * @param localName
	 * @param qName
	 * @param attributes
	 */
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

		System.out.println("Start Element :" + qName);
		if(qName.equals("arguments")){
			ap.addProgram(aname,adescription);
		}

		else if (qName.equalsIgnoreCase("name")) {
			name = true;	
		}

		else if (qName.equalsIgnoreCase("type")) {
			type = true;
			
		}
		else if (qName.equalsIgnoreCase("description")) {
			description = true;
			 
		}
		else if (qName.equalsIgnoreCase("defaults")) {
			defaults = true;
		}
		else (qName.equalsIgnoreCase("shorthand")) {
			shorthand = true;
		}
			
	}
	
	/**
	 * This method formats the end element tags from the xml file being
	 * being parsed.
	 * Throws a SAXException...
	 * @param uri
	 * @param localName
	 * @param qName
	 */
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
		if(qName.equals("positionalArgument")){
			ap.addPositionalArgument(aname,adescription,atype);
		}
		else(qName.equals("namedArgument")){
			ap.addNamedArgument(aname,adescription,atype,adefault,ashorthand);
		}
		System.out.println("End Element :" + qName);
		

	}
	
	/**
	 * This method...
	 * Throws a SAXException..
	 * @param ch
	 * @param start
	 * @param length
	 */
	public void characters(char ch[], int start, int length) throws SAXException {

		if (name) {
			aname=new String(ch, start, length);
			System.out.println("name : " + new String(ch, start, length));
			name = false;
			
		}

		if (type) {
			if(new String(ch, start, length).equals("DOUBLE")){
				atype=Argument.Type.DOUBLE;
			}
			else if (new String(ch, start, length).equals("INTEGER")){
				atype=ARGUMENT.Type.INTEGER;
			}
			else{
				atype=ARGUMENT.Type.BOOLEAN;
			}
			System.out.println("type : " + new String(ch, start, length));
			type = false;
		}

		if (description) {
			adescription=new String(ch, start, length);
			System.out.println("description : " + new String(ch, start, length));
			description = false;
		}
		
		if (defaults) {
			adefault=new String(ch, start, length);
			System.out.println("defaults : " + new String(ch, start, length));
			defaults = false;
		}
		
		if (shorthand) {
			ashorthand= new String(ch, start, length);
			System.out.println("shorthand : " + new String(ch, start, length));
			shorthand= false;
		}
	}
	};
	
	/**
	 *
	 */
	public ArgParser getArgParser(){
		return ap;
	}
	
	/**
	 *
	 */
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
	  System.out.println(rw.getType());
	  
	}


}