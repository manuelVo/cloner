package de.dustboystudios.utils.cloner;

/**
 * A class holding 1 of each datatype
 *
 * @param <T> The type of the object
 *
 * @author Manuel Vögele
 */
public class TestclassAnyDatatype<T>
{
	/**
	 * An integer
	 */
	private int i;
	
	/**
	 * A double
	 */
	private double d;
	
	/**
	 * A float
	 */
	private float f;

	/**
	 * A boolean
	 */
	private boolean z;
	
	/**
	 * A byte
	 */
	private byte b;
	
	/**
	 * A char
	 */
	private char c;
	
	/**
	 * A short
	 */
	private short s;
	
	/**
	 * A long
	 */
	private long l;
	
	/**
	 * A enum
	 */
	private TestclassEnum e;
	
	/**
	 * A object
	 */
	private T o;

	/**
	 * Initializes a new object setting no values
	 */
	public TestclassAnyDatatype()
	{
	}
	
	/**
	 * Initializes a new object
	 * 
	 * @param i a integer
	 * @param d a double
	 * @param f a float
	 * @param z a boolean
	 * @param b a byte
	 * @param c a character
	 * @param s a short
	 * @param l a long
	 * @param e a enum
	 * @param o a object
	 */
	public TestclassAnyDatatype(int i, double d, float f, boolean z, byte b, char c, short s, long l, TestclassEnum e, T o)
	{
		this.i = i;
		this.d = d;
		this.f = f;
		this.z = z;
		this.b = b;
		this.c = c;
		this.s = s;
		this.l = l;
		this.e = e;
		this.o = o;
	}

	/**
	 * Sets the integer
	 * @param i the integer
	 */
	public void setI(int i)
	{
		this.i = i;
	}

	/**
	 * Sets the double
	 * @param d the double
	 */
	public void setD(double d)
	{
		this.d = d;
	}

	/**
	 * Sets the float
	 * @param f the float
	 */
	public void setF(float f)
	{
		this.f = f;
	}

	/**
	 * Sets the boolean
	 * @param z the boolean
	 */
	public void setZ(boolean z)
	{
		this.z = z;
	}

	/**
	 * Sets the byte
	 * @param b the byte
	 */
	public void setB(byte b)
	{
		this.b = b;
	}

	/**
	 * Sets the char
	 * @param c the char
	 */
	public void setC(char c)
	{
		this.c = c;
	}

	/**
	 * Sets the short
	 * @param s the short
	 */
	public void setS(short s)
	{
		this.s = s;
	}

	/**
	 * Sets the long
	 * @param l the long
	 */
	public void setL(long l)
	{
		this.l = l;
	}

	/**
	 * Sets the enum
	 * @param e the enum
	 */
	public void setE(TestclassEnum e)
	{
		this.e = e;
	}

	/**
	 * Sets the object
	 * @param o the object
	 */
	public void setO(T o)
	{
		this.o = o;
	}

	/**
	 * Returns the integer
	 * @return the integer
	 */
	public int getI()
	{
		return i;
	}

	/**
	 * Returns the double
	 * @return the double
	 */
	public double getD()
	{
		return d;
	}

	/**
	 * Returns the float
	 * @return the float
	 */
	public float getF()
	{
		return f;
	}

	/**
	 * Returns the boolean
	 * @return the boolean
	 */
	public boolean getZ()
	{
		return z;
	}

	/**
	 * Returns the byte
	 * @return the byte
	 */
	public byte getB()
	{
		return b;
	}

	/**
	 * Returns the char
	 * @return the char
	 */
	public char getC()
	{
		return c;
	}

	/**
	 * Returns the short
	 * @return the short
	 */
	public short getS()
	{
		return s;
	}

	/**
	 * Returns the long
	 * @return the long
	 */
	public long getL()
	{
		return l;
	}

	/**
	 * Returns the enum
	 * @return the enum
	 */
	public TestclassEnum getE()
	{
		return e;
	}

	/**
	 * Returns the object
	 * @return the object
	 */
	public T getO()
	{
		return o;
	}
}
