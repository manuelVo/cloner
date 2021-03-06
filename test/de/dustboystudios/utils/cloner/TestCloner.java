package de.dustboystudios.utils.cloner;

import junit.framework.TestCase;

import org.junit.Test;

import de.dustboystudios.utils.cloner.TestclassSubclassHolder.NonStaticSubclass;

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
		TestclassObjectholder<Integer> obj = new TestclassObjectholder<Integer>(Integer.valueOf(1));
		Cloner<TestclassObjectholder<Integer>> cloner = new Cloner<TestclassObjectholder<Integer>>(obj);
		obj.setObject(Integer.valueOf(2));
		TestclassObjectholder<Integer> clone1 = cloner.makeClone();
		TestclassObjectholder<Integer> clone2 = cloner.makeClone();
		clone1.setObject(Integer.valueOf(3));
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
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testMultidimensionalArrays() throws Exception
	{
		Integer[][] integers = new Integer[2][2];
		integers[0][0] = Integer.valueOf(0);
		integers[0][1] = Integer.valueOf(1);
		integers[1][0] = Integer.valueOf(2);
		integers[1][1] = Integer.valueOf(3);
		TestclassObjectholder<Integer[][]> obj = new TestclassObjectholder<Integer[][]>(integers);
		TestclassObjectholder<Integer[][]> clone = Cloner.clone(obj);
		integers[0][0] = Integer.valueOf(10);
		integers[0][1] = Integer.valueOf(11);
		integers[1][0] = Integer.valueOf(12);
		integers[1][1] = Integer.valueOf(13);
		integers = clone.getObject();
		assertEquals(0, integers[0][0].intValue());
		assertEquals(1, integers[0][1].intValue());
		assertEquals(2, integers[1][0].intValue());
		assertEquals(3, integers[1][1].intValue());
	}
	
	/**
	 * Tests if null values are handled properly
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testNullValues() throws Exception
	{
		assertNull(Cloner.clone(null));
		Cloner<Object> cloner = new Cloner<Object>(null);
		assertNull(cloner.makeClone());
		TestclassObjectholder<Object> obj = new TestclassObjectholder<Object>(null);
		TestclassObjectholder<Object> clone = Cloner.clone(obj);
		assertNull(clone.getObject());
	}
	
	/**
	 * A test for cloning an object referencing to itself
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testSelfReference() throws Exception {
		TestclassLinkedObjectholder<Integer> obj = new TestclassLinkedObjectholder<Integer>(Integer.valueOf(1));
		obj.setNext(obj);
		TestclassLinkedObjectholder<Integer> clone = Cloner.clone(obj);
		clone.setObject(Integer.valueOf(2));
		assertEquals(2, clone.getNext().getObject().intValue());
	}
	
	/**
	 * A test for cloning objects with a ring closure in the class structure
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testRingClosure() throws Exception
	{
		TestclassLinkedObjectholder<Integer> first = new TestclassLinkedObjectholder<Integer>(Integer.valueOf(1));
		TestclassLinkedObjectholder<Integer> second = new TestclassLinkedObjectholder<Integer>(Integer.valueOf(2));
		first.setNext(second);
		second.setNext(first);
		TestclassLinkedObjectholder<Integer> clone = Cloner.clone(first);
		TestclassLinkedObjectholder<Integer> cfirst = clone.getNext().getNext();
		first.setObject(Integer.valueOf(10));
		assertEquals(1, cfirst.getObject().intValue());
		clone.setObject(Integer.valueOf(20));
		assertEquals(20, cfirst.getObject().intValue());
	}
	
	/**
	 * A test for cloning objects containing final variables
	 * 
	 * @throws Exception if something goes wrong
	 */
	@Test
	public static void testFinalVariable() throws Exception
	{
		TestclassFinalVariable<Integer> obj = new TestclassFinalVariable<Integer>(Integer.valueOf(1));
		TestclassFinalVariable<Integer> clone = Cloner.clone(obj);
		assertEquals(1, clone.getObject().intValue());
	}
	
	/**
	 * A test for cloning objects of non static subclasses
	 * 
	 * @throws Exception
	 *            if something goes wrong
	 */
	@Test
	public static void testNonStaticSubclass() throws Exception
	{
		TestclassSubclassHolder holder = new TestclassSubclassHolder(1);
		NonStaticSubclass nonStaticSubclass = holder.new NonStaticSubclass(true);
		TestclassObjectholder<NonStaticSubclass> obj = new TestclassObjectholder<NonStaticSubclass>(nonStaticSubclass);
		TestclassObjectholder<NonStaticSubclass> clone = Cloner.clone(obj);
		obj.getObject().setI(2);
		obj.getObject().setB(false);
		NonStaticSubclass csubclass = clone.getObject();
		assertTrue(csubclass.getB());
		assertEquals(1, csubclass.getI());
	}
}
