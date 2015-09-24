package edu.jsu.mcis;

public class ArgsParser{
	private String args[];
	
	public ArgsParser(String s[])
	{
		args= new String[s.length];
		for(int i =0;i<s.length;i++)
		{
			args[i]=s[i];
			
		}
		
		
	}
	
	public  float[] parseFloat(){
		float[] temp= new float[3];
		for(int i =0;i<args.length;i++)
		{
			temp[i]= Float.parseFloat(args[i]);
			
		}
		
		
		
		return temp;
		
	}

	
	
	
	
	
}