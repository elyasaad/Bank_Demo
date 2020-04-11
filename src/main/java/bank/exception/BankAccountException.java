package bank.exception;



import java.lang.Exception;

public class BankAccountException extends Exception
{	

	private static final long serialVersionUID = 1L;

	
	public BankAccountException(String message)
	{
		super(message);
		count++;
	}
	
	
	public static int getCount()
	{
		return count; 
	}
	
	
	public String getMessage()
	{
		return super.getMessage();
	}
	
	
	private static int count = 0; 
}
