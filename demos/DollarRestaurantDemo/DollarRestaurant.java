import edu.jsu.mcis.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DollarRestaurant{
	public static void main(String[] args){
		ArgsParser ap = new ArgsParser();
		ap.addProgram("DollarRestaurant","All food is a dollar!");
		ap.addPositionalArgument("entree","What would you like as your entree?",Argument.Type.STRING);
		ap.addPositionalArgument("paymentType","What will you pay with(1. cash, 2. card, 3. check)?",Argument.Type.INTEGER);
		ap.addNamedArgument("sides","How many sides would you like?",Argument.Type.INTEGER,"0","s");
		ap.addNamedArgument("drink","What would you like to drink?",Argument.Type.STRING,"no drink","dr");
		ap.addNamedArgument("appetizer","What would you like as an appetizer?",Argument.Type.STRING,"no appetizer","a");
		ap.addNamedArgument("dessert","What would you like for dessert?",Argument.Type.STRING,"no dessert","de");
		ap.addNamedArgument("tip","Would you like to leave a tip?",Argument.Type.BOOLEAN,"false","t");
		ap.parseValues(args);
		
		double amount = 1;
		double tax = 0;
		double total = 0;
		double tipValue = 0;
		boolean tip = ap.getValue("tip");
		int paymentType = ap.getValue("paymentType");
		int sides = ap.getValue("sides");
		String drink = ap.getValue("drink");
		String appetizer = ap.getValue("appetizer");
		String dessert = ap.getValue("dessert");
		String[] sideNames = new String[sides];
		Scanner s = new Scanner(System.in);
		
		if(sides != 0){
			amount += sides;
			System.out.println("What sides would you like?");
			for(int i = 0; i < sides; i++){
				sideNames[i] = (s.next());
			}
		}
		if(drink != "no drink"){
			amount++;
		}
		if(appetizer != "no appetizer"){
			amount++;
		}
		if(dessert != "no dessert"){
			amount++;
		}
		tax = .10 * amount;
		total = amount + tax;
		System.out.print("You have ordered " + ap.getValue("entree") + " with " + sides + " side(s)");
		if(sides != 0){
			System.out.print(":");
			boolean isFirst = true;
			boolean isLast = false;
			for(int j = 0; j < sideNames.length; j++){
				if(sideNames.length == j + 1){
					isLast = true;
				}
				if(isFirst){
					System.out.print(" " + sideNames[j]);
					isFirst = false;
				}
				else if(isLast){
					System.out.print(" and " + sideNames[j]);
				}
				else{
					System.out.print(", " + sideNames[j]);
				}
			}
		}
		System.out.println(".");
		if(drink != "no drink"){
			System.out.println("You have ordered " + drink + " to drink.");
		}
		if(appetizer != "no appetizer"){
			System.out.println("You have ordered " + appetizer + " for an appetizer.");
		}
		if(dessert != "no dessert"){
			System.out.println("You have ordered " + dessert + " for dessert.");
		}
		System.out.println("Your total with tax is $" + String.format("%.2f", total) +".");
		
		if(tip){
			System.out.println("How much of a tip would you like to leave?");
			tipValue = s.nextDouble();
			System.out.println("Thanks for the $" + String.format("%.2f", tipValue) + " tip!");
		}
		if(paymentType == 1){
			System.out.println("How much money would you like to pay with?");
			double payment = s.nextDouble();
			double change = payment - total - tipValue;
			System.out.print("Your change is $" + String.format("%.2f", change));
			if(tip){
				System.out.print(" including the tip");
			}
			System.out.print(".");
		}
	}
}