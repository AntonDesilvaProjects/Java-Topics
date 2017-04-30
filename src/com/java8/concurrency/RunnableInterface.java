package com.java8.concurrency;

/*
 	Here we explore the Runnable interface which is one way of
 	creating a thread. Runnable interface is a functional interface
 	with the method 'run' that gets executed when the thread starts. 
 	
 	NOTE: This the "recommended" way of using threads(as opposed to extending
 	Thread class) as it frees up the class to extend other classes. Furthermore,
 	we generally extend a class if we are enhancing/modifying the base class in 
 	some way and this is not usually the intention when using threads.
*/

class CustomThread implements Runnable {

	Thread t;
	
	/*
	 	Instantiate a Thread class by using the ctor
	 	Thread(Runnable r, thread title) and start
	 	execution.
	*/
	public CustomThread()
	{
		t = new Thread(this, "Demo Thread");
		System.out.println("Child Thread: " + t);
		t.start();
	}
	
	/*
	 	Gets executed when the Thread starts running.
	*/
	@Override
	public void run() {
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

public class RunnableInterface {
	public static void main(String[] args)
	{
		new CustomThread(); //Call the constructor which will
							//create the Thread and start it
		
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
