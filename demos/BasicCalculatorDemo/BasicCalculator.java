import edu.jsu.mcis.*;

public class BasicCalculator{
	public static void main(String[] args){
		//args = new String[] {"--add","8","7"};
		ArgsParser ap = new ArgsParser();
		ap.addProgram("BasicCalculator","Add, subtract, and multiply numbers.");
		ap.addPositionalArgument("firstNumber","The first number to do calculations on",Argument.Type.DOUBLE);
		ap.addPositionalArgument("secondNumber","The second number to do calculations on",Argument.Type.DOUBLE);
		ap.addNamedArgument("--add","Adds the numbers",Argument.Type.BOOLEAN,0,false,"-a");
		ap.addNamedArgument("--subtract","Subtracts the numbers",Argument.Type.BOOLEAN,0,false,"-s");
		ap.addNamedArgument("--multiply","Multiplies the numbers",Argument.Type.BOOLEAN,0,false,"-m");
		ap.parseValues(args);
		double firstNumber = ap.getValue("firstNumber");
		double secondNumber = ap.getValue("secondNumber");
		boolean add = ap.getValue("--add");
		boolean subtract = ap.getValue("--subtract");
		boolean multiply = ap.getValue("--multiply");
		System.out.print("The answer is: ");
		if (add){
			System.out.print(firstNumber + secondNumber);
		}
		else if (subtract){
			System.out.print(firstNumber - secondNumber);
		}
		else if (multiply){
			System.out.print(firstNumber * secondNumber);
		}
		else{
			System.out.println("No action was selected. Type --help for more information.");
		}
	}
}