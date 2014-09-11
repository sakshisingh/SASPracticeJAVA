package interviewPrograms;

import DataStructures.Stack;

public class MyQueue {

	Stack startStack;
	Stack endStack;
	
	MyQueue() {
		startStack = new Stack();
		endStack = new Stack();
	}
	
	public void enqueue(int val) {
		startStack.push(val);
	}
	
	public Object dequeue() {
		Object val = null;
		if (endStack.isEmpty()){
			moveStack(startStack, endStack);
		}
		val = endStack.pop();
		return val;
	}
	
	private void moveStack(Stack first, Stack second) {
		while(!first.isEmpty())
			second.push((int) first.pop());
	}

	
	private void display() {
		if (!endStack.isEmpty()) {
			endStack.display();
		}
		if (!startStack.isEmpty()) {
			startStack.display();
		}
		
	}
	
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.dequeue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.display();
		q.dequeue();
		q.dequeue();
		q.display();
	}

}
