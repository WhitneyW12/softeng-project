import edu.jsu.mcis.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import java.io.*;

public class PizzaShop{
	public static void main(String[] args){
		ArgsParser ap;
		readWriteXML rw = new readWriteXML();
		try {
			InputStream xmlInput = new FileInputStream("newPizzaShop.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(xmlInput,rw.handler);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ap=rw.getArgsParser();
		ap.parseValues(args);
		ap.saveXML("newPizzaShop.xml");
		System.out.println("You have ordered " + ap.getValue("quantity") + " " + ap.getValue("size") + ", " + ap.getValue("shape") + " " + ap.getValue("toppings") + "-topping pizza(s) with " + ap.getValue("drink") + ".");
		boolean togo = ap.getValue("togo");
		if (togo){
			System.out.println("The order is togo.");
		}
		else{
			System.out.println("The order is for here.");
		}
	}
}