package de.dustboystudios.utils.cloner;


/**
 * A testclass able to hold multiple objects using a array
 *
 * @param <T> the type of object to hold
 * 
 * @author Manuel Vögele
 */
public class TestclassArrayholder<T>
{
	/**
	 * The array for the objects
	 */
	private T[] objects;
	
	/**
	 * Initializes a arrayholder not setting the array
	 */
	public TestclassArrayholder()
	{
	}
	
	/**
	 * Initializes the arrayholder
	 * 
	 * @param objects the array of objects
	 */
	public TestclassArrayholder(T[] objects)
	{
		this.objects = objects;
	}
	
	/**
	 * Returns the stored object array
	 * 
	 * @return the stored object array
	 */
	public T[] getObjects()
	{
		return objects;
	}
}
