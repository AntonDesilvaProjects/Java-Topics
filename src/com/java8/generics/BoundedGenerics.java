package com.java8.generics;

/*
 * This class shows a generic Parameter extending
 * a class. Essentially, this will limit the possible
 * types of T to either the Number class(the superclass)
 * or any of its subclasses. Thus, only types that are numerical
 * in nature are allowed. Here is T is called a 'Bounded Type'.
 * 
 * We can further bound the type T by specifying interfaces that
 * a potential candidate for T must implement as follow:
 * 
 * public class BoundedGenerics<T extends Number & Runnable & Comparable<T> > {
 * 
 * Here T must be a Number implementing both Runnable and Comparable 
 * interfaces. Note that if we are bounding by both a class and interfaces
 * then 'extends class_type' must come before the interfaces.
 * 
*/
public class BoundedGenerics<T extends Number> {

	T[] numberList;
	public BoundedGenerics(T[] numberList )
	{
		this.numberList = numberList;
	}
	public double getAverage()
	{
		double sum = 0.0;
		for(T num : numberList)
		{
			/*
			 	Here we have access to the method 'doubleValue'
				since it is guaranteed that num is of type Number
			*/
			sum += num.doubleValue();
		}
		return sum / numberList.length;
	}
	/*
	 * <?> is the wild card character. It allows for denoting
	 * other types of the same class but with different parameterized
	 * type. So ? can be replaced by any other allowed type for T.
	 * 
	 * Note that if we had put T instead of BoundedGenerics<?>, the 
	 * T has to be the same type as this current class. 
	*/
	public boolean isSameAverage(BoundedGenerics<?> boundedType )
	{
		return boundedType.getAverage() == this.getAverage();
	}
}
