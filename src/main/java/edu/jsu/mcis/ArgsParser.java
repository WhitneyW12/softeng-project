package edu.jsu.mcis;

import java.util.*;
import java.lang.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> namedArgumentsNames;
	private Map<String,Argument> arguments;
	private String premessage;
	private String helpMessage;
	private String programName;
	private String programDescription;
	private String errorMessage;
	private boolean error;
	private boolean help;
	
	
	public ArgsParser()
	{
		arguments = new HashMap<String,Argument>();
		namedArgumentsNames = new ArrayList<String>();
		argumentNames = new ArrayList<String>();
		programName = "";
		programDescription = "";
		helpMessage = "";
		premessage = "";
		errorMessage = "";
		error = false;
		help = false;
	
	}
	public void addNamedArgument(String name, String description, Argument.Type t){
		namedArgumentsNames.add(name);
		arguments.put(name,new Argument(t,name,description));
		
		
	}
	public void addArgument(String name, String description, Argument.Type t) {
		argumentNames.add(name);
		arguments.put(name,new Argument(t,name,description));
		setPremessage();
	}
	
	public void parseValues (String[] values){
		for(int i=0;i<values.length;i++){
			for(int j=0;j<namedArgumentsNames.size();j++){
				if(values[i].equals(namedArgumentsNames.get(j))){
				
					arguments.get(namedArgumentsNames.get(j)).setValue(values[i+1]);
					i++;
				
				
				}
			}
			
			if(values[i].equals("-h")){
			arguments.get(i).setValue(values[i]);
			help = true;
			
			
			}
			else if(values.length != argumentNames.size()+namedArgumentsNames.size()){
				if(values.length > argumentNames.size()&& i>argumentNames.size()){
					errorMessage = premessage+"\n"+programName+".java: error: unrecognized arguments: "+values[i];
					error=true;
					throw new TooManyArgumentsException(errorMessage);
					
				} 
					
				else if (values.length < argumentNames.size()&& i==values.length){
					errorMessage = premessage+"\n"+programName+".java: error: the following arguments are required: ";
					for(int j=i+1;j<argumentNames.size();j++)
						errorMessage+=argumentNames.get(j)+" ";
					error=true;
					throw new TooManyArgumentsException(errorMessage);
				
				}
				
				
			}
			else{
				if(arguments.get(argumentNames.get(i)).getType()==Argument.Type.STRING){
				arguments.get(argumentNames.get(i)).setValue(values[i]);
				}
				else if(arguments.get(argumentNames.get(i)).getType()==Argument.Type.DOUBLE){
				try{
					parseDouble(i,values[i]);
				}
			catch(NumberFormatException e){
				errorMessage = premessage+"\n"+programName+".java: error: argument "+argumentNames.get(i)+": invalid double value: "+values[i];
				error=true;
			}
		}
		else if(arguments.get(argumentNames.get(i)).getType()==Argument.Type.INTEGER){
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
		return arguments.get(name).getDescription();
		
		
	}
	private void setHelpMessage(){
		helpMessage = premessage;
		helpMessage += "\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<arguments.size();i++)
		{
			helpMessage += argumentNames.get(i)+" "+arguments.get(argumentNames.get(i)).getDescription()+"\n";
			
		}
		
		
	}
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for (String key : arguments.keySet()){
			premessage += arguments.get(key).getName()+" ";
		}
		
	}  
	

	public String getHelpMessage(){
		setHelpMessage();
		return helpMessage;
		
	}

	public <T> T getValue(String name){
		
		return (T)arguments.get(name).getValue();
	}
	private void parseDouble(int index,String value)throws NumberFormatException {
		arguments.get(argumentNames.get(index)).setValue(Double.parseDouble(value));
	}
	private void parseInteger(int index,String value){
		
		arguments.get(argumentNames.get(index)).setValue(Integer.parseInt(value));
	}
	private void parseBoolean(int index,String value){
		arguments.get(argumentNames.get(index)).setValue(Boolean.parseBoolean(value));
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public boolean getError(){
		return error;
	}
	public Argument.Type getArgumentType(String name){
		int index = argumentNames.indexOf(name);
		return arguments.get(index).getType();
		
	}
	public boolean  getHelp(){
		
		return help;
	}
	
}