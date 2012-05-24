package de.dustboystudios.utils.cloner;

import junit.framework.TestCase;

/**
 * Testclass for {@link Cloner}
 *
 * @author Manuel Vögele
 */
public class TestCloner extends TestCase
{
	/**
	 * A test for simple cloning covering any types of data only generating a single clone
	 * Arrays will be tested by another method
	 * 
	 * @throws Exception if an exception occurs
	 */
	public static void testAnyDatatype() throws Exception
	{
		TestclassAnyDatatype<String> original = new TestclassAnyDatatype<String>(0, 0.0, 0.0f, false, (byte) 0, '0', (short) 0, 0L, TestclassEnum.ENUMVAL0, "0");
		TestclassAnyDatatype<String> clone = Cloner.<TestclassAnyDatatype<String>>clone(original);
		original.setB((byte) 1);
		original.setC('1');
		original.setD(1.0);
		original.setE(TestclassEnum.ENUMVAL1);
		original.setF(1.0f);
		original.setI(1);
		original.setL(1L);
		original.setO("1");
		original.setS((short) 1);
		original.setZ(true);
		assertTrue(clone.getO().equals("0"));
		assertTrue(clone.getZ() == false);
		assertTrue(clone.getB() == (byte) 0);
		assertTrue(clone.getC() == '0');
		assertTrue(clone.getD() == 0.0);
		assertTrue(clone.getE().equals(TestclassEnum.ENUMVAL0));
		assertTrue(clone.getF() == 0.0f);
		assertTrue(clone.getI() == 0);
		assertTrue(clone.getL() == 0L);
		assertTrue(clone.getS() == (short) 0);
		
	}
	
	/**
	 * A test for simple cloning generating multiple clones
	 */
	public static void testMultiClone()
	{
		fail("Not implemented yet!");
	}
	
	/**
	 * A test for cloning arrays
	 */
	public static void testCloneArrays() throws Exception
	{
		Integer i1 = Integer.valueOf(1);
		Integer i2 = Integer.valueOf(2);
		TestclassArrayholder<Integer> original = new TestclassArrayholder<Integer>(new Integer[]{i1, i2});
		TestclassArrayholder<Integer> clone = Cloner.<TestclassArrayholder<Integer>>clone(original);
		for (int i = 0;i < original.getObjects().length;i++)
		{
			assertTrue(original.getObjects()[i].equals(clone.getObjects()[i]));
		}
	}
	
	/**
	 * A test for cloning objects with a ring closure in the class structure
	 */
	public static void testRingClosure()
	{
		fail("Not implemented yet!");
	}
	
	/**
	 * A test for cloning objects with a private constructor
	 */
	public static void testPrivateConstructor()
	{
		fail("Not implemented yet!");
	}
	
	/**
	 * A test for cloning classes which have no null constructor
	 */
	public static void testNoNullConstructor()
	{
		fail("Not implemented yet!");
	}
}
