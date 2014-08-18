package interviewPrograms;

public class MultithreadHelloWorld implements Runnable {

	@Override
	public void run() {
		String threadname = Thread.currentThread().getName();
		System.out.println(threadname + ": Hello World!!!");
	}
	public static void main(String[] args) {
		MultithreadHelloWorld mThread = new MultithreadHelloWorld();
		Thread objThread1 = new Thread(mThread, "Thread 1");
		objThread1.start();
		
		//Single line command.  Also JVM assigning name to thread
		(new Thread(mThread)).start();
		
		(new Thread(new MultithreadHelloWorld())).start();
	}
}
