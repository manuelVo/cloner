package de.dustboystudios.utils.cloner;

/**
 * A class able to hold an object
 * 
 * @param <T>
 *           the type of the object to hold
 * 
 * @author Manuel Vögele
 */
public class TestclassObjectholder<T>
{
	/**
	 * The object held by this class
	 */
	private T object;

	/**
	 * Initializes a new instance setting no values
	 */
	public TestclassObjectholder()
	{
	}

	/**
	 * Initializes a new instance
	 * 
	 * @param object
	 *           the object to hold
	 */
	public TestclassObjectholder(T object)
	{
		this.object = object;
	}

	/**
	 * Set a new object to hold
	 * 
	 * @param object
	 *           the new object to hold
	 */
	public void setObject(T object)
	{
		this.object = object;
	}

	/**
	 * Returns the held object
	 * 
	 * @return the held object
	 */
	public T getObject()
	{
		return object;
	}
}
