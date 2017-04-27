package com.java8.lambda;

/*
	Functional Interface
*/
interface IStringOp {
	String processString( String str );
}

class StringMethods {
	/*
	 	A static method that can reverse a string
	*/
	public static String staticReverse(String str )
	{
		return new StringBuilder(str).reverse().toString();
	}
	/*
		An instance method that can reverse a string
	*/
	public String instanceReverse(String str)
	{
		return new StringBuilder(str).reverse().toString();
	}
}

public class MethodReferences {

	/*
	 	A driver function that can take an implementation
	 	of the IStringOp interface, a lambda, OR a method
	 	reference as shown below
	*/
	static String operateString(IStringOp op, String s)
	{
		return op.processString(s);
	}
	public static void main(String[] args) {
		
		String original = "On a dark, windy night...";
		/*
		  	The reason below code works is because both the 'staticReverse'
		  	method and the method expected by the functional interface
		  	matches(both takes in a String and returns String).
		*/
		//Passed in a Static method reference
		String reversed = operateString(StringMethods::staticReverse, original);
		//Lambda equivalent
		String reversedLambda = operateString( (s) -> {
			return new StringBuilder(s).reverse().toString();
		}, original);
		
		System.out.println( reversed );
		System.out.println( reversedLambda );

		
		//We can also use an instance method as follows
		StringMethods strMethods = new StringMethods();
		String reversedInstance = operateString( strMethods::instanceReverse, original);
		System.out.println( reversedInstance );
		
		
	}

}
