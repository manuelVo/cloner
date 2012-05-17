package de.dustboystudios.utils.cloner;

import junit.framework.TestCase;

public class TestReference extends TestCase
{
	public void testEquals()
	{
		Object o1 = new Object();
		Object o2 = new Object();
		Reference same1 = new Reference(o1);
		Reference same2 = new Reference(o1);
		Reference different = new Reference(o2);
		assertSame(same1.getObject(), same2.getObject());
		assertNotSame(same1.getObject(), different.getObject());
		assertEquals(same1, same2);
		assertFalse(same1.equals(different));
	}
	
	public void testHashCode()
	{
		Object o1 = new Object();
		Reference same1 = new Reference(o1);
		Reference same2 = new Reference(o1);
		assertEquals(same1.hashCode(), same2.hashCode());
	}
}
