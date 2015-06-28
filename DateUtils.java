package coursework;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class stores the method required to store the date and Time
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class DateUtils 
{
	  public static final String DATE_FORMAT_NOW = "yyyy/MM/dd HH:mm:ss";
	  //The above constant stores the format in which the date will be stored
	  public static String now() {
	    Calendar cal = Calendar.getInstance();	//Creating a Calendar object
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);	
	    //Creating a date template
	    return sdf.format(cal.getTime());
	    //Applying the current time to the template
	  }
}