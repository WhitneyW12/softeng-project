package edu.jsu.mcis;

import java.util.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> argumentValues;
	private List<String> argumentDescriptions;
	private List<Double>  doubleArgumentValues;
	private String premessage;
	private String helpMessage;
	private String programName;
	private String programDescription;
	public String errorMessage;
	
	public ArgsParser()
	{
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
		argumentDescriptions = new ArrayList<String>();
		doubleArgumentValues = new ArrayList<Double>();
		programName = "";
		programDescription = "";
		helpMessage = "";
		premessage = "";
		errorMessage = "";
	}

	public void addArgument(String name, String description) {
		
		argumentNames.add(name);
		argumentValues.add("");
		doubleArgumentValues.add(0.0);
		argumentDescriptions.add(description);
		setPremessage();
	}
	public void parseValues (String[] values){
		for(int i=0;i<argumentNames.size();i++){
		if(values[i].equals("-h")){
			System.out.print(helpMessage);
			System.exit(0);
			
		}
		argumentValues.set(i,values[i]);
		try{
		parseDouble(i,values[i]);
		}
		catch(NumberFormatException e){
			errorMessage = premessage+"\n"+programName+".java: error: argument "+argumentNames.get(i)+" invalid double value: "+values[i];
			throw new NumberFormatException(errorMessage);
		}
		}
		
	}
	public double getDoubleValue(String name){
		int index = argumentNames.indexOf(name);
		return doubleArgumentValues.get(index);
	}
	
	public String getStringValue(String name) {
		int index = argumentNames.indexOf(name);
		return argumentValues.get(index);
	}	
	public void addProgram(String name,String description){
		programName = name;
		programDescription = description;
		setPremessage();
	}
	public String getDescription(String name)
	{
		int index = argumentNames.indexOf(name);
		return argumentDescriptions.get(index);
		
		
	}
	private void setHelpMessage(){
		helpMessage = premessage;
		helpMessage += "\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<argumentDescriptions.size();i++)
		{
			helpMessage += argumentNames.get(i)+" "+argumentDescriptions.get(i)+"\n ";
			
		}
		
		
	}
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for(int i = 0; i < argumentDescriptions.size();i++){
			premessage += argumentNames.get(i)+" ";
		}
		
	}  
	

	public String getHelpMessage(){
		setHelpMessage();
		return helpMessage;
		
	}
	private void parseDouble(int index,String value)throws NumberFormatException {
		doubleArgumentValues.set(index,Double.parseDouble(value));
		
	}
	
	
}