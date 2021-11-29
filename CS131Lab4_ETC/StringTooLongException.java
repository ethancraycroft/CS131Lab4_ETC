//********************************************************************
//StringTooLongException.java       Java Foundations
//
/* A class that extends Exception - is thrown if the string involved is greater than a certain length. 
* @author Ethan Craycroft
* @version 1.0
* Programming Lab 4 - Exception Handling
* CS-131-ON Fall 2021
//********************************************************************
*/
@SuppressWarnings("serial")
public class StringTooLongException extends Exception
{

	public StringTooLongException(String message)
	{
		super(message);
	}
}
