package coursework;

import java.io.IOException;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class has the methods that sorts, searches, and displays the data on the table in the UI LoadScreen
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class SortSearchNDisplay 
{
	final static int MAXSTACK = 100;		//Maximum no of records that can be stored
	int top = -1;							//Variable that keeps track of the top records in the array
	DisplaySaveEntry [] dse =  new DisplaySaveEntry[MAXSTACK];	//The array that temporarily stores the records for the table
	
	public SortSearchNDisplay(PersistentSaveArray p) throws IOException
	{
		for(int c = 0; c < p.numRecords();c++)
		{
			SaveEntry se = p.get(c);
			DisplaySaveEntry dsplySvNtry=new DisplaySaveEntry(); 
			dsplySvNtry.name = se.name;
			dsplySvNtry.date = se.date;
			dsplySvNtry.recNumber = c+1;
			dsplySvNtry.type = se.type;
			push(dsplySvNtry);
			//Takes the records from the Binary File and stores them in the Display Record array index 
		}
	}
	public SortSearchNDisplay(String[][] s)
	{
		for(int c = 0;c<s.length;c++)
		{
			DisplaySaveEntry dsplySvNtry=new DisplaySaveEntry(); 
			dsplySvNtry.name = s[c][1];
			dsplySvNtry.date = s[c][3];
			dsplySvNtry.recNumber = Integer.parseInt(s[c][0]);
			dsplySvNtry.type = s[c][2];
			push(dsplySvNtry);
		}
	}
	public DisplaySaveEntry[] sortByName()
	{
		DisplaySaveEntry[] domain = dse;
		if (totalSize() == 1)
    	{
    		return domain;
    	}
    	DisplaySaveEntry[] a = new DisplaySaveEntry[totalSize()/2 ];
    	DisplaySaveEntry[] b = new DisplaySaveEntry[totalSize() - a.length ];
    	for(int curA = 0; curA < a.length; curA++)
    	{
    		a[curA]= domain[curA];
    	}
    	for(int curB = 0; curB<b.length; curB++)
    	{
    		b[curB] = domain[curB+a.length];
    	}
    	// Sort each half
    	DisplaySaveEntry[] newA = sortByName(a);
    	DisplaySaveEntry[] newB = sortByName(b);
    	// Merge them together
    	DisplaySaveEntry[] result = sortByName(newA,newB);
    	return result;
    }
	public DisplaySaveEntry[] sortByName(DisplaySaveEntry[] s)
	{
		if (s.length == 1)
    	{
    		return s;
    	}
    	DisplaySaveEntry[] a = new DisplaySaveEntry[ s.length/2 ];
    	DisplaySaveEntry[] b = new DisplaySaveEntry[ s.length - a.length ];
    	for(int curA = 0; curA < a.length; curA++)
    	{
    		a[curA]= s[curA];
    	}
    	for(int curB = 0; curB<b.length; curB++)
    	{
    		b[curB] = s[curB+a.length];
    	}
    	// Sort each half
    	DisplaySaveEntry[] newA = sortByName(a);
    	DisplaySaveEntry[] newB = sortByName(b);
    	// Merge them together
    	DisplaySaveEntry[] result = sortByName(newA,newB);
    	return result;
    }
	
	public static DisplaySaveEntry[] sortByName(DisplaySaveEntry first[],DisplaySaveEntry second[])
	{
		DisplaySaveEntry [] result = new DisplaySaveEntry [first.length+second.length];
		int firstcounter = 0;
		int seccounter = 0;
		int currentR = 0;
		while (currentR < result.length && firstcounter < first.length && seccounter <second.length)
		{
			if ((first[firstcounter].name.compareTo(second[seccounter].name))<0)
			{
				result[currentR] = first[firstcounter];
				firstcounter++;
			}
			else
			{
				result[currentR] = second[seccounter];
				seccounter++;
			}
			currentR = currentR+1;
		}
		if (firstcounter <first.length)
		{
			for(;firstcounter < first.length;firstcounter++)
			{
				result[currentR] = first[firstcounter];
				currentR++;
			}
		}
		else if (seccounter < second.length)
		{
			for(;seccounter < second.length;seccounter++)
			{
				result[currentR]= second[seccounter];
				currentR++;
			}
		}
		return result;
	}
	public DisplaySaveEntry[] sortByDate()
	{
		DisplaySaveEntry[] domain = dse;
		if (totalSize() == 1)
    	{
    		return domain;
    	}
    	DisplaySaveEntry[] a = new DisplaySaveEntry[totalSize()/2 ];
    	DisplaySaveEntry[] b = new DisplaySaveEntry[totalSize() - a.length ];
    	for(int curA = 0; curA < a.length; curA++)
    	{
    		a[curA]= domain[curA];
    	}
    	for(int curB = 0; curB<b.length; curB++)
    	{
    		b[curB] = domain[curB+a.length];
    	}
    	// Sort each half
    	DisplaySaveEntry[] newA = sortByDate(a);
    	DisplaySaveEntry[] newB = sortByDate(b);
    	// Merge them together
    	DisplaySaveEntry[] result = sortByDate(newA,newB);
    	return result;
    }
	public DisplaySaveEntry[] sortByDate(DisplaySaveEntry[] s)
	{
		if (s.length == 1)
    	{
    		return s;
    	}
    	DisplaySaveEntry[] a = new DisplaySaveEntry[ s.length/2 ];
    	DisplaySaveEntry[] b = new DisplaySaveEntry[ s.length - a.length ];
    	for(int curA = 0; curA < a.length; curA++)
    	{
    		a[curA]= s[curA];
    	}
    	for(int curB = 0; curB<b.length; curB++)
    	{
    		b[curB] = s[curB+a.length];
    	}
    	// Sort each half
    	DisplaySaveEntry[] newA = sortByDate(a);
    	DisplaySaveEntry[] newB = sortByDate(b);
    	// Merge them together
    	DisplaySaveEntry[] result = sortByDate(newA,newB);
    	return result;
    }
	
	public static DisplaySaveEntry[] sortByDate(DisplaySaveEntry first[],DisplaySaveEntry second[])
	{
		DisplaySaveEntry [] result = new DisplaySaveEntry [first.length+second.length];
		int firstcounter = 0;
		int seccounter = 0;
		int currentR = 0;
		while (currentR < result.length && firstcounter < first.length && seccounter <second.length)
		{
			if ((first[firstcounter].date.compareTo(second[seccounter].date))<0)
			{
				result[currentR] = first[firstcounter];
				firstcounter++;
			}
			else
			{
				result[currentR] = second[seccounter];
				seccounter++;
			}
			currentR = currentR+1;
		}
		if (firstcounter <first.length)
		{
			for(;firstcounter < first.length;firstcounter++)
			{
				result[currentR] = first[firstcounter];
				currentR++;
			}
		}
		else if (seccounter < second.length)
		{
			for(;seccounter < second.length;seccounter++)
			{
				result[currentR]= second[seccounter];
				currentR++;
			}
		}
		return result;
	}
	public String[][] search(String m)
	//Search function
	{
		String [][] rtrn = new String[totalSize()][4];
		int cntr = 0;
		for(int x = 0; x<totalSize(); x++)
		{
			if(dse[x].name.indexOf(m)>=0)
			{
				rtrn[cntr][0] ="" + (dse[x].recNumber);
				rtrn[cntr][1] ="" + (dse[x].name);
				rtrn[cntr][2] ="" + (dse[x].type);
				rtrn[cntr][3] ="" + (dse[x].date);
				cntr++;
			}
		}
		return rtrn;
	}
	public String[][] searchByType(String m)
	//Search function
	{
		String [][] rtrn = new String[totalSize()][4];
		int cntr = 0;
		for(int x = 0; x<totalSize(); x++)
		{
			if(dse[x].type.equals(m))
			{
				rtrn[cntr][0] ="" + (dse[x].recNumber);
				rtrn[cntr][1] ="" + (dse[x].name);
				rtrn[cntr][2] ="" + (dse[x].type);
				rtrn[cntr][3] ="" + (dse[x].date);
				cntr++;
			}
		}
		return rtrn;
	}
	public String[][] turnToTable()
	//turns the DisplaySaveEntry Array into a 2-D String Array
	{
		String [][] rtrn = new String[totalSize()][4];
		for(int x = 0; x < totalSize(); x++)
		{
			DisplaySaveEntry d = dse[x];
			rtrn[x][0] = "" + (d.recNumber);
			rtrn[x][1] = d.name;
			rtrn[x][2] = d.type;
			rtrn[x][3] = d.date;
		}
		return rtrn;
	}
	public String[][] turnToTable(DisplaySaveEntry[] s)
	{
		String [][] rtrn = new String[s.length][4];
		for(int x = 0; x < s.length; x++)
		{
			rtrn[x][0] = "" + (s[x].recNumber);
			rtrn[x][1] = s[x].name;
			rtrn[x][2] = s[x].type;
			rtrn[x][3] = s[x].date;
		}
		return rtrn;
	}
	public boolean isEmpty()				//True if all the indices are free
	{
		return (top==-1);
	}
	public boolean isFull()					//True if all the indices have been used
	{
		return (top==99);
	}
	public int totalSize()					//returns the total size of the array
	{
		return top+1;
	}
	public void push(DisplaySaveEntry n)	//add
	{
		if(top==MAXSTACK)
		{
			System.out.println("Stack Overflow");
			System.exit(1);
		}
		else
		{
			top++;
			dse[top] = n;
		}
	}
	public DisplaySaveEntry pop() //delete//
	{
		DisplaySaveEntry hold = new DisplaySaveEntry();
		if(isEmpty())
		{
			System.out.println("Attempt to pop an empty stack");
			System.exit(1);
		}
		else
		{
			hold = dse[top];
			dse[top] = null;
			top--;
		}
		return hold;
	}
}