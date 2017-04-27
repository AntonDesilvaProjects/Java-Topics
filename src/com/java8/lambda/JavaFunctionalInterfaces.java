package com.java8.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

/*
	Java 8 comes with built-in functional interfaces that we can readily
	use with lambdas.
	
	#1. UnaryOperator<T> : Apply a unary operation to an object of type T and return the result,
	which is also of type T. Its method is called apply( ).
	
	#2. BinaryOperator<T> : Apply an operation to two objects of type T and return the result, which
	is also of type T. Its method is called apply( ).
	
	#3. Consumer<T> Apply an operation on an object of type T. Its method is called
	accept( ).
	
	#4. Supplier<T> : Return an object of type T. Its method is called get( ).
	
	#5. Function<T, R> Apply an operation to an object of type T and return the result as an
	object of type R. Its method is called apply( ).
	
	#6.	Predicate<T> : Determine if an object of type T fulfills some constraint. Return a
	boolean value that indicates the outcome. Its method is called test( ).
*/


public class JavaFunctionalInterfaces {
	
	public static void main(String[] args)
	{
		/*
		 * Example with the Function functional interface.
		*/
		Function<String, Integer> getLength = (s) -> {
			return s.length();
		};
		System.out.println( getLength.apply("anton"));
		
		/*
		 * Example with the Predicate functional interface.
		*/
		Predicate<String> isPalindrome = ( s ) -> {
			for(int k = 0; k < s.length() / 2; k++)
			{
				if(s.charAt(k) != s.charAt( s.length() - 1 - k ))
					return false;
			}
			return true;
		};
		System.out.println( isPalindrome.test("mom"));
	}
}
