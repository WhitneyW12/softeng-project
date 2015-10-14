import edu.jsu.mcis.*;

public class ArgsParserKeywords{
	
	private ArgsParser ap;
	
	public void startVolumeCacluatorWithArguments(String[] args){
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		ap.parseValues(args);
	}
	
	public <T> T getLength(){
		return ap.getValue("length");
	}
	
	public <T> T getWidth(){
		return ap.getValue("width");
	}
	
	public <T> T getHeight(){
		return ap.getValue("height");
	}
	
	public <T> T getPet(){
		return ap.getValue("pet");
	}
	
	public <T> T getNumber(){
		return ap.getValue("number");
	}
	
	public <T> T getRainy(){
		return ap.getValue("rainy");
	}
	
	public <T> T getBathrooms(){
		return ap.getValue("bathrooms");
	}
	
	public String getProgramOutput(){
		String s = "";
		double d = 0;
		int i = 0;
		boolean b = false;
		if(ap.getHelp()){
			return ap.getHelpMessage();
		}
		if(ap.getArgumentType("length")==Argument.Type.STRING){
			s = ap.getValue("length");
		}
		else if (ap.getArgumentType("length")==Argument.Type.DOUBLE){
			d = ap.getValue("length");
		}
		else if (ap.getArgumentType("length")==Argument.Type.INTEGER){
			i = ap.getValue("length");
		}
		else{
			b = ap.getValue("length");
		}
		if(ap.getError()){
			return ap.getErrorMessage();
		}
		else{
			float len = Float.parseFloat(getLength());
			float wid = Float.parseFloat(getWidth());
			float hei = Float.parseFloat(getHeight());
			return String.valueOf(len * wid * hei);
		}
	}
	
	public void startAbsurdProgramWithArguments(String[] args){
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","");
		ap.addArgument("pet","",Argument.Type.STRING);
		ap.addArgument("number","",Argument.Type.STRING);
		ap.addArgument("rainy","",Argument.Type.STRING);
		ap.addArgument("bathrooms","",Argument.Type.STRING);
		ap.parseValues(args);
	}
	
	public void startProgramWithArguments(String[] args){
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.parseValues(args);
	}
}