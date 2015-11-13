package edu.jsu.mcis;
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
	private ArgsParser ap;
	private String aname;
	private String adescription;
	private String ashorthand;
	private String adefault;
	private Argument.Type atype;
/*
readWriteXML rw = new readWriteXML();
	
    try {
	InputStream xmlInput = new FileInputStream("readXML.xsl");
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
	
	
	
	saxParser.parse(xmlInput,rw.handler);
	**/
	
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
	
	public DefaultHandler handler = new DefaultHandler(){
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
	
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
		if(qName.equals("positionalArgument")){
			ap.addPositionalArgument(aname,adescription,atype);
		}
		if(qName.equals("namedArgument")){
			ap.addNamedArgument(aname,adescription,atype,adefault,ashorthand);
		}
		

	}
	
	
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
	
	public ArgsParser getArgsParser(){
		return ap;
	}

}