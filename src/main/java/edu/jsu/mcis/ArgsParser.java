package edu.jsu.mcis;

import java.util.*;
import java.lang.*;

public class ArgsParser{
	private List<String> positionalargumentNames;
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
		positionalargumentNames= new ArrayList<String>();
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
	
	public void addNamedArgument(String name, String description, Argument.Type t, int numberOfValues,Object defaultvalue,String Shorthand){
		namedArgumentsNames.add(name);
		arguments.put(name,new namedArgument(t,description,numberOfValues));
		arguments.get(name).setValue(defaultvalue);
		arguments.get(name).setShorthand(Shorthand);
		
	}
	
	public void addPositionalArgument(String name, String description, Argument.Type t){
		positionalargumentNames.add(name);
		arguments.put(name,new positionalArgument(t,description));
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
			if(!help){
				checkForLengthOfArgumentExceptions(i, values);
			}
			parsePositionalArguments(i, values);
		}
	}
	
	private void parsePositionalArguments(int i, String[] values){
		if(i<values.length&&positionalvaluesparsed<positionalargumentNames.size()){
				positionalvaluesparsed++;
				if(arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.STRING){
					arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).setValue(values[i]);
				}
				else if(arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.DOUBLE){
					try{
						parseDouble(positionalvaluesparsed-1,values[i]);
					}
					catch(NumberFormatException e){
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid double value: "+values[i];
						error = true;
						throw new NumberFormatException(errorMessage);
					}
				}
				else if(arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.INTEGER){
					parseInteger(positionalvaluesparsed-1,values[i]);
				}
				else{
					parseBoolean(positionalvaluesparsed-1,values[i]);
				}
			}
	}
	private void checkForLengthOfArgumentExceptions(int i, String[] values){
				if( positionalvaluesparsed==positionalargumentNames.size()){
					errorMessage = premessage+"\n"+programName+".java: error: unrecognized arguments: "+values[i];
					error=true;
					throw new TooManyArgumentsException(errorMessage);
				} 
				else if (values.length < positionalargumentNames.size()&& i==values.length-1){
					errorMessage = premessage+"\n"+programName+".java: error: the following arguments are required: ";
					for(int j=i+1;j<positionalargumentNames.size();j++)
						errorMessage+=positionalargumentNames.get(j)+" ";
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
		for(int i =0; i<positionalargumentNames.size();i++){
			helpMessage += positionalargumentNames.get(i)+" "+arguments.get(positionalargumentNames.get(i)).getDescription()+"\n";
		}
	}
	
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for (int i=0; i<positionalargumentNames.size();i++){
			premessage += positionalargumentNames.get(i)+" ";
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
		arguments.get(positionalargumentNames.get(index)).setValue(Double.parseDouble(value));
	}
	
	private void parseInteger(int index,String value){
		arguments.get(positionalargumentNames.get(index)).setValue(Integer.parseInt(value));
	}
	
	private void parseBoolean(int index,String value){
		arguments.get(positionalargumentNames.get(index)).setValue(Boolean.parseBoolean(value));
	}
	private void parseNamedDouble(int index,String value)throws NumberFormatException{
		arguments.get(namedArgumentsNames.get(index)).setValue(Double.parseDouble(value));
	}
	
	private void parseNamedInteger(int index,String value){
		arguments.get(namedArgumentsNames.get(index)).setValue(Integer.parseInt(value));
	}
	
	private void parseNamedBoolean(int index,String value){
		arguments.get(namedArgumentsNames.get(index)).setValue(Boolean.parseBoolean(value));
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
		boolean b = false;
		for(int j=0;j<namedArgumentsNames.size()&&i<values.length;j++){
			
			 if(values[i].equals(namedArgumentsNames.get(j))||values[i].equals(arguments.get(namedArgumentsNames.get(j)).getShorthand())){	
				boolean temp=true;
				if(arguments.get(namedArgumentsNames.get(j)).getNumberOfValues() == 0){
				arguments.get(namedArgumentsNames.get(j)).setValue(true);
				if(values[i].equals("--help")||values[i].equals("-h")){
					b=getValue("--help");
				}
				i=i+1;
				help=true;
				
				}
				
				else{
					if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.STRING){
					arguments.get(namedArgumentsNames.get(j)).setValue(values[i+1]);
				}
				else if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.DOUBLE){
					try{
						parseNamedDouble(j,values[i+1]);
					}
					catch(NumberFormatException e){
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid double value: "+values[i];
						error = true;
						throw new NumberFormatException(errorMessage);
					}
				}
				else if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.INTEGER){
					parseNamedInteger(j,values[i+1]);
				}
				else{
					parseNamedBoolean(j,values[i+1]);
				}
					i+=2;	
				}	
				help=true;
				
				j=0;
			}
		}
		
		if(b){
				
				throw new HelpMessageException(helpMessage);	
			}
		return i;
	}
	public int getNumberOfValues(String name){
		return arguments.get(name).getNumberOfValues();
	}
	
	
}