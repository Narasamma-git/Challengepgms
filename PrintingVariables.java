package com.technoelevate.challenge;

public class PrintingVariables {
	public static  void printEqual(int a,int b,int c)
	{
		if(a<0 || b<0 || c<0)
		{
			System.out.println("invalid value");
		}
		else if(a==b && b==c && c==a)
		{
			System.out.println("all numbers are equal");
		}
		
		else if(a!=b && b!=c && c!=a)
		{
			System.out.println("all numbers are different");
		}
		else
			System.out.println("neitheer all are equal or different");
	}
public static void main(String[] args)
{
	printEqual(10,-80,30);
	printEqual(10,10,10);
	printEqual(10,20,30);
	
	}
}
