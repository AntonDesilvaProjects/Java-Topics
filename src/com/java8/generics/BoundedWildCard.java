package com.java8.generics;

public class BoundedWildCard<T extends TwoD> {
	private T[] coords;
	
	public BoundedWildCard(T[] coords)
	{
		this.coords = coords;
	}
	
	public T[] getCoords()
	{
		return this.coords;
	}
	
	/*
	 * Here the object 'c' can be a BoundedWildCard object
	 * of any allowable type(it doesn't have to be type T). 
	*/
	public static void showXY(BoundedWildCard<?> c)
	{
		System.out.println("Printing X,Y coordinates");
		for(TwoD current : c.getCoords() )
		{
			System.out.println(current.x + "," + current.y);
		}
	}
	
	/*
	 * Here we are further restricting the type of arguments
	 * that can be passed in. This way, only 'BoundedWildCard'
	 * types that are either ThreeD or subclass can be passed in
	 * while passing in a TwoD is prevented.  
	*/
	public static void showXYZ(BoundedWildCard<? extends ThreeD> c)
	{
		System.out.println("Printing X,Y,Z coordinates");
		for(ThreeD current : c.getCoords() )
		{
			System.out.println(current.x + "," + current.y + "," + current.z);
		}
	}
}


class TwoD {
	int x,y;
	
	TwoD( int a, int b )
	{
		x = a;
		y = b;
	}
}

class ThreeD extends TwoD {
	
	int z;
	
	ThreeD( int a, int b, int c )
	{
		super(a,b);
		z = c;
	}
}

class FourD extends ThreeD {
	int t;
	
	FourD( int a, int b, int c, int d )
	{
		super( a, b, c );
		t = d;
	}
}