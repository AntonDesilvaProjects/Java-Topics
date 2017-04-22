package com.java8.generics;

public class SimpleNonGeneric {

	Object nonGenericObj;
	
	public SimpleNonGeneric(Object obj)
	{
		this.nonGenericObj = obj;
	}
	
	public void showType()
	{
		System.out.println("The type of the Non-generic object is " +
							this.nonGenericObj.getClass().getName());
	}
	
	public Object getNonGenericObject()
	{
		return this.nonGenericObj;
	}
	
}
