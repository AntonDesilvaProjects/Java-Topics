package com.java8.lambda;

/*
 	Define a functional interface with a method that throws
 	an exception. Without the 'throws' keyword, the lambda
 	is NOT allowed to throw the exception.
*/
interface IAverageCalc {
	double calculateAverage( double[] num ) throws EmptyArrayException;
}

/*
  	Custom exception.
*/
class EmptyArrayException extends Exception {
	public EmptyArrayException()
	{
		super("Array is empty !");
	}
}

public class ExceptionsWithLambdas {
	public static void main(String[] args)
	{
		/*
		  	Implement the lambda. We throw the custom exception
		  	when the array is empty. Note that the parameter 'd'
		  	is declared is simply d, not 'd[]' although it represents
		  	an array of doubles - the lambda can deduce the type. 
		  	'd[]' is incorrect. If we wish to be explicit, we can
		  	write 'double[] d'
		*/
		IAverageCalc avg = ( d ) -> {
			
			if(d.length == 0 )
				throw new EmptyArrayException();
			
			double sum = 0;
			for(double current : d )
				sum += current;
			
			return sum / d.length;
		};
		
		try {
			System.out.println( avg.calculateAverage( new double[] { 1.0,
																	 2.0,
																	 3.0,
																	 4.0}
								));
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}
	}
}
