package edu.jsu.mcis;

import java.util.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> argumentValues;
	private List<String> argumentDescriptions;
	private List<Float>  floatArgumentValues;
	String programName;
	String programDescription;
	
	public ArgsParser()
	{
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
		argumentDescriptions = new ArrayList<String>();
		floatArgumentValues = new ArrayList<Float>();
		programName="";
		programDescription="";
	}

	public void addArgument(String name, String description) {
		
		argumentNames.add(name);
		argumentValues.add("");
		floatArgumentValues.add(0);
		argumentDescriptions.add(description);
	}
	public void setValue (String name, String value){
		int index = argumentNames.indexOf(name);
		argumentValues.set(index,value);
		floatArgumentValues.set(index,Float.parseFloat(value));
	}
	public float getFloatValue(String name){
		int index = argumentNames.indexOf(name);
		return floatArgumentValues.get(index);
	}
	
	public String getArgumentValue(String name) {
		int index = argumentNames.indexOf(name);
		return argumentValues.get(index);
	}	
	public void addProgram(String name,String description){
		programName = name;
		programDescription = description;
		
		
		
	}
	public String getDescription(String name)
	{
		int index = argumentNames.indexOf(name);
		return argumentDescriptions.get(index);
		
		
	}
	public String getHelpText(){
		String helptext = "usage: java "+programName+" ";
		for(int i =0; i<argumentDescriptions.size();i++){
			helptext += argumentNames.get(i)+" ";
		}
		helptext+="\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<argumentDescriptions.size();i++)
		{
			helptext += argumentNames.get(i)+" "+argumentDescriptions.get(i)+"\n ";
			
		}
		return helptext;
		
	}
	
	
}