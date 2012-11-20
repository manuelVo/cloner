package de.dustboystudios.utils.cloner;

/**
 * Thrown if cloning an object fails
 *
 * @author Manuel Vögele
 */
public class CloningException extends ReflectiveOperationException
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9154297281507719632L;

	/**
    * Constructs a new exception with {@code null} as its detail
    * message.  The cause is not initialized, and may subsequently be
    * initialized by a call to {@link #initCause}.
    */
	public CloningException()
	{
		super();
	}
	
   /**
    * Constructs a new exception with the specified detail message
    * and cause.
    *
    * <p>Note that the detail message associated with
    * {@code cause} is <em>not</em> automatically incorporated in
    * this exception's detail message.
    *
    * @param  message the detail message (which is saved for later retrieval
    *         by the {@link #getMessage()} method).
    * @param  cause the cause (which is saved for later retrieval by the
    *         {@link #getCause()} method).  (A {@code null} value is
    *         permitted, and indicates that the cause is nonexistent or
    *         unknown.)
    */
	public CloningException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
    * Constructs a new exception with the specified detail message.
    * The cause is not initialized, and may subsequently be
    * initialized by a call to {@link #initCause}.
    *
    * @param   message   the detail message. The detail message is saved for
    *          later retrieval by the {@link #getMessage()} method.
    */
	public CloningException(String message)
	{
		super(message);
	}

	/**
    * Constructs a new exception with the specified cause and a detail
    * message of {@code (cause==null ? null : cause.toString())} (which
    * typically contains the class and detail message of {@code cause}).
    *
    * @param  cause the cause (which is saved for later retrieval by the
    *         {@link #getCause()} method).  (A {@code null} value is
    *         permitted, and indicates that the cause is nonexistent or
    *         unknown.)
    */
	public CloningException(Throwable cause)
	{
		super(cause);
	}
	
}
