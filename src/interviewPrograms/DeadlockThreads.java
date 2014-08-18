package interviewPrograms;

public class DeadlockThreads {
	String str1 = "Java";
	String str2 = "C";
	
	Thread thread1 = new Thread("Thread 1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					//Add sleep to ensure that the other thread runs 
					//causing a deadlock to happen for sure.
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str2) {
						System.out.println("Thread 1 printing: " + str1 + " : " + str2);
					}
				}
			}
		}
	};
	
	Thread thread2 = new Thread("Thread 2") {
		public void run() {
			while (true) {
				synchronized (str2) {
					//Add sleep to ensure that the other thread runs 
					//causing a deadlock to happen for sure.
					try {
						sleep(100);	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str1) {
						System.out.println("Thread 2 printing: " + str2 + " : " + str1);
					}
				}
			}
		}
	};
	public static void main(String[] args) {
		DeadlockThreads d = new DeadlockThreads();
		d.thread1.start();
		d.thread2.start();
	}

}
