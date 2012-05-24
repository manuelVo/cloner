package de.dustboystudios.utils.cloner;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
	
	/**
	 * Storing the clones which were already created
	 */
	private Map<Reference, Object> clones;
	
	/**
	 * <p>Instantiates and prepares a new Cloner instance for cloning.
	 * Any clone made with that instance will have the same state as the specified object has when calling this method.</p>
	 * 
	 * <p>Only use this if you want to create multiple clones of an object.
	 * If you want to make only one clone better use the static clone method since its faster.</p>
	 * @param object The object which should be cloned
	 * @throws IllegalAccessException if there is a problem when accessing a field or the constructor
	 * @throws InstantiationException if there is a problem instantiating a new object
	 */
	public Cloner(T object) throws IllegalAccessException, InstantiationException
	{
		this(object, false);
	}
	
	/**
	 * <p>Instantiates and prepares a new Cloner instance for cloning.
	 * This constructor is for internal use only.</p>
	 * @param object The object which should be cloned 
	 * @param singleInstance if only one instance of the cloned object should be created
	 * @throws IllegalAccessException if there is a problem when accessing a field or the constructor
	 * @throws InstantiationException if there is a problem instantiating a new object
	 */
	private Cloner(T object, boolean singleInstance) throws IllegalAccessException, InstantiationException
	{
		referenceObject = object;
		clones = new HashMap<Reference, Object>();
		if (!singleInstance) {
			referenceObject = makeClone();
		}
	}
	
	/**
	 * Returns a copy of the instance passed to the constructor.
	 * The clone will have the state the instance had when it was passed to the constructor.
	 * 
	 * @return the clone
	 * @throws InstantiationException if there is a problem instantiating a new object
	 * @throws IllegalAccessException if there is a problem when accessing a field or the constructor
	 */
	@SuppressWarnings("unchecked")
	public T makeClone() throws IllegalAccessException, InstantiationException
	{
		return (T) cloneObjectByType(referenceObject);
	}
	
	/**
	 * Creates a clone of the passed object
	 * 
	 * @param original the object to clone
	 * @return the clone
	 * @throws InstantiationException if there is a problem instantiating a new object
	 * @throws IllegalAccessException if there is a problem when accessing a field or the constructor
	 */
	private Object makeClone(Object original) throws IllegalAccessException, InstantiationException
	{
		Class<? extends Object> clazz = original.getClass();
		Object clone = clazz.newInstance();
		Reference ref = new Reference(original);
		clones.put(ref, clone);
		for (Field field : clazz.getDeclaredFields())
		{
			field.setAccessible(true);
			Class<?> type = field.getType();
			if (!type.isPrimitive())
			{
				field.set(clone, cloneObjectByType(field.get(original)));
			}
			else if (type.equals(int.class))
			{
				field.setInt(clone, field.getInt(original));
			}
			else if (type.equals(double.class))
			{
				field.setDouble(clone, field.getDouble(original));
			}
			else 
			{
				// TODO Implement rest of primitive types
				field.set(clone, field.get(original));
			}
		}
		return clone;
	}
	
	/**
	 * Returns a clone of the specified object.
	 * @param original the object
	 * @return the clone
	 * @throws InstantiationException if there is a problem instantiating a new object
	 * @throws IllegalAccessException if there is a problem when accessing a field or the constructor
	 */
	private Object cloneObjectByType(Object original) throws InstantiationException, IllegalAccessException
	{
		Reference valueRef = new Reference(original);
		Object clonedValue;
		Class<?> type = original.getClass();
		if (type.isEnum())
		{
			clonedValue = original;
		}
		else if (clones.containsKey(valueRef))
		{
			clonedValue = clones.get(valueRef);
		}
		else
		{
			clonedValue = makeClone(original);
		}
		return clonedValue;
	}
	
	/**
	 * Clones the specified object
	 * @param object the object to clone
	 * @return an exact copy of the specified object which is completely independent from the others
	 * @throws InstantiationException if there is a problem instantiating a new object
	 * @throws IllegalAccessException if there is a problem when accessing a field or the constructor
	 */
	public static <T> T clone(T object) throws IllegalAccessException, InstantiationException
	{
		Cloner<T> cloner = new Cloner<T>(object);
		return cloner.makeClone();
	}
}
