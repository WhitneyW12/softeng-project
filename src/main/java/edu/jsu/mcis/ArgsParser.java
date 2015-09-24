package edu.jsu.mcis;

import java.util.*;

public class ArgsParser{
	private List<String> argumentNames;
	private List<String> argumentValues;
	
	public ArgsParser()
	{
		argumentNames = new ArrayList<String>();
		argumentValues = new ArrayList<String>();
	}

	public void addArgumentName(String name) {
		
		argumentNames.add(name);
		argumentValues.add("");
	}
	
	public String getArgumentValue(String name) {
		int index = argumentNames.indexOf(name);
		return argumentValues.get(index);
	}	
	
	
}