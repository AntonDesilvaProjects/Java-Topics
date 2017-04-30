package com.java8.concurrency;

/*
 	Thread provide following two helpful methods:
 	a) isAlive - returns true if thread is executing; false otherwise.
 	b) join - the current thread waits until the called on thread finishes
 	
 	Typically, the main thread should end after all the other child threads
 	have finished. We can use the above methods to ensure that this is the 
 	case.
*/
class CustomThread3 implements Runnable {

	private String name;
	private Thread t;
	
	public CustomThread3(String name)
	{
		this.name = name;
		t = new Thread( this, name );
		System.out.println("New Thread: " + t);
		t.start();
	}
	
	@Override
	public void run() 
	{
		try
		{
			for(int i = 5; i > 0; i--)
			{
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(name + " exiting");
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}	
}

public class IsAlive_JoinMethods {
	public static void main(String[] args)
	{
		CustomThread3 ob1 = new CustomThread3("One");
		CustomThread3 ob2 = new CustomThread3("Two");
		CustomThread3 ob3 = new CustomThread3("Three");
		
		/*
		 	These threads should return 'true' as they are
		 	currently executing.
		*/
		System.out.println("Ob1: " + ob1.getT().isAlive());
		System.out.println("Ob2: " + ob2.getT().isAlive());
		System.out.println("Ob3: " + ob3.getT().isAlive());
		
		try
		{
			/*
			 	Make the main thread wait till all the other
			 	3 threads have finished executing.
			*/
			System.out.println("Waiting for the thread to finish");
			ob1.getT().join();
			ob2.getT().join();
			ob3.getT().join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		/*
		 	These threads should return 'false' as they should
		 	be done executing since we froze the main thread till
		 	they finished.
		*/
		System.out.println("Ob1: " + ob1.getT().isAlive());
		System.out.println("Ob2: " + ob2.getT().isAlive());
		System.out.println("Ob3: " + ob3.getT().isAlive());
		
		System.out.println("Main thread exiting");
	}
}
