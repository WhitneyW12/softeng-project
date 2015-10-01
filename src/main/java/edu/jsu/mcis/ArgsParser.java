package edu.jsu.mcis;

import java.util.*;
import java.lang.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> argumentValues;
	private List<String> argumentDescriptions;
	private List<Double>  doubleArgumentValues;
	private List<Boolean> booleanArgumentValues;
	private List<Integer> integerArgumentValues;
	public enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	private List<Type> argumentType;
	private String premessage;
	private String helpMessage;
	private String programName;
	private String programDescription;
	
	
	public ArgsParser()
	{
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
		argumentDescriptions = new ArrayList<String>();
		doubleArgumentValues = new ArrayList<Double>();
		booleanArgumentValues = new ArrayList<Boolean>();
		integerArgumentValues = new ArrayList<Integer>();
		argumentType = new ArrayList<Type>();
		programName = "";
		programDescription = "";
		helpMessage = "";
		premessage = "";
	
	}

	public void addArgument(String name, String description, Type t) {
		
		argumentNames.add(name);
		argumentValues.add("");
		doubleArgumentValues.add(0.0);
		integerArgumentValues.add(0);
		booleanArgumentValues.add(false);
		argumentType.add(t);
		argumentDescriptions.add(description);
		setPremessage();
	}
	public void parseValues (String[] values){
		for(int i=0;i<values.length;i++){
			if(values.length != argumentNames.size()){
				if(values.length > argumentNames.size()){
					
				}
					
				else{
					
				}
				
				
			}
		if(values[i].equals("-h")){
			System.out.print(helpMessage);
			System.exit(0);
			
		}
		if(argumentType.get(i)==Type.STRING){
		argumentValues.set(i,values[i]);
		}
		else if(argumentType.get(i)==Type.DOUBLE){
		parseDouble(i,values[i]);
		}
		else if(argumentType.get(i)==Type.INTEGER){
			parseInteger(i,values[i]);
		}
		else{
			parseBoolean(i,values[i]);
			
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
	public int getIntValue(String name){
		int index = argumentNames.indexOf(name);
		return integerArgumentValues.get(index);
	}
	public boolean getBoolValue(String name){
		int index = argumentNames.indexOf(name);
		return booleanArgumentValues.get(index);
	}
	private void parseDouble(int index,String value){//throws WrongFormatException {
		
		doubleArgumentValues.set(index,Double.parseDouble(value));
		
	}
	private void parseInteger(int index,String value){//throws WrongFormatException{
		integerArgumentValues.set(index,Integer.parseInt(value));
	}
	private void parseBoolean(int index,String value){//throws WrongFormatException{
		booleanArgumentValues.set(index,Boolean.parseBoolean(value));
	}
	
}