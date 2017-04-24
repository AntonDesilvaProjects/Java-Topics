package com.java8.lambda;

/*
 	Functional Interface
*/
interface IStringUtility {
	String modifyString(String str);
}

public class PassingLambdasAsArguments {
	
	/*
	 	This is a multi-functional method that exists to call the
	 	method of the IStringUtility interface with the passed in
	 	String argument.
	*/
	public static String processString( IStringUtility strUtility, String arg )
	{
		return strUtility.modifyString(arg);
	}
	public static void main(String[] args)
	{
		/*
		 	Passing in a lambda that implements the 'modifyString'
		 	function as string reversing method
		*/
		String reversed = processString( ( s )-> {
			String result = "";
			for(int i = s.length() - 1; i >= 0; i--)
				result += s.charAt(i);
			return result;
		}, "anton");
		System.out.println( reversed );
		
		/*
	 		Passing in a lambda that implements the 'modifyString'
	 		function as space removing function.
		*/
		String spacesRemoved = processString( (s) -> {
			String result = "";
			for(char c : s.toCharArray() )
				if( c != ' ')
					result += c;
			return result;
		}, "on a frosty autumn evening...");
		System.out.println( spacesRemoved );
		
		/*
	 		If necessary, we can create the lambda separately
	 		and pass along the reference to the calling method.
		*/
		IStringUtility toASCIIUtility = ( s ) -> {
			String result = "";
			for(char c : s.toCharArray() )
				result += (int) c + ",";
			return result.substring(0, result.length() - 1);
		};
		String stringASCIIed = processString( toASCIIUtility, "don't cry because it's over, smile because it happened" );
		System.out.println( stringASCIIed );
	}
	
}
