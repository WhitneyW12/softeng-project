package edu.jsu.mcis;

import java.util.*;
import java.lang.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> namedArguments;
	private List<Argument> arguments;
	private String premessage;
	private String helpMessage;
	private String programName;
	private String programDescription;
	private String errorMessage;
	private boolean error;
	
	
	public ArgsParser()
	{
		arguments = new ArrayList<Argument>();
		namedArguments = new ArrayList<String>();
		argumentNames = new ArrayList<String>();
		programName = "";
		programDescription = "";
		helpMessage = "";
		premessage = "";
		errorMessage = "";
		error = false;
	
	}
	public void addNamedArgument(String name){
		namedArguments.add(name);
		
		
	}
	public void addArgument(String name, String description, Argument.Type t) {
		argumentNames.add(name);
		arguments.add(new Argument(t,name,description));
		setPremessage();
	}
	public void parseValues (String[] values){
		for(int i=0;i<values.length;i++){
			for(int j=0;j<namedArguments.size();j++){
				if(values[i].equals(namedArguments.get(j))){
				
					int index = argumentNames.indexOf("--type");
					arguments.get(index).setValue(values[i+1]);
					i++;
				
				
				}
			}
			
			if(values[i].equals("-h")){
			System.out.print(helpMessage);
			arguments.get(i).setValue(values[i]);
			
			
			}
			else if(values.length != argumentNames.size()){
				if(values.length > argumentNames.size()){
					errorMessage = premessage+"\n"+programName+".java: error: unrecognized arguments: "+values[i];
					error=true;
					System.out.print(errorMessage);
					
				} 
					
				else{
					errorMessage = premessage+"\n"+programName+".java: error: the following arguments are required: ";
					for(int j=i+1;j<argumentNames.size();j++)
						errorMessage+=argumentNames.get(j)+" ";
					error=true;
					System.out.print(errorMessage);
				
				}
				
				
			}
			else{
				if(arguments.get(i).getType()==Argument.Type.STRING){
				arguments.get(i).setValue(values[i]);
				}
				else if(arguments.get(i).getType()==Argument.Type.DOUBLE){
				try{
					parseDouble(i,values[i]);
				}
			catch(NumberFormatException e){
				errorMessage = premessage+"\n"+programName+".java: error: argument "+argumentNames.get(i)+": invalid double value: "+values[i];
				error=true;
			}
		}
		else if(arguments.get(i).getType()==Argument.Type.INTEGER){
			parseInteger(i,values[i]);
		}
		else{
			parseBoolean(i,values[i]);
			
		}
		
	}
	}
	}

	public void addProgram(String name,String description){
		programName = name;
		programDescription = description;
		setPremessage();
	}
	public String getDescription(String name)
	{
		int index = argumentNames.indexOf(name);
		return arguments.get(index).getDescription();
		
		
	}
	private void setHelpMessage(){
		helpMessage = premessage;
		helpMessage += "\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<arguments.size();i++)
		{
			helpMessage += arguments.get(i).getName()+" "+arguments.get(i).getDescription()+"\n";
			
		}
		
		
	}
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for(int i = 0; i < arguments.size();i++){
			premessage += arguments.get(i).getName()+" ";
		}
		
	}  
	

	public String getHelpMessage(){
		setHelpMessage();
		return helpMessage;
		
	}

	public <T> T getValue(String name){
		int index = argumentNames.indexOf(name);
		return (T)arguments.get(index).getValue();
	}
	private void parseDouble(int index,String value)throws NumberFormatException {
		arguments.get(index).setValue(Double.parseDouble(value));
	}
	private void parseInteger(int index,String value){
		
		arguments.get(index).setValue(Integer.parseInt(value));
	}
	private void parseBoolean(int index,String value){
		arguments.get(index).setValue(Boolean.parseBoolean(value));
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public boolean getError(){
		return error;
	}
	
}