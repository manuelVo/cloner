package de.dustboystudios.utils.cloner;


/**
 * A testclass able to hold multiple objects using a array
 *
 * @param <T> the type of object to hold
 * 
 * @author Manuel Vögele
 */
public class TestclassObjectholder<T>
{
	/**
	 * The array for the objects
	 */
	private T[] objects;
	
	/**
	 * Initializes a objectholder not setting the array
	 */
	public TestclassObjectholder()
	{
	}
	
	/**
	 * Initializes the objectholder
	 * 
	 * @param objects the array of objects
	 */
	public TestclassObjectholder(T[] objects)
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
