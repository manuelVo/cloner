package de.dustboystudios.utils.cloner;

import junit.framework.TestCase;

import org.junit.Test;

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
	@Test
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
		assertEquals("0", clone.getO());
		assertFalse(clone.getZ());
		assertEquals((byte) 0, clone.getB());
		assertEquals('0', clone.getC());
		assertEquals(0.0, clone.getD(), 0);
		assertEquals(TestclassEnum.ENUMVAL0, clone.getE());
		assertEquals(0.0f, clone.getF(), 0);
		assertEquals(0, clone.getI());
		assertEquals(0L, clone.getL());
		assertEquals((short) 0, clone.getS());
	}
	
	/**
	 * A test for simple cloning generating multiple clones
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testMultiClone() throws Exception
	{
		TestclassObjectholder<Integer> obj = new TestclassObjectholder<Integer>(new Integer(1));
		Cloner<TestclassObjectholder<Integer>> cloner = new Cloner<TestclassObjectholder<Integer>>(obj);
		obj.setObject(new Integer(2));
		TestclassObjectholder<Integer> clone1 = cloner.makeClone();
		TestclassObjectholder<Integer> clone2 = cloner.makeClone();
		clone1.setObject(new Integer(3));
		assertEquals(2, obj.getObject().intValue());
		assertEquals(1, clone2.getObject().intValue());
	}
	
	/**
	 * A test for cloning arrays
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testCloneArrays() throws Exception
	{
		Integer i1 = Integer.valueOf(1);
		Integer i2 = Integer.valueOf(2);
		TestclassArrayholder<Integer> original = new TestclassArrayholder<Integer>(new Integer[]{i1, i2});
		TestclassArrayholder<Integer> clone = Cloner.<TestclassArrayholder<Integer>>clone(original);
		for (int i = 0;i < original.getObjects().length;i++)
		{
			original.getObjects()[i] = Integer.valueOf(original.getObjects()[i].intValue() + 10);
			assertFalse(original.getObjects()[i].equals(clone.getObjects()[i]));
		}
	}
	
	/**
	 * A test for cloning multi dimensional arrays
	 */
	@Test
	public static void testMultidimensionalArrays()
	{
		fail("Not implemented yet!");
	}
	
	/**
	 * A test for cloning objects with a ring closure in the class structure
	 */
	@Test
	public static void testRingClosure()
	{
		fail("Not implemented yet!");
	}
	
	/**
	 * A test for cloning objects containing final variables
	 */
	@Test
	public static void testFinalVariable()
	{
		fail("Not implemented yet!");
	}
	
	/**
	 * A test for cloning objects of non static subclasses
	 */
	@Test
	public static void testNonStaticSubclass()
	{
		fail("Not implemented yet!");
	}
}
