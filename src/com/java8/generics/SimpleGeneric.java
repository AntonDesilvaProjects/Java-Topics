package com.java8.generics;

/*
 * T is the 'type' parameter of the object
 */
public class SimpleGeneric<T> {
	
	T genericObj; //Declare an object of Type T
	
	public SimpleGeneric(T obj)
	{
		this.genericObj = obj;
	}
	
	T getGenericObject()
	{
		return this.genericObj;
	}
	
	public void showType()
	{
		System.out.println("Type of T is " + this.genericObj.getClass().getName());
	}
}
