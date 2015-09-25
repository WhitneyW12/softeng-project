package edu.jsu.mcis;

import java.util.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> argumentValues;
	private List<String> argumentDescriptions;
	
	public ArgsParser()
	{
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
		argumentDescriptions = new ArrayList<String>();
	}

	public void addArgumentName(String name) {
		
		argumentNames.add(name);
		argumentValues.add("");
		argumentDescriptions.add("");
	}
	public void setValue (String name, String value){
		int index = argumentNames.indexOf(name);
		argumentValues.set(index,value);
		
	}
	
	public String getArgumentValue(String name) {
		int index = argumentNames.indexOf(name);
		return argumentValues.get(index);
	}	
	public void addDescription (String name, String description){
		int index = argumentNames.indexOf(name);
		argumentDescriptions.set(index,description);
		
		
		
	}
	public String getDescription(String name)
	{
		int index = argumentNames.indexOf(name);
		return argumentDescriptions.get(index);
		
		
	}
	public String getHelpText(){
		String helptext = "";
		for(int i =0; i<argumentDescriptions.size();i++)
		{
			helptext += argumentNames.get(i)+" "+argumentDescriptions.get(i)+"\n ";
			
		}
		return helptext;
		
	}
	
	
}