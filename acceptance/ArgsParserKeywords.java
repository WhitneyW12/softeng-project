import edu.jsu.mcis.*;

public class ArgsParserKeywords {
	
	private ArgsParser ap;
	
	public void startVolumeCacluatorWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
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
		if(getLength().equals("-h")){
			return ap.getHelpMessage();
		}
		else{
		float len = Float.parseFloat(getLength());
		float wid = Float.parseFloat(getWidth());
		float hei = Float.parseFloat(getHeigth());
		return String.valueOf(len * wid * hei);}
	}
	
	public void startAbsurdProgramWithArguments() {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","");
		ap.addArgument("pet","");
		ap.addArgument("number","");
		ap.addArgument("rainy","");
		ap.addArgument("bathrooms","");
		ap.parseValues(args);
		
		
	}
	
	public void startProgramWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.parseValues(args);
	}
}