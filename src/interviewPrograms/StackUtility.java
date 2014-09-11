package interviewPrograms;

import DataStructures.Stack;

public class StackUtility extends Stack {
	
	public Stack sortStackBruteForce() {
		Stack sorted = new Stack(), temp = new Stack();
		while(!this.isEmpty()) {
			int val = (int) this.pop();
			int peekVal = sorted.peek()==null?Integer.MIN_VALUE:(int) sorted.peek();
			while((val<peekVal) && !sorted.isEmpty()) {
				temp.push((int) sorted.pop());
				peekVal = sorted.peek()==null?Integer.MIN_VALUE:(int) sorted.peek();
			}
			sorted.push(val);
			while(!temp.isEmpty()) 
				sorted.push((int) temp.pop());
		}
		return sorted;
	}
	
	public Stack sortStack() {
		Stack sorted = new Stack();
		while(!this.isEmpty()) {
			int val = (int) this.pop();
			int peekVal = sorted.peek()==null?Integer.MIN_VALUE:(int) sorted.peek();
			while((val<peekVal) && !sorted.isEmpty()) {
				this.push((int) sorted.pop());
				peekVal = sorted.peek()==null?Integer.MIN_VALUE:(int) sorted.peek();
			}
			sorted.push(val);
		}
		return sorted;
	}

	public static void main(String[] args) {
		StackUtility stk = new StackUtility();
		stk.push(1);
		stk.push(3);
		stk.push(2);
		stk.push(6);
		stk.push(5);
		stk.push(4);
		
		stk.display();
		
		//stk.sortStackBruteForce().display();
		stk.sortStack().display();
	}

}
