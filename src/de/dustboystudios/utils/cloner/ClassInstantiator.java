package de.dustboystudios.utils.cloner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import sun.reflect.ReflectionFactory;

/**
 * A class containing methods for instantiating classes without calling a constructor
 *
 * @author Manuel Vögele
 */
public class ClassInstantiator
{
	/**
	 * Returns a instance of the specified class without calling the constructor
	 * @param clazz the class to instantiate
	 * @return a instance of the specified class
	 * @throws CloningException if something goes wrong while instantiating - this should never be thrown
	 */
	public static <T> T newInstance(Class<T> clazz) throws CloningException
	{
		ReflectionFactory factory = ReflectionFactory.getReflectionFactory();
		try
		{
			Constructor<?> constructor = factory.newConstructorForSerialization(clazz, Object.class.getDeclaredConstructor());
			return clazz.cast(constructor.newInstance());
		}
		catch (NoSuchMethodException e)
		{
			throw new CloningException("Cannot instantiate " + clazz.getName() + " - this should never happen", e);
		}
		catch (InvocationTargetException e)
		{
			throw new CloningException("Cannot instantiate " + clazz.getName() + " - this should never happen", e);
		}
		catch (InstantiationException e)
		{
			throw new CloningException("Cannot instantiate " + clazz.getName() + " - this should never happen", e);
		}
		catch (IllegalAccessException e)
		{
			throw new CloningException("Cannot instantiate " + clazz.getName() + " - this should never happen", e);
		}
	}
}
