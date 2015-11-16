import edu.jsu.mcis.*;
import java.util.*;
import java.io.*;

public class PizzaShop{
	public static void main(String[] args){
		ArgsParser ap;
		readWriteXML rw = new readWriteXML();
		ap=rw.parseXML("newPizzaShop.xml");
		ap.parseValues(args);
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