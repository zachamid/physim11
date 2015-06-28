package coursework;

/**Class:  	Mthds								Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class stores Methods that will be used throughout the programme
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class Mthds 
{
	
	public static double xresvector(double ang, double mag)
	/**
	 * Used in the Circular Motion Applet
	 */
	{
		double x = mag*Math.cos(Math.toRadians(ang));
		return x;
	}
	public static double yresvector(double ang, double mag)
	/**
	 * Used in the Circular Motion Applet
	 */
	{
		double y = mag*Math.sin(Math.toRadians(ang));
		return y;
	}
	public static int calcGravForce(int r, int m,int m2)
	/**
	 * Used in the Gravitation Applet
	 */
	{
		int g = (int)(((Gravitation.G)*m*m2)/(r*r));
		return g;
	}
}