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
	private int numofNamedArgValues;
	private int positionalvaluesparsed;
	
	public ArgsParser(){
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
		numofNamedArgValues = 0;
		positionalvaluesparsed = 0;
	}
	
	public void addNamedArgument(String name, String description, Argument.Type t, int numberOfValues,Object defaultvalue,String[] restrictedValues){
		namedArgumentsNames.add(name);
		arguments.put(name,new namedArgument(t,description,numberOfValues, restrictedValues));
		arguments.get(name).setValue(defaultvalue);
		arguments.get(name).setHasRestricted(true);
	}
	
	public void addNamedArgument(String name, String description, Argument.Type t, int numberOfValues, Object defaultvalue){
		addNamedArgument(name,description,t,numberOfValues,defaultvalue,null);
		arguments.get(name).setHasRestricted(false);
	}
	
	public void addArgument(String name, String description, Argument.Type t){
		argumentNames.add(name);
		arguments.put(name,new Argument(t,description));
		setPremessage();
	}
	
	private void setnumberofNamedargumentvalues(){
		for(int i =0;i<namedArgumentsNames.size();i++){
			numofNamedArgValues+=arguments.get(namedArgumentsNames.get(i)).getNumberOfValues();
		}
	}
	
	public void parseValues (String[] values){
		for(int i=0;i<values.length;i++){
			help = false;
			i = parseNamedArguments(i, values);
			setnumberofNamedargumentvalues();
			if(values.length != argumentNames.size()&&!help){
				checkForLengthOfArgumentExceptions(i, values);
			}
			parsePositionalArguments(i, values);
		}
	}
	
	private void parsePositionalArguments(int i, String[] values){
		if(i<values.length){
				positionalvaluesparsed++;
				if(arguments.get(argumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.STRING){
					arguments.get(argumentNames.get(positionalvaluesparsed-1)).setValue(values[i]);
				}
				else if(arguments.get(argumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.DOUBLE){
					try{
						parseDouble(positionalvaluesparsed-1,values[i]);
					}
					catch(NumberFormatException e){
						errorMessage = premessage+"\n"+programName+".java: error: argument "+argumentNames.get(i)+": invalid double value: "+values[i];
						error = true;
						throw new NumberFormatException(errorMessage);
					}
				}
				else if(arguments.get(argumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.INTEGER){
					parseInteger(positionalvaluesparsed-1,values[i]);
				}
				else{
					parseBoolean(positionalvaluesparsed-1,values[i]);
				}
			}
	}
	private void checkForLengthOfArgumentExceptions(int i, String[] values){
				if( positionalvaluesparsed==argumentNames.size()){
					errorMessage = premessage+"\n"+programName+".java: error: unrecognized arguments: "+values[i];
					error=true;
					throw new TooManyArgumentsException(errorMessage);
				} 
				else if (values.length < argumentNames.size()&& i==values.length-1){
					errorMessage = premessage+"\n"+programName+".java: error: the following arguments are required: ";
					for(int j=i+1;j<argumentNames.size();j++)
						errorMessage+=argumentNames.get(j)+" ";
						error=true;
						throw new TooFewArgumentsException(errorMessage);
					}
				}

	public void addProgram(String name,String description){
		programName = name;
		programDescription = description;
		setPremessage();
	}
	
	public String getDescription(String name){
		return arguments.get(name).getDescription();
	}
	
	private void setHelpMessage(){
		helpMessage = premessage;
		helpMessage += "\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<argumentNames.size();i++){
			helpMessage += argumentNames.get(i)+" "+arguments.get(argumentNames.get(i)).getDescription()+"\n";
		}
	}
	
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for (int i=0; i<argumentNames.size();i++){
			premessage += argumentNames.get(i)+" ";
		}
	}  
	
	public String getHelpMessage(){
		setHelpMessage();
		return helpMessage;
	}

	public <T> T getValue(String name){
		return (T)arguments.get(name).getValue();
	}
	
	private void parseDouble(int index,String value)throws NumberFormatException{
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
		return arguments.get(name).getType();
	}
	
	private int parseNamedArguments(int i, String[] values){
		for(int j=0;j<namedArgumentsNames.size();j++){
			if(values[i].equals("-h")||values[i].equals("--help")){
				help=true;
				throw new HelpMessageException(helpMessage);	
			}
			if(values[i].equals(namedArgumentsNames.get(j))){	
				boolean temp=true;
				if(arguments.get(namedArgumentsNames.get(j)).getHasRestricted()){
					String[] restrictedValues = arguments.get(namedArgumentsNames.get(j)).getRestrictedValues();
					for(int k =0; k<restrictedValues.length;k++){
						if(values[i+1].equals(restrictedValues[k])){
							arguments.get(namedArgumentsNames.get(j)).setValue(values[i+1]);
							i+=2;
							temp=false;
							k=restrictedValues.length;
						}	
					}
					if(temp){	
						throw new RestrictedValuesException("");
					}
				}
				else{
					arguments.get(namedArgumentsNames.get(j)).setValue(values[i+1]);
					i+=2;	
				}	
				help=true;
			}
		}
		return i;
	}
	
	public boolean getHelp(){
		return help;
	}
	
}