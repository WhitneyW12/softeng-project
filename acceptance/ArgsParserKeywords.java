import edu.jsu.mcis.*;

public class ArgsParserKeywords{
	
	private ArgsParser ap;
	
	public void startVolumeCacluatorWithArguments(String[] args){
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.STRING,"4","d");
		try{
			ap.parseValues(args);
		}
		catch(RuntimeException ex){};
	}
	
	public <T> T getLength(){
		return (T)ap.getValue("length");
	}
	
	public <T> T getWidth(){
		return (T)ap.getValue("width");
	}
	
	public <T> T getHeight(){
		return (T)ap.getValue("height");
	}
	
	public <T> T getPet(){
		return ap.getValue("pet");
	}
	
	public <T> T getNumber(){
		return (T)ap.getValue("number");
	}
	
	public <T> T getRainy(){
		return (T)ap.getValue("rainy");
	}
	
	public <T> T getBathrooms(){
		return ap.getValue("bathrooms");
	}
	public <T> T getType(){
		return (T)ap.getValue("type");
	}
	public <T> T getDigits(){
		return (T)ap.getValue("digits");
	}
	
	
	public String getProgramOutput(){
		
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
		ap.addPositionalArgument("pet","",Argument.Type.STRING);
		ap.addPositionalArgument("number","",Argument.Type.STRING);
		ap.addPositionalArgument("rainy","",Argument.Type.STRING);
		ap.addPositionalArgument("bathrooms","",Argument.Type.STRING);
		ap.parseValues(args);
	}
	
	public void startProgramWithArguments(String[] args){
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.DOUBLE);
		try{
			ap.parseValues(args);
		}
		catch(RuntimeException ex){};
		
	}
}