package de.dustboystudios.utils.cloner;

/**
 * Class holding a non static subclass
 * 
 * @author Manuel Vögele
 */
public class TestclassSubclassHolder
{
	/**
	 * An integer
	 */
	private int i;

	/**
	 * Creates a new instance
	 * 
	 * @param i
	 *           an integer
	 */
	public TestclassSubclassHolder(int i)
	{
		this.i = i;
	}

	/**
	 * Sets a new integer
	 * 
	 * @param i
	 *           a new integer
	 */
	public void setI(int i)
	{
		this.i = i;
	}

	/**
	 * Returns the integer
	 * 
	 * @return the integer
	 */
	public int getI()
	{
		return i;
	}

	/**
	 * A non static subclass
	 * 
	 * @author Manuel Vögele
	 */
	public class NonStaticSubclass
	{
		/**
		 * An boolean
		 */
		private boolean b;

		/**
		 * Creates a new instance
		 * 
		 * @param b
		 *           a boolean
		 */
		public NonStaticSubclass(boolean b)
		{
			this.b = b;
		}

		/**
		 * Sets a new boolean
		 * 
		 * @param b
		 *           a boolean
		 */
		public void setB(boolean b)
		{
			this.b = b;
		}

		/**
		 * Returns the held boolean
		 * 
		 * @return the boolean
		 */
		public boolean getB()
		{
			return b;
		}

		/**
		 * Sets a new surrounding integer
		 * 
		 * @param i
		 *           a new integer
		 */
		public void setI(int i)
		{
			TestclassSubclassHolder.this.setI(i);
		}

		/**
		 * Returns the surrounding integer
		 * 
		 * @return the integer
		 */
		public int getI()
		{
			return TestclassSubclassHolder.this.getI();
		}
	}
}
