
package interviewPrograms;

public class StackUsingArray {
	final static int stackSize = 100;	//Size of each stack
	final static int numStack = 3;	// Number of stacks
	
	int [] stackBuffer = new int[stackSize * numStack];	//Single Array to store all stack elements
	int [] stackpointer = new int [numStack];	//Indicates top of each stack (# elements in each stack)

	public StackUsingArray() {
		//Initialize top of each stack to -1 to indicate empty stack
		for (int i=0; i<numStack; i++)
			stackpointer[i] = -1;
	}
	
	public void push(int stackNum, int value) throws Exception {
		//Check if stackNum stack has space for more elements
		if (stackpointer[stackNum] + 1 >= stackSize)
			throw new Exception ("Stack full. Out of space.");
		//Increment top pointer and insert element
		stackpointer[stackNum]++;
		stackBuffer[getTopPosition(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws Exception{
		//Check if corresponding stack is empty
		if (stackpointer[stackNum] == -1)
			throw new Exception ("Empty Stack.");
		
		int value = stackBuffer[getTopPosition(stackNum)];
		stackpointer[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) throws Exception {
		//Check if corresponding stack is empty
		if (stackpointer[stackNum] == -1)
			throw new Exception ("Empty Stack.");
		return stackBuffer[getTopPosition(stackNum)];
	}
	
	public boolean isEmpty(int stackNum) {
		return (stackpointer[stackNum] == -1);
	}
	
	private int getTopPosition(int stacknum) {
		return (stacknum*stackSize) + stackpointer[stacknum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
