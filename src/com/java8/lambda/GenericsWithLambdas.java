package com.java8.lambda;

/*
 	A generic interface.
*/
interface IMultifunction<T>
{
	T doAction(T arg);
}

public class GenericsWithLambdas {

	public static void main(String[] args) {
		
		/*
		 	The same interface can be used to implement completely
		 	different functions. Only thing common for these two lambdas
		 	is that they take a parameter and return something of same
		 	type. Generic at declaration determines the type.
		*/	
		IMultifunction<String> reverse = ( s ) -> {
			String result = "";
			for(int i = s.length() - 1; i >= 0; i-- )
				result += s.charAt(i);
			return result;
		};
		
		IMultifunction<Integer> factorial = ( n ) -> {
			int result = 1;
			for(int k = n; k >= 1; k-- )
				result *= k;		
			return result;
		};

		System.out.println( reverse.doAction("anton"));
		System.out.println( factorial.doAction( 5 ));
		
	}

}
