package com.technoelevate.challenge;

public class Timeprogram {
	public static void  getDurationString(int min,int sec)
	{ 
		int hour=0;
		int min1=0;
		int sec2=0;
	
		if(min>=0 || sec>=0 && sec<=59) 
		{
			hour=min/60;
			min1=sec/60;
			sec2=sec%60;
			
		}
		else
		{
			System.out.println("invalid value");
		}
		System.out.println("0"+hour+"h"+" "+"0"+min1+"m"+" "+"0"+sec2+"s");
	}
	
	public static void  getDurationString(int sec)
	{
		int min=0;
		int sec1=0;
		if( sec>=0) 
		{
			 min=sec/60;
			 sec1=sec%60;
			
		}
		else
		{
			System.out.println("invalid value");
		}
		getDurationString(min,sec1);
		
	}
	
	
	
	

}
