package com.java8.lambda;

/*
  	Following is a FUNCTIONAL INTERFACE - an interface that specifies
  	only a SINGLE 'abstract' method. Generally, all the methods in an
  	interface are abstract because we don't implement them. However,
  	Java 8 introduced 'default method's that allows for implementation
  	code within an interface. 
*/
interface INumber {
	double getValue();
}

interface IRandom {
	double getRandomNum( int start, int range );
}

interface IFactorial {
	int getFactorial(int n );
}

interface IStringReverse {
	String reverse(String str);
}

public class SimpleLambdas {
	public static void main(String[] args)
	{
		/*
		  	#1) A LAMBDA EXPRESSION forms the implementation of the
		  	abstract method specified by the functional interface.
		  	Below lambda implements the 'getValue' method of the
		  	MyNumber interface.
		*/
		INumber num = () -> 123.45;
		System.out.println( num.getValue()); //Call the method like normal
		
		/*
		 	#2) The lambda must be compatible with the abstract method
		 	that it is meant to implement.
		 	
		 	num = () -> "will not compile";
		*/
		

		/*
		 	#3) Parameterized lambda expression. Note how 'start' and 'range'
		 	variables do not have types - they are inferred from the inter-
		 	face(we can explicitly state them if we wish). 
		*/
		IRandom rand = ( start, range ) -> Math.random() * range + start;
		System.out.println( rand.getRandomNum( 0 , 100 ));
		
		/*
		 	#4) Block lambda. Just like a function - we have to specify the
		 	return statement. Note the semicolon after the } brace.
		 */
		IFactorial factorial = ( n ) -> {
			int result = 1;
			for(int k = n; k >= 1; k-- )
				result *= k;		
			return result;
		};
		System.out.println( factorial.getFactorial(5));
		
		IStringReverse reverse = ( s ) -> {
			String result = "";
			for(int i = s.length() - 1; i >= 0; i-- )
				result += s.charAt(i);
			return result;
		};
		System.out.println( reverse.reverse("anton"));
		
	}
}
