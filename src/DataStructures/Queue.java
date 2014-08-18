/*
 * Implementation of queue data structure using linked list node.
 */
package DataStructures;

public class Queue {
	private Node first, last;
	
	Queue() {
		first = null;
		last = null;
	}
	
	void enqueue(int val) {
		Node newNode = new Node(val);
		if (first == null) {
			last = newNode;
			first = last;
		}
		else {
			last.setNext(newNode);
			last = last.getNext();
		}
	}
	
	Node dequeue() {
		if (first!=null) {
			Node item = first;
			first = first.getNext();
			return item;
		}
		else
			System.out.println("Queue Empty");
		return null;
	}
	
	void display() {
		Node current = first;
		System.out.println("---------------------");
		if (current == null)
			System.out.println("Queue Empty");
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
		Queue q = new Queue();
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
