package coursework;

/**Class:  	SaveEntry							Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates the record object
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class  SaveEntry
{
	public String name, date, type;
	public int val1,val2,val3,val4, ind;
	
	public SaveEntry()
	{
		
	}
	
	public SaveEntry(String n, String d, String tpe, int v1, int v2, int v3, int v4)
	{
		name = n;
		date = d;
		val1= v1;
		val2= v2;
		val3= v3;
		val4= v4;
		type = tpe;
	}
}