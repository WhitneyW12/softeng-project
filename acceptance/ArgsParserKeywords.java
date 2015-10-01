import edu.jsu.mcis.*;

public class ArgsParserKeywords {
	
	private ArgsParser ap;
	/*
	public void startVolumeCacluatorWithArguments(String[] args) {
		p = new ArgsParser();
		p.addArg("length");
		p.addArg("width");
		...
		p.parse(args);
		
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