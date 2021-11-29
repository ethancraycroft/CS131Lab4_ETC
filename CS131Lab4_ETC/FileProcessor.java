//********************************************************************
//FileProcessor.java       Java Foundations
//
/* Class that cycles through a file of 1 line strings and determines the length of each string. If the string is greater than a certain length, an exception is thrown. If the string is less than a certain length, it is added to an ArrayList<String>
* @author Ethan Craycroft
* @version 1.0
* Programming Lab 4 - Exception Handling
* CS-131-ON Fall 2021
//********************************************************************
*/

import java.util.*;
import java.io.*;


public class FileProcessor 
{

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor()
	{
		this.fileName = "";
		this.stringLength = 0;
	}//end empty-argument constructor
	
	public FileProcessor(String fileName, int stringLength) 
	{
		setFileName(fileName);
		setStringLength(stringLength);
	}//end preferred constructor
	
	public int getArrayListSize() 
	{
		return this.stringList.size();
	}//end getArrayListSize
	
	/**
	 * @return the fileName
	 */
	public String getFileName() 
	{
		return fileName;
	}//end getFileName

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}//end setFileName

	/**
	 * @return the stringLength
	 */
	public int getStringLength() 
	{
		return stringLength;
	}//end getStringLength

	
	/**
	 * @param stringLength the stringLength to set
	 */
	public void setStringLength(int stringLength) 
	{
		if(stringLength < 5)
		{
			stringLength = 5;
		}
		this.stringLength = stringLength;
	}//end setStringLength

	
	public void processFile()
	{
		stringList = new ArrayList<String>();
		StringTooLongException exception = new StringTooLongException("String too long!");
		File aFile = new File(fileName);
		try
		{
			input = new Scanner(aFile);
			while(input.hasNextLine())
			try
			{
			
				String output = input.nextLine();
				if(output.length() > getStringLength())
				{
					System.out.print("Unable to add: " + output + " - ");
					throw exception;
				}
				else if (output.length() <= getStringLength())
				{
					stringList.add(output);
				}
			}
			catch(StringTooLongException e)
			{
				System.out.println(e.getMessage());
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println(stringList);
	}//end processFile
	
}//end class

