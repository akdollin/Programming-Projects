//***************************************
// This is the SpellCheckerHash class for the spell check
//problem.
//This class is from weiss, except for the hashCode (), and the myHash()
//Akiva Dollin-acd2164
//****************************************

public class SpellCheckerHash<AnyType>
{
	private static final int DEFAULT_TABLE_SIZE = 101;

	private HashEntry<AnyType> [ ] array; // The array of elements
	private int occupied;                 // The number of occupied cells
	private int tableSize;                  // Current size

	public SpellCheckerHash( )
	{
		this( DEFAULT_TABLE_SIZE );
	}

	public SpellCheckerHash( int size )
	{
		allocateArray( size );
		doClear( );
	}

	private static class HashEntry<AnyType>
	{
		public AnyType  element;   // the element
		public boolean isActive;  // false if marked deleted

		public HashEntry( AnyType e )
		{
			this( e, true );
		}

		public HashEntry( AnyType e, boolean i )
		{
			element  = e;
			isActive = i;
		}
	}

	public boolean insert( AnyType x )
	{
		// Insert x as active
		int currentPos = findPos( x );
		if( isActive( currentPos ) )
			return false;

		array[ currentPos ] = new HashEntry<AnyType>( x, true );
		tableSize++;

		// Rehash; see Section 5.5
		if( ++occupied > array.length / 2 )
			rehash( );

		return true;
	}

	private void rehash( )
	{
		HashEntry<AnyType> [ ] oldArray = array;

		// Create a new double-sized, empty table
		allocateArray( 2 * oldArray.length );
		occupied = 0;
		tableSize = 0;

		// Copy table over
		for( HashEntry<AnyType> entry : oldArray )
			if( entry != null && entry.isActive )
				insert( entry.element );
	}

	private int findPos( AnyType x )
	{
		int offset = 1;
		int currentPos = myhash( x );

		while( array[ currentPos ] != null &&
				!array[ currentPos ].element.equals( x ) )
		{
			currentPos += offset;  // Compute ith probe
			offset += 2;
			if( currentPos >= array.length )
				currentPos -= array.length;
		}

		return currentPos;
	}

	public boolean remove( AnyType x )
	{
		int currentPos = findPos( x );
		if( isActive( currentPos ) )
		{
			array[ currentPos ].isActive = false;
			tableSize--;
			return true;
		}
		else
			return false;
	}

	public int size( )
	{
		return tableSize;
	}

	//length method
	public int capacity( )
	{
		return array.length;
	}

	public boolean contains( AnyType x )
	{
		int currentPos = findPos( x );
		return isActive( currentPos );
	}

	/**
	 * Return true if currentPos exists and is active.
	 * @param currentPos the result of a call to findPos.
	 * @return true if currentPos is active.
	 */
	private boolean isActive( int currentPos )
	{
		return array[ currentPos ] != null && array[ currentPos ].isActive;
	}

	public void makeEmpty( )
	{
		doClear( );
	}

	private void doClear( )
	{
		occupied = 0;
		for( int i = 0; i < array.length; i++ )
			array[ i ] = null;
	}

	//creates a hash function with 19 as the prime
	//also calls the hash code ()
	private int myhash( AnyType x )
	{
		int hashVal = myhashCode((String) x);
		
		hashVal = ((hashVal+19) % array.length);
		
		if( hashVal < 0 )
		{
			hashVal += array.length;
		}

		return hashVal;
	}

	//basic hashCode() similar to the book
	//multiplies by a prime and the key
	//returns a unique integer
	public int myhashCode(String key)
	{
		int hashValue = 0;

		for(int i=0;i<key.length();i++) 
		{
			hashValue = 31*hashValue + key.charAt(i);
		}
		return hashValue;
	}


	private void allocateArray( int arraySize )
	{
		array = new HashEntry[nextPrime( arraySize )];
	}

	private static int nextPrime( int n )
	{
		if( n % 2 == 0 )
			n++;

		for( ; !isPrime( n ); n += 2 )
			;

		return n;
	}


	private static boolean isPrime( int n )
	{
		if( n == 2 || n == 3 )
			return true;

		if( n == 1 || n % 2 == 0 )
			return false;

		for( int i = 3; i * i <= n; i += 2 )
			if( n % i == 0 )
				return false;

		return true;
	}
}