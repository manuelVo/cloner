package de.dustboystudios.utils.cloner;

/**
 * A class able to hold an object which is linked to another TestclassLinkedObjectHolder
 * 
 * @param <T> the type of the object to hold
 *
 * @author Manuel Vögele
 */
public class TestclassLinkedObjectholder<T> extends TestclassObjectholder<T>
{
	/**
	 * The next instance
	 */
	private TestclassLinkedObjectholder<T> next;
	
	/**
	 * Initializes a new instance setting no values
	 */
	public TestclassLinkedObjectholder()
	{
		super();
	}
	
	/**
	 * Initializes a new instance
	 * @param object the object to hold
	 */
	public TestclassLinkedObjectholder(T object)
	{
		super(object);
	}
	
	/**
	 * Sets the next {@link TestclassLinkedObjectholder}
	 * @param next the next instance
	 */
	public void setNext(TestclassLinkedObjectholder<T> next)
	{
		this.next = next;
	}
	
	/**
	 * Returns the next {@link TestclassLinkedObjectholder}
	 * @return the next instance
	 */
	public TestclassLinkedObjectholder<T> getNext()
	{
		return next;
	}
}
