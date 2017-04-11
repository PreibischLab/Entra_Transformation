package divergenceFreeVecs;

public class NotEnoughVectorsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5050861485045777735L;
	
	
	public NotEnoughVectorsException()
	{
		super ( "Not enough vectors for transformation. " );
	}
	
	public NotEnoughVectorsException( final String message )
	{
		
		super(message);
	}
	
	public NotEnoughVectorsException( final Throwable cause)
	{
		
		super( cause );
	}

	public NotEnoughVectorsException( final String message, final Throwable cause)
	{
		
		super( message, cause);
	}

}
