package com.java8.lambda;

/*
	Functional Interface
*/
interface IFunc {
	int doStuff( int n );
}
public class VariableScopeWithLambdas {
	public static void main(String[] args)
	{
		/*
		 	This variable is considered "effectively final" because
		 	it is using within the lambda and we can not modify it's 
		 	value(any modification will lead to error) either within
		 	or outside the lambda. This idea is referred to as "Variable
		 	Capture" because k captured by the lambda
		*/
		int k = 23;
		
		IFunc func = ( x ) -> {
			int v = k + 12; //This is allowed
			//k++ is NOT allowed
			return -1;
		};
		
		//The following will cause an error
		//k++;
	}
}
