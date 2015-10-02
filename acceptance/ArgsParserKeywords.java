import edu.jsu.mcis.*;

public class ArgsParserKeywords {
	
	private ArgsParser ap;
	
	public void startVolumeCacluatorWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",ArgsParser.Type.STRING);
		ap.addArgument("width","the width of the box",ArgsParser.Type.STRING);
		ap.addArgument("height","the height of the box",ArgsParser.Type.STRING);
		ap.parseValues(args);
		
	}
	
	public String getLength() {
		return ap.getStringValue("length");
	}
	public String getWidth() {
		return ap.getStringValue("width");
	}
	public String getHeight() {
		return ap.getStringValue("height");
	}
	public String getPet() {
		return ap.getStringValue("pet");
	}
	public String getNumber() {
		return ap.getStringValue("number");
	}
	public String getRainy() {
		return ap.getStringValue("rainy");
	}
	public String getBathrooms() {
		return ap.getStringValue("bathrooms");
	}
	
	public String getProgramOutput() {
		if(ap.getStringValue("length").equals("-h")){
			return ap.getHelpMessage();
		}
		else if(ap.getError()){
			return ap.getErrorMessage();
		}
		else{
		float len = Float.parseFloat(getLength());
		float wid = Float.parseFloat(getWidth());
		float hei = Float.parseFloat(getHeight());
		return String.valueOf(len * wid * hei);}
	}
	
	
	public void startAbsurdProgramWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","");
		ap.addArgument("pet","",ArgsParser.Type.STRING);
		ap.addArgument("number","",ArgsParser.Type.STRING);
		ap.addArgument("rainy","",ArgsParser.Type.STRING);
		ap.addArgument("bathrooms","",ArgsParser.Type.STRING);
		ap.parseValues(args);
		
		
	}
	
	public void startProgramWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",ArgsParser.Type.DOUBLE);
		ap.addArgument("width","the width of the box",ArgsParser.Type.DOUBLE);
		ap.addArgument("height","the height of the box",ArgsParser.Type.DOUBLE);
		ap.parseValues(args);
	}
}