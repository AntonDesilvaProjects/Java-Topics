package com.java8.generics;

public class SimplePair<N,V> {
	
	private N name;
	private V value;

	public SimplePair(N name, V value )
	{
		this.name = name;
		this.value = value;
	}
	
	public N getName()
	{
		return this.name;
	}
	
	public V getValue()
	{
		return this.value;
	}
	
	public void showTypes()
	{
		System.out.println("Name type: " + name.getClass().getName() + "\n" + "Value type: " + value.getClass().getName() );
	}
	
	public String toString()
	{
		return this.name.toString() + "," + this.value.toString();
	}
	
}
