package interviewPrograms;

import java.util.Date;

public class ThreadSubClassSleep extends Thread{
	public ThreadSubClassSleep(String name) {
		//We use this to give a name we specified to the object
		super(name);
	}
	
	public ThreadSubClassSleep() {
		//We need this because we defined a parameterized constructor
		super();
	}
	
	public void run(){
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": Hello World!!!");
	}
	public static void main(String[] args) throws InterruptedException{
		ThreadSubClassSleep thObj1 = new ThreadSubClassSleep();
		thObj1.start();
		
		new ThreadSubClassSleep("Thread2").start();
		
		//Sleep example
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " Start Time: " + (new Date().toString()));
		for (int i=1; i<=5; i++) {
			Thread.sleep(2*1000);
			System.out.println(threadName + " Hello World#" + i + " : " + (new Date().toString()));
		}
	}

}
