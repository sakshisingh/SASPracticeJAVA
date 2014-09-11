/*
 * Implementation of linked list data structure
 */
package DataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {
	private Node head;

	// Default constructor. Creates an empty list.
	public SinglyLinkedList() {
		head = null;
	} // End of default constructor

	// This method checks if the list is empty
	public boolean isEmpty() {
		return head == null;
	}

	// Add an element at first position, i.e. beginning of list
	public void insertBegin(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	// Add an element at last position, i.e. end of list
	public void insertEnd(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}
	
	// Loop the last element to a node at given position
		public void insertLoop(int pos) {
			Node last = head;
			while (last.getNext() != null) {
				last = last.getNext();
			}
			Node current = head;
			int i = 0;
			while (current.getNext() != null && i < pos) {
				current = current.getNext();
				if (++i + 1 == pos)
					break;
			}
			if (current.getNext() == null && i + 1 != pos)
				System.out.println("Invalid position...");
			else {
				last.setNext(current.getNext());
			}
		}

	// Add an element at the given position
	public void insertAtPos(int val, int pos) {
		Node newNode = new Node(val);
		Node current = head;
		int i = 0;
		while (current.getNext() != null && i < pos) {
			current = current.getNext();
			if (++i + 1 == pos)
				break;
		}

		if (current.getNext() == null && i + 1 != pos)
			System.out.println("Invalid position...");
		else {
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}

	// Add an element in a sorted list
	public void insertSorted(int val) {
		Node current = head;
		int pos=-1, i = 0;
		while (current.getNext() != null) {
			if (val>=current.getData() && val<current.getNext().getData()) {
				pos = i;
				break;
			}
			i++;
			current = current.getNext();
		}
		if (pos==-1)
			insertEnd(val);
		else
			insertAtPos(val, pos);
	}

	//Delete a node from the begin of list
	public void deleteBegin() {
		if (head == null)
			System.out.println("Empty List");
		else if (head.getNext() == null)
			head = null;
		else
			head = head.getNext();
	}

	//Delete a node from the begin of list
	public void deleteEnd() {
		if (head == null)
			System.out.println("Empty List");
		else if (head.getNext() == null)
			head = null;
		else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current = current.getNext();
		}
	}
	
	/*
	 * Delete a node from the middle of list.
	 * Maintain 2 pointers - current(increment by 1) and runner (increment by 2). 
	 * When runner is at end or one before end, current is at middle position
	 */
	public void deleteMiddle() {
		int pos=0;
		Node current=head, prv=head, runner=head;
		while (runner != null && runner.getNext()!=null) {
			pos++;
			prv=current;
			current=current.getNext();
			runner=runner.getNext().getNext();
		}
		System.out.println("Deleting node at position: " + pos + " with data: " + current.getData());
		prv.setNext(current.getNext());
	}

	//Reverse a list
	public void reverseList() {
		if (head == null)
			System.out.println("Empty List");
		else {
			Node current = head.getNext();
			Node base = head;
			Node pre;
			while (current != null) {
				pre = base;
				base = current;
				current = current.getNext();
				base.setNext(pre);
			}
			head.setNext(null);
			head = base;
		}
	}

	//Check if the list has a loop
	public boolean hasLoop() {
		Node slowPointer = head, fastPointer = head;
		try {
		while (true) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if (slowPointer == fastPointer)
				return true;
			}
		}
		catch (NullPointerException ne) {
			return false;
		}
	}
	
	/*
	 * Find the start of loop
	 * Detect loop using floyd's algo.
	 * When fast and slow pointer meet, move slow to the head of list.
	 * Move both pointers by 1 step.
	 * When the y collide again it is start of loop.
	 * Return this node.
	 */
	public Node loopStart() {
		Node slowPointer = head, fastPointer = head;
		try {
		while (true) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
			if (slowPointer == fastPointer)
				break;
			}
		}
		catch (NullPointerException ne) {
			return null;
		}
		slowPointer = head;
		while(slowPointer!=fastPointer){
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext();
		}
		return slowPointer;
	}
	
	/*
	 * Check if a linked list is palindrome.
	 * Solution 1: Reverse and compare half of the list
	 */
	public boolean palindrome1() {
		SinglyLinkedList reversedList = this;
		reversedList.reverseList();
		int mid = this.size()/2;
		this.display();reversedList.display();
		Node original = this.head;
		Node reversed = reversedList.head;
		for (int i=0; i<mid; i++) {
			if(original.getData() == reversed.getData())
				return false;
			original = original.getNext();
			reversed = reversed.getNext();
		}
		return true;
	}
	
	//Method to delete duplicates from a linked list using hashmap.
	// Complexity: O(n)
	public void removeDuplicates() {
		HashMap<Integer, Boolean> dataMap = new HashMap<>();
		Node current = head;
		Node prv = head;
		
		while (current!=null) {
			Integer currentData = current.getData();
			if(dataMap.containsKey(currentData)) {
				prv.setNext(current.getNext());
			}
			else {
				dataMap.put(currentData, true);
				prv = current;
			}
			current = current.getNext();
		}
	}
	
	/*
	 * Method to delete duplicates without using buffer
	 * Space Complexity O(1); Time complexity O(n^2)
	 */
	public void removeDuplicates2() {
		if (head == null)
			return;
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.getNext() != null) {
				if (runner.getNext().getData() == current.getData()) {
					runner.setNext(runner.getNext().getNext());
				}
				else {
					runner = runner.getNext();
				}
			}
			current = current.getNext();
		}
	}

	//return size i.e. num of elements in a linked list
		public int size() {
			int size=0;
			Node current=head;
			Set<Node> nodeSet = new HashSet<>();
			while (current !=null && (!nodeSet.contains(current))) {
				nodeSet.add(current);
				size++;
				current=current.getNext();
			}
			return size;
		}
	
	//Method to find nth element from the end of linked list.
	public int findNElementEnd(int pos) {
		int size = size();
		Node current=head;
		if (size<pos) {
			System.out.println("Position: " + pos + " is greater than the linked list size: " + size);
			return -1;
		}
		int i = size-pos;
		while(i>0) {
			current = current.getNext();
			i--;
		}
		System.out.println("Data at Position from end: " + pos + " is: " + current.getData());
		return current.getData();
	}
	
	/*
	 * Method to partition linked list around element 'x'.
	 * All elements less than x come before all the elements greater than 'x'
	 */
	public void partition(int x) {
		SinglyLinkedList beforeX = new SinglyLinkedList();
		SinglyLinkedList afterX = new SinglyLinkedList();
		Node current = head;
		while(current!=null) {
			if (current.getData()==x)
				beforeX.insertEnd(current.getData());
			else if (current.getData()<x)
				beforeX.insertBegin(current.getData());
			else 
				afterX.insertBegin(current.getData());
			current = current.getNext();
		}
		if(beforeX.isEmpty())
			this.head = afterX.head;
		else {
			if (afterX.head != null) {
				current = beforeX.head;
				while (current.getNext()!=null)
					current = current.getNext();
				current.setNext(afterX.head);
			}
			this.head = beforeX.head;
		}	
	}
	
	/*
	 * This method adds up two numbers with digits represented in order in linked list node
	 * e.g.: I/P: (6->1->7) + (2->9->5) i.e. 617 + 295
	 * O/P: (9->1->2) i.e. 912
	 */
	public SinglyLinkedList digitsAdd(SinglyLinkedList l2) {
		if (this.isEmpty())
			return l2;
		if (l2.isEmpty())
			return this;
		SinglyLinkedList addResult = new SinglyLinkedList();
		int value=0, value1=0, value2=0;
		Node l1Current = this.head, l2Current = l2.head;
		while (l1Current != null) {
			if (l1Current.getNext() == null)
				value1 = (value1 + l1Current.getData());
			else
				value1 = (value1 + l1Current.getData())*10;
			l1Current = l1Current.getNext();
		}
		while (l2Current != null) {
			if (l2Current.getNext() == null)
				value2 = (value2 + l2Current.getData());
			else
				value2 = (value2 + l2Current.getData())*10;
			l2Current = l2Current.getNext();
		}
		value = value1 + value2;
		System.out.println("Value1 = " + value1 + " Value2 = " + value2 + " Value = " + value);
		while (value !=0) {
			addResult.insertBegin(value%10);
			value = value/10;
		}
		return addResult;
	}
	
	/*
	 * This method adds up two numbers with digits represented in reveresed order in linked list node
	 * e.g.: I/P: (7->1->6) + (5->9->2) i.e. 617 + 295
	 * O/P: (2->1->9) i.e. 912
	 */
	public SinglyLinkedList reverseDigitsAdd(SinglyLinkedList l2) {
		if (this.isEmpty())
			return l2;
		if (l2.isEmpty())
			return this;
		SinglyLinkedList addResult = new SinglyLinkedList();
		int value=0, carry=0;
		Node l1Current = this.head, l2Current = l2.head;
		while (!(l1Current == null && l2Current == null && carry ==0)) {
			value = carry + ((l1Current==null)?0:l1Current.getData()) + ((l2Current==null)?0:l2Current.getData());
			carry = value/10;
			value = value%10;
			l1Current = l1Current==null?l1Current:l1Current.getNext();
			l2Current = l2Current==null?l2Current:l2Current.getNext();
			addResult.insertEnd(value);
		}
		return addResult;
	}
	
	/*
	 * Return node having value X
	 */
	private Node findElement(int x) {
		Node current = head;
		while (current.getNext() != null) {
			if (current.getData()==x)
				return current;
			current = current.getNext();
		}
		return null;
	}
	
	private Node lastElement() {
		Node current = head;
		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}
		return current;
	}
	
	public void display() {
		Node current = head;
		System.out.println();
		System.out.println("---------------------");
		while (current != null) {
			if (current.getNext() != null)
				System.out.print(current.getData() + "-->");
			else
				System.out.print(current.getData());
			current = current.getNext();
		}
		//System.out.print(current.getData());
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		//sll.insertBegin(3);
		sll.insertBegin(2);	//Should insert
		sll.insertBegin(1);	//Should insert
		sll.insertEnd(4);	//Should insert
		System.out.println("Get size(3): " + sll.size());
		sll.insertAtPos(5, 3);	//Should insert
		sll.insertAtPos(6, 8);	//Invalid
		sll.insertSorted(3);	//Should insert
		sll.insertSorted(6);	//Should insert
		sll.insertSorted(7);	//Should insert
		sll.display();
		System.out.println("Get size(7): " + sll.size());
		sll.findNElementEnd(1);
		sll.deleteMiddle();
		sll.display();
		sll.reverseList();
		System.out.println("Get size(6) : " + sll.size());
		// sll.deleteBegin();
		sll.display();
		sll.insertBegin(2);	//Should insert
		sll.insertAtPos(6, 8);	//Invalid
		sll.insertEnd(5);	//Should insert
		System.out.println("Get size(8): " + sll.size());
		sll.insertEnd(15);
		sll.insertEnd(16);
		sll.insertEnd(15);
		sll.insertEnd(15);
		sll.display();
		sll.deleteMiddle();	//Should delete 1
		sll.display();
		sll.removeDuplicates2();	//Should remove 2
		sll.display();
		System.out.println("Get size (5): " + sll.size());
		System.out.println();
		sll.partition(7);
		sll.display();
		System.out.println();
		System.out.println("Has Loop? " + sll.hasLoop());
		System.out.println("Get size (5): " + sll.size());
		System.out.println("Current linked list: ");
		sll.display();
		sll.insertLoop(2);
		System.out.println("Has Loop? " + sll.hasLoop());
		Node loop = sll.loopStart();
		System.out.println("Loop begins at value(pos 3): " + loop.getData());
		sll.insertAtPos(6, 4);
		System.out.println("Get size (6): " + sll.size());
		
		SinglyLinkedList l1 = new SinglyLinkedList();
		SinglyLinkedList l2 = new SinglyLinkedList();
		l1.insertEnd(9);
		l1.insertEnd(9);
		l1.insertEnd(9);
		l2.insertEnd(9);
		l2.insertEnd(9);
		l2.insertEnd(9);
		SinglyLinkedList result = l1.digitsAdd(l2);
		l1.display();
		l2.display();
		result.display();
		
		SinglyLinkedList l3 = new SinglyLinkedList();
		l3.insertEnd(9);
		l3.insertEnd(2);
		l3.insertEnd(5);
		l3.insertEnd(6);
		l3.insertEnd(1);
		l3.insertEnd(9);
		System.out.println("Palindrome?: " + l3.palindrome1());
	}
}
