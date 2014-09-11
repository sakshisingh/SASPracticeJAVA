package interviewPrograms;

import java.util.ArrayList;

import DataStructures.Stack;

public class SetOfStacks extends Stack {

	private final static int capacity = 10;  
	private static int elemNum = 0;
	ArrayList<Stack> stacksSet = new ArrayList<Stack>();
	
	public void push(int num) {
		Stack last = getLastStack();
		if (last == null && elemNum==capacity) {
			Stack stk = new Stack();
			stk.push(num);
			stacksSet.add(stk);
		}
		else {
			last.push(num);
		}
		elemNum++;
	}
	
	public Object pop() {
		Stack last = getLastStack();
		Object num = last.pop();
		if (last.isEmpty())
			stacksSet.remove(stacksSet.size()-1);
		return num;
	}
	
	private Stack getLastStack() {
		int size = stacksSet.size();
		return size==0?null:stacksSet.get(size-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
