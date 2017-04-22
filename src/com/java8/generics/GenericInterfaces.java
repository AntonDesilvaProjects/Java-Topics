package com.java8.generics;

/*
 	A generic interface with type T. T must be of a comparable
 	type. 
*/
interface MinMax<T extends Comparable<T> >
{
	T min();
	T max();
}

/*
 	Using the above interface.
*/
public class GenericInterfaces<K extends Comparable<K> > implements MinMax<K> {

	K[] collection;
	
	@Override
	public K min() {
		K min = collection[0];
		for(K current : collection )
			if( current.compareTo(min) > 0 )
				min = current;
		return min;
	}

	@Override
	public K max() {
		K max = collection[0];
		for(K current : collection )
			if( current.compareTo(max) < 0 )
				max = current;
		return max;
	}	
}