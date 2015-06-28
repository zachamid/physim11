package coursework;

/**Class:  	PersistentSaveArray					Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class will manage the binary file and all the methods associated with it
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PersistentSaveArray 
{
	private final static short NAME = 10;//22
	private final static short DATE = 16;//34 + 16
	private final static short TYPE = 16;//34
	private final static short RECLENGTH = 106;
	/**
	 * The three constants will determine how large each individual 
	 * record will be
	 */
	private RandomAccessFile raf;
	
	PersistentSaveArray(String flname) throws FileNotFoundException
	{
		raf = new RandomAccessFile(flname, "rw");
	}
	
	void writeString(String s, int maxl) throws IOException
	/**
	 * this method will truncate the given string to the maximum size
	 * OR
	 * concatenate empty characters to the end of it, if it is to short
	 */
	{
		if(s.length()>maxl)
		{
			s=s.substring(0, maxl);
		}
		raf.writeShort(s.length());
		for(int u = 0; u<(s.length()); u++)
		{
			raf.writeChar(s.charAt(u));
		}
		
		for(int u = 0; u<(maxl-s.length()); u++)
		{
			raf.writeChar(' ');
		}
	}
	void add(SaveEntry se) throws IOException
	/**
	 * This method will save an Object SaveEntry to the Binary File
	 * AND
	 * Add a DisplaySaveEntry object to the end of the stack object
	 */
	{
		save(se, numRecords());
	}
	
	int numRecords() throws IOException
	/**
	 * It will return the number of records saved, by taking the
	 * total length and dividing it by the Record Length constant
	 */
	{
		int fileLength = (int)raf.length()/RECLENGTH;
		return fileLength;
	}
	
	void save (SaveEntry se, int lstndx) throws IOException
	/**
	 * This will actually write the data to the Binary File
	 */
	{
		raf.seek((lstndx)*RECLENGTH);
		this.writeString(se.name, NAME);
		this.writeString(se.date, DATE);
		this.writeString(se.type, TYPE);
		raf.writeInt(se.val1);
		raf.writeInt(se.val2);
		raf.writeInt(se.val3);
		raf.writeInt(se.val4);
		raf.getChannel().force(true);
	}
	
	String getString (short MaxLength) throws IOException
	/**
	 * It will return a string without the spaces that were originally
	 * put in
	 */
	{
		String s= "";
		int stringLength=raf.readShort();
		for (int i = 0; i<stringLength;i++)
		{
			s=s+raf.readChar();
		}
		for (int i = stringLength; i<MaxLength;i++)
		{
			raf.readChar();
		}
		return s;
	}
	SaveEntry get (int lstndx) throws IOException
	/**
	 * It will return a SaveEntry Object at the given index by:
	 * -Seeking its start point
	 * -reading each data structure
	 */
	{
		raf.seek((lstndx)*RECLENGTH);
		SaveEntry se = new SaveEntry();
		se.name = this.getString(NAME);
		se.date = this.getString(DATE);
		se.type = this.getString(TYPE);
		se.val1 = raf.readInt();
		se.val2 = raf.readInt();
		se.val3 = raf.readInt();
		se.val4 = raf.readInt();
		return se;
	}
	
	void deleteAll() throws IOException
	/**
	 * It will clear the entire Binary File and Stack array
	 */
	{
		raf.setLength(0);
	}
	void delete(int rcdno) throws IOException
	/**
	 * It will erase the requested record from both the Binary File
	 * and the Stack array
	 */
	{
		SaveEntry se = get(numRecords()-1);
		save(se, rcdno);
		raf.setLength((numRecords()-1)*RECLENGTH);
	}
}