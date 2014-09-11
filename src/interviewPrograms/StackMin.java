package interviewPrograms;

import DataStructures.*;

public class StackMin extends DataStructures.Stack {
	private Stack minStack;

	StackMin() {
		minStack = new Stack();
		// TODO Auto-generated constructor stub
	}
	
	public void push(int num) {
		if (num <= (int) min()) {
			minStack.push(num);
		}
		super.push(num);
	}
	
	public Object pop() {
		Object num = super.pop();
		if ((num != null) && (num == min())) {
			minStack.pop();
		}
		return num;
	}
	
	public Object peek() {
		return super.peek();
	}
	
	public Object min() {
		return (minStack.peek() == null? Integer.MAX_VALUE: minStack.peek());
	}

	public static void main(String[] args) {
		Stack stk = new StackMin();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		System.out.println("Min is : " + ((StackMin) stk).min());
		stk.push(6);
		
		stk.display();
		
		System.out.println("Popped: " + stk.pop());
		System.out.println("Peeked: " + stk.peek());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Min is : " + ((StackMin) stk).min());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Popped: " + stk.pop());
		System.out.println("Min is : " + ((StackMin) stk).min());

		stk.display();
	}

}
