package com.technoelevate.challenge;

public  class RectangleandRadius {
	public static void area(double radius)
	{
		if(radius>=0) {
		double a=3.14*radius*radius;
		System.out.println("area of circle is:"+a);
		}
		else
		{
			System.out.println(-1.0);
		}
	}
	
	
	
	public static void area(double x,double y)
	{
		if(x>=0 && y>=0) {
		double a=x*y;
		System.out.println("area of Rectangle is:"+a);
		
	}
	else
	{
		System.out.println(-1.0);
	}
	}

}
