package com.java8.concurrency;

/*
	Here we explore the extending the Thread class which is one way of
	creating a thread. Override the run method to define the behavior of 
	thread.
*/

class CustomThread2 extends Thread {
	public CustomThread2()
	{
		super("Custom Thread");
		start();
	}
	
	/*
	 	Inherited from the Thread class. Override with 
	 	the desired behavior.
	*/
	public void run()
	{
		try
		{
			for(int i = 5; i > 0; i-- )
			{
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Exiting child thread");
	}
}


public class ExtendingThread {
	public static void main(String[] args)
	{
		new CustomThread(); //Create and Run thread
		
		try
		{
			for(int i = 5; i > 0; i--)
			{
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}
