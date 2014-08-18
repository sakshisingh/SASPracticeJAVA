package interviewPrograms;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopher {
	
	private class Chopstick {
		private Lock lock;
		
		Chopstick() {
			/*Create an instant of re-entrant lock 
			 * (Explicit lock, unlike implicit lock in case of synchronized keyword)
			 */
			lock = new ReentrantLock();
		}
		
		boolean pickup() {
			//Acquire the lock on Chopstick object.
			//tryLock returns true if lock was free and acquired now.
			//If unable to acquire lock returns false.
			return lock.tryLock();
		}
		
		void putDown() {
			//Release the lock acquired while picking up chopstick
			lock.unlock();
		}
	}	//End of Chopstick class
	
	private class Philosopher extends Thread{
		//Number of bites each philosopher eats
		private int bites = 5;
		private Chopstick left;
		private Chopstick right;
		
		Philosopher (Chopstick left, Chopstick right) {
			this.left = left;
			this.right = right;
		}
		void eat() {
			if (pickup()) {
				chew();
				putDown();
			}
		}
		
		boolean pickup() {
			if (!left.pickup())
				return false;
			if (!right.pickup()) {
				left.putDown();
				return false;
			}
			return true;
		}
		
		void chew() {
			//Eating
		}
		
		void putDown() {
			left.putDown();
			right.putDown();
		}
		
		public void run() {
			for (int i=0; i<bites; i++) {
				eat();
			}
		}
	}
	public static void main(String[] args) {
		DiningPhilosopher d = new DiningPhilosopher();
		Chopstick chop1 = d.new Chopstick();
		Chopstick chop2 = d.new Chopstick();
		Philosopher p1 = d.new Philosopher(chop1, chop2);
		Philosopher p2 = d.new Philosopher(chop2, chop1);
		p1.run();
		p2.run();
	}

}
