package DataStructures;

public class Node {
	private int data;
	private Node next;

	@SuppressWarnings("null")
	public Node() {
		this.data = (Integer) null;
		this.next = null;
	} // End of default constructor

	public Node(int data) {
		this.data = data;
		this.next = null;
	} // End of parameterized constructor

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}
} // End of class Node
