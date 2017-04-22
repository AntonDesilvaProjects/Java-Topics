package com.java8.generics;

public class GenericMethod {
	
	/*
		Following is a generic method in a non-generic class. Note how the
		generic declaration appears BEFORE the return type. The generic 
		itself:
		
		'T extends Comparable<T>' ensures that type T implements the comparable
		interface meaning T can be compared with other values.
		'V extends T' ensures that V is upper-bounded by T meaning that V
		must be the same as T or a subclass of it. This entire setup ensures
		compatibility. Following are valid types:
		
		T - Integer
		V - Integer
		
		but
		
		T - Integer
		V - String     does NOT work because String is not a subclass of Integer
	*/
	public static <T extends Comparable<T>, V extends T> boolean contains(T key, V[] collection)
	{
		for(T current : collection )
			if( current.equals(key) )
				return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		//Note how contains does NOT need any type declaration
		//Java can automatically discern the types
		Integer[] numbers = { 12, 56, 2, 19, 13};
		System.out.println( GenericMethod.contains(19, numbers) );
		
		//If wanted, we can specify the types explicitly
		String[] colors = { "blue", "green", "yellow", "orange"};
		System.out.println( GenericMethod.<String,String>contains("green", colors ) );
	}
}
