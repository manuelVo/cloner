package de.dustboystudios.utils.cloner;

import java.lang.reflect.Field;
import java.util.Set;

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
	 * A reference object to create the clones from
	 */
	private T referenceObject;
	
	private Set<Reference> objects;
	
	/**
	 * <p>Instantiates and prepares a new Cloner instance for cloning.
	 * Any clone made with that instance will have the same state as the specified object has when calling this method.</p>
	 * 
	 * <p>Only use this if you want to create multiple clones of an object.
	 * If you want to make only one clone better use the static clone method since its faster.</p>
	 * @param object The object which should be cloned
	 * @throws IllegalAccessException if there is a problem when accessing a field
	 */
	public Cloner(T object) throws IllegalAccessException
	{
		this(object, false);
	}
	
	/**
	 * <p>Instantiates and prepares a new Cloner instance for cloning.
	 * This constructor is for internal use only.</p>
	 * @param object The object which should be cloned 
	 * @param singleInstance if only one instance of the cloned object should be created
	 * @throws IllegalAccessException if there is a problem when accessing a field
	 */
	private Cloner(T object, boolean singleInstance) throws IllegalAccessException
	{
		referenceObject = object;
		index(object);
		if (!singleInstance) {
			referenceObject = makeClone();
		}
	}
	
	/**
	 * Adds the specified object and all contained objects to the index
	 * 
	 * @param object the object to index
	 * @throws IllegalAccessException if there is a problem when accessing a field
	 */
	public void index(Object object) throws IllegalAccessException
	{
		Reference ref = new Reference(object);
		if (!objects.contains(ref))
		{
			objects.add(ref);
			for (Field field : object.getClass().getFields())
			{
				field.setAccessible(true);
				if (!field.getType().isPrimitive()) {
					index(field.get(object));
				}
			}
		}
	}
	
	/**
	 * Returns a copy of the instance passed to the constructor.
	 * The clone will have the state the instance had when it was passed to the constructor.
	 * 
	 * @return the clone
	 */
	public T makeClone()
	{
		return null;
	}
	
	/**
	 * Clones the specified object
	 * @param object the object to clone
	 * @return an exact copy of the specified object which is completely independent from the others
	 * @throws IllegalAccessException if there is a problem when accessing a field
	 */
	public static <T> T clone(T object) throws IllegalAccessException
	{
		Cloner<T> cloner = new Cloner<T>(object);
		return cloner.makeClone();
	}
}
