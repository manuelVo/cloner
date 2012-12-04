package de.dustboystudios.utils.cloner;

/**
 * A class for holding a final object
 * 
 * @param <T>
 *           the type of the object
 * 
 * @author Manuel Vögele
 */
public class TestclassFinalVariable<T>
{
	/**
	 * The object held
	 */
	private final T object;

	/**
	 * Initializes a new instance and sets the object
	 * 
	 * @param object
	 *           the object
	 */
	public TestclassFinalVariable(T object)
	{
		this.object = object;
	}

	/**
	 * Returns the object held
	 * 
	 * @return the object held
	 */
	public T getObject()
	{
		return object;
	}
}
