/*
 * Implementation of stack data structure using linked list node.
 */
package DataStructures;

public class Stack {
	Node top;
	
	public Stack(){
		top = null;
	}
	
	protected Stack(int num) {
		top.setData(num);
		top.setNext(null);
	}
	
	public void push(int num) {
		Node newNode = new Node(num);
		if (top == null) {
			top = newNode;	
		} else {
			newNode.setNext(top);
			top = newNode;
		}
	}
	
	public Object pop() {
		Object num = null;
		if (top==null) {
			System.out.println("Stack Underflow");
		}
		else {
			num = top.getData();
			if (top.getNext()==null)
			top=null;
		else
			top = top.getNext();
		}
		return num;
	}
	
	public Object peek() {
		Object num = null;
		if (top==null)
			System.out.println("Stack Underflow");
		else
			num = top.getData();
		return num;
	}
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void display() {
		Node current = top;
		System.out.println("---------------------");
		if (current == null)
			System.out.println("Stack Empty");
		else {
		while (current.getNext()!=null){
			System.out.print(current.getData() + "-->");
			current = current.getNext();
		}
		System.out.print(current.getData());
		System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Stack stk = new Stack();
		stk.push(1);
		stk.push(3);
		stk.push(2);
		stk.push(6);
		stk.push(5);
		stk.push(4);
		
		stk.display();
		
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();

		stk.display();

	}
}
