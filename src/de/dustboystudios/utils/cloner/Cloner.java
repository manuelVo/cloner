package de.dustboystudios.utils.cloner;

/**
 * <p>A class containing functionality for cloning any kind of classes.
 * Since this cloner uses reflection you should prefer using the clone method of the class if available.</p>
 * <p>Be aware that the cloner is NOT threadsafe.</p>
 * 
 * @param <T> The type of the object to clone
 *
 * @author Manuel Vögele
 */
public class Cloner<T>
{
	/**
	 * Indicates whether only a single clone should be made
	 */
	private boolean singleInstance;
	
	/**
	 * <p>Instantiates and prepares a new Cloner instance for cloning.
	 * Any clone made with that instance will have the same state as the specified object has when calling this method.</p>
	 * 
	 * <p>Only use this if you want to create multiple clones of an object.
	 * If you want to make only one clone better use the static clone method since its faster.</p>
	 * @param object The object which should be cloned
	 */
	public Cloner(T object)
	{
		this(object, false);
	}
	
	/**
	 * <p>Instantiates and prepares a new Cloner instance for cloning.
	 * This constructor is for internal use only.</p>
	 * @param object The object which should be cloned 
	 * @param singleInstance if only one instance of the cloned object should be created
	 */
	private Cloner(T object, boolean singleInstance)
	{
		this.singleInstance = singleInstance;
	}
	
	/**
	 * Returns a copy of the instance passed
	 * @return A clone which 
	 */
	public T makeClone()
	{
		return null;
	}
	
	/**
	 * Clones the specified object
	 * @param object the object to clone
	 * @return an exact copy of the specified object which is completely independent from the others
	 */
	public static <T> T clone(T object)
	{
		Cloner<T> cloner = new Cloner<T>(object);
		return cloner.makeClone();
	}
}
