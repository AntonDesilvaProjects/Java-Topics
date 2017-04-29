package com.java8.concurrency;
/*-----------------------------------Start Notes----------------------------
	The Java Thread Model
	
		In an single-threaded environment, there are typically event-queues
	with polling. An item to be executed is taken from the queue and handed
	off to an event handler; it is only when that item has finished, the next item
	is processed. Essentially, the single thread BLOCKS until the current has finished.
	
		With multi-threading, multiple threads can execute independent of one
	another. If one thread blocks, the other ones can continue executing. Furthermore,
	multi-threaded systems can benefit from either single core(1 CPU) or multicore systems.
	In a single core machine, each thread is given a time-slice of CPU usage after which
	it must surrender the CPU to the next thread - so as to give the illusion of multitasking.
	In multicore system, actual multi-threading can take place.
	
	A thread can exist in several states:
		a) Running - currently running
		b) Ready to Run - once the CPU time is available, the thread can run
		c) Suspended - temporary halt in its activity
		d) Resumed - thread is resumed after it is allowed resume from suspended state
		e) Blocked - waiting for a resource
		f) Terminated - killed. This thread is no more.
	
	I. Thread Priorities
	
		Threads can have integer based priorities - threads with larger priority
	executes before those with lower priorities. During a CONTEXT SWITCH - switching
	from the execution one thread to another, the thread priority is used to determine
	which thread gets to run next. Typically, currently executing thread can
		a) Voluntarily relinquish control via( sleeping, blocking, etc) -OR-
		b) Preemption - high priority thread kicks out the current thread.
	
	II. Synchronization
	
		Sometimes threads need to work together - for instance, reading data
	from a data structure. To ensure that there is no consistency issues or threads
	don't conflict with one another there has to be a way to synchronize threads.
	This is done via a control mechanism called MONITOR - where only thread is allowed
	to use some object at a time. There is no Monitor class in Java, but each object
	can have a synchronized method that enforce this idea. 
	
	III. The Thread class and Runnable interface
		Java's representation of a thread is the Thread class which have several 
	methods to manage threads:
		getName
		getPriority
		isAlive - determines if thread is still running
		join - wait for thread to terminate
		run
		sleep
		start
------------------------------------End Notes--------------------------------
*/

/*
	The main thread is used to spawn other child threads.
*/
public class MainThread {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread(); //Get reference to the current thread
		/*
		  	Prints out 'Thread[main,5,main]' where main is the name
		  	of the thread, 5 is the priority, main is the thread group
		*/
		System.out.println("Current Thread: " + t); 
																
		
		t.setName("The main thread");
		System.out.println("Current Thread: " + t);
		
		try
		{
			for(int n = 5; n > 0; n--)
			{
				System.out.println(n);
				t.sleep(1000); //This method throws the 'InterruptedException'
							   //if the thread were to be interrupted by another
							   //thread while sleeping
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Main Thread Interrupted !");
		}
		
	}

}
