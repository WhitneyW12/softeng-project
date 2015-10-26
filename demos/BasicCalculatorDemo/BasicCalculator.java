import edu.jsu.mcis.*;

public class BasicCalculator{
	public static void main(String[] args){
		ArgsParser ap = new ArgsParser();
		ap.addProgram("BasicCalculator","Add, subtract, and multiply numbers.");
		ap.addArgument("firstNumber","The first number to do calculations on",Argument.Type.DOUBLE);
		ap.addArgument("secondNumber","The second number to do calculations on",Argument.Type.DOUBLE);
		ap.addNamedArgument("--add","Adds the numbers",Argument.Type.BOOLEAN,1,false);
		ap.addNamedArgument("--subtract","Subtracts the numbers",Argument.Type.BOOLEAN,1,false);
		ap.addNamedArgument("--multiply","Multiplies the numbers",Argument.Type.BOOLEAN,1,false);
	}
}