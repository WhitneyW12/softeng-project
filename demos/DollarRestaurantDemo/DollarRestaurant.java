import edu.jsu.mcis.*;

public class DollarRestaurant{
	public static void main(String[] args){
		ArgsParser ap = new ArgsParser();
		ap.addProgram("DollarRestaurant","All food is a dollar!");
		ap.addPositionalArgument("entree","What would you like as your entree?",Argument.Type.STRING);
		
		ap.addNamedArgument("appetizer","What would you like as an appetizer?",Argument.Type.STRING,"no appetizer","a");
		ap.addNamedArgument("dessert","What would you like for dessert?",Argument.Type.STRING,"no dessert","d");
		ap.parseValues(args);
		double amount = 0;
		double tip = 0;
		double total = 0;
		if(ap.getValue("appetizer") != "no appetizer"){
			amount++;
		}
		if(ap.getValue("dessert") != "no dessert"){
			amount++;
		}
		tip = .10 * amount;
		total = amount + tip;
		System.out.println("Your total is $" + String.format("%.2f", total) +".");
	}
}