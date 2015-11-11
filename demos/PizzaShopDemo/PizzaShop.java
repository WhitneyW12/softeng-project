import edu.jsu.mcis.*;

public class PizzaShop{
	public static void main(String[] args){
		ArgsParser ap = new ArgsParser();
		ap.addProgram("PizzaShop","Order a pizza.");
		ap.addPositionalArgument("size","The size of the pizza(small, medium, large).",Argument.Type.STRING);
		ap.addPositionalArgument("shape","The shape of the pizza(round, square).",Argument.Type.STRING);
		ap.addPositionalArgument("toppings","The number of toppings.",Argument.Type.INTEGER);
		ap.addPositionalArgument("quantity","The number of this type of pizza.",Argument.Type.INTEGER);
		ap.addNamedArgument("drink","What drink will you have?",Argument.Type.STRING,"no drink","d");
		ap.addNamedArgument("togo","Is the order togo?",Argument.Type.BOOLEAN,"false","t");
		ap.parseValues(args);
		ap.saveXML();
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