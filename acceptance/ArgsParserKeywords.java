import edu.jsu.mcis.*;

public class ArgsParserKeywords {
	
	private ArgsParser ap;
	/*
	public void startVolumeCacluatorWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addArgument("length");
		ap.addArgument("width");
		...
		ap.parseValues(args);
		
	}
	
	public String getLength() {
		return p.getArgValue("length");
	}
	
	...
	
	public String getProgramOutput() {
		float len = Float.parseFloat(getLength());
		float wid = 
		float hei = 
		return String.valueOf(len * wid * hei);
	}
	
	public void startAbsurdProgramWithArguments() {
		
	}
	*/
	public void startProgramWithArguments(String[] args) {
		ap = new ArgsParser();
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
	}
}