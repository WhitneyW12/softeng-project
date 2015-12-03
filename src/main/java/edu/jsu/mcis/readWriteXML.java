package edu.jsu.mcis;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import java.io.*;
import edu.jsu.mcis.*;

/**
 * <p> 
 * Creates a new class to parse an XML file.
 * Class extends from DefaultHandler superclass.
 * @author BabaTunde Idumu
 * @author Michael Quattrochi
 * author Wesley Schultz
 * @author James Thomas
 * @author Whitney Wood
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
		ap =	new ArgsParser();	
		aname="";
		adescription="";
		ashorthand="";
		atype= Argument.Type.STRING;
	}
/**
	 * New instance of DefaultHandler class is created called "handler".
	 */
	public DefaultHandler handler = new DefaultHandler(){
	/**
	 * <p>
	 * This method is used at the beginning of every element in the XML
	 * document. All contents of an element are reported, in order, prior to
	 * the invocation of the corresponding endElement() method.
	 *
	 * @param uri is an empty string if the element has no Namespace URI or
	 * Namespace processing is not being performed. Otherwise, parameter is treated
	 * as a Namespace.
	 *
	 * @param localName if Namespace processing is not being performed, parameter is
	 * an empty string.
	 *
	 * @param qName represents the qualified name and if no qualified names are
	 * available, parameter is an empty string.
	 *
	 * @param attributes are attached to the xml elements. This parameter is treated as an empty
	 * Attributes object, if no attributes are available.
	 * 
	 * @throws SAXException for any SAX exception.
	 */
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

		if(qName.equals("arguments")){
			ap.addProgram(aname,adescription);
		}

		if (qName.equalsIgnoreCase("name")) {
			name = true;
			
		}

		if (qName.equalsIgnoreCase("type")) {
			type = true;
			
		}

		if (qName.equalsIgnoreCase("description")) {
			description = true;
			 
		}
		
		if (qName.equalsIgnoreCase("default")) {
			defaults = true;
		}
		if (qName.equalsIgnoreCase("shorthand")) {
			shorthand = true;
		}
			
	}
		/**
	 * <p>
	 * This method is notified when the end of an element is reached. Does nothing,
	 * by default. Specifies whether element is a positional or named argument.
	 * 
	 * @param uri is a Namespace uri. If the element has no Namespace uri or no Namespace 
	 * processing is being performed, it is treated as an empty string.
	 *
	 * @param localName is the local name. If no Namespace processing is being performed
	 * parameter is treated as an empty string.
	 *
	 * @param qName is the qualified name. If none are available, parameter is treated as
	 * an empty string.
	 *
	 * @throws SAXException for any SAX exception.
	 */
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
		if(qName.equals("positionalArgument")){
			ap.addPositionalArgument(aname,adescription,atype);
		}
		if(qName.equals("namedArgument")){
			ap.addNamedArgument(aname,adescription,atype,adefault,ashorthand);
		}
		

	}
	
	/**
	 * <p>
	 * This method receives a notification of character data that is inside an
	 * element. Does nothing, by default. Writers of application may overrride
	 * method to take specific actions for each block of character data.
	 * @param ch is the character.
	 *
	 * @param start is the start position in character array.
	 *
	 * @param length is the number of characters to use from the character array.
	 *
	 * @throws SAXException for any SAX exeception.
	 */
	public void characters(char ch[], int start, int length) throws SAXException {

		if (name) {
			aname=new String(ch, start, length);
			name = false;
			
		}

		if (type) {
			if(new String(ch, start, length).equals("STRING")){
				atype=Argument.Type.STRING;
			}
			else if(new String(ch, start, length).equals("DOUBLE")){
				atype=Argument.Type.DOUBLE;
			}
			else if (new String(ch, start, length).equals("INTEGER")){
				atype=Argument.Type.INTEGER;
			}
			else {
				atype=Argument.Type.BOOLEAN;
			}
			type = false;
		}

		if (description) {
			adescription=new String(ch, start, length);
		
			description = false;
		}
		
		if (defaults) {
			adefault=new String(ch, start, length);
			defaults = false;
		}
		
		if (shorthand) {
			ashorthand= new String(ch, start, length);
			shorthand= false;
		}
	}
	};
	
	private ArgsParser getArgsParser(){
		return ap;
	}
	public ArgsParser parseXML(String filepath){
		try {
			InputStream xmlInput = new FileInputStream(filepath);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(xmlInput,handler);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return getArgsParser();
	}

}