package com.java8.generics;

public class GenericsDriver2 {

	public static void main(String[] args) {
		
		Double[] nums = { (double) 10, 45.6, (double) 89};
		BoundedGenerics<Double> stats = new BoundedGenerics<Double>( nums );
		System.out.println( "Average: " + stats.getAverage());
	}

}
