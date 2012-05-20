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
		TestclassAnyDatatype<String> testclass = new TestclassAnyDatatype<String>(0, 0.0, 0.0f, false, (byte) 0, '0', (short) 0, 0L, TestclassEnum.ENUMVAL0, "0");
		TestclassAnyDatatype<String> clone = Cloner.<TestclassAnyDatatype<String>>clone(testclass);
		testclass.setB((byte) 1);
		testclass.setC('1');
		testclass.setD(1.0);
		testclass.setE(TestclassEnum.ENUMVAL1);
		testclass.setF(1.0f);
		testclass.setI(1);
		testclass.setL(1L);
		testclass.setO("1");
		testclass.setS((short) 1);
		testclass.setZ(true);
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
