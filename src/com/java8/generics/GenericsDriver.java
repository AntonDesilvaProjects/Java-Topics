package com.java8.generics;

public class GenericsDriver {

	public static void main(String[] args)
	{
		
		SimpleNonGeneric ng_intObj = new SimpleNonGeneric( 88 );
		ng_intObj.showType();
		//An explicit cast is required
		int value = (Integer) ng_intObj.getNonGenericObject();
		System.out.println( value );
		
		SimpleNonGeneric ng_strObj = new SimpleNonGeneric( 88 );
		ng_strObj.showType();
		/*
		 * We can set two types equal to one another(dangerous). 
		*/
		ng_intObj = ng_strObj;
		/*
		 * Following causes a run-type exception as we are trying to
		 * convert an Integer to a String. 
		*/
		//! String v = (String) ng_intObj.getNonGenericObject();
		//! System.out.println( v );
		
		//-----------------------------------------------------------------
		
		/*
		 * SimpleGeneric object of type Integer is created. Autoboxing
		 * is used to make the primitive value '88' into an Integer 
		 * object 
		*/
		SimpleGeneric<Integer> intObj = new SimpleGeneric<Integer>(88);
		
		//Show the type of the object
		intObj.showType();
		
		//Invokes the 'toString' method of the Integer
		System.out.println(intObj.getGenericObject());
		
		/*
		 * SimpleGeneric object of type String is created. Note that
		 * we cannot use primitive types with Generics(we don't need
		 * to as there are object wrappers for primitives like Integer,
		 * Double, etc).
		*/
		SimpleGeneric<String> strObj = new SimpleGeneric<String>("Hello World");
		strObj.showType();
		System.out.println( strObj.getGenericObject() );
		
		/*
		 *  Generics of the same type are NOT equal to one another.
		 * 
		 *  intObj does NOT equal to strObj although they are both of
		 *  type 'SimpleGeneric<T>'
		*/
		
		//-------------------------------------------------------------------
		
		/*
		 * Generics of two types 
		 */
		SimplePair<String, Double> order = new SimplePair<String, Double>("Price",11.95);
		System.out.println( order );
	}
}
