/*Skip lists is a data structure used for searching. 
 * It is easier to implement compared to self balancing trees,
 * however, is not as efficient as hashing yet preferred one due to simplicity.
 * Complexity: FIND, INSERT, ERASE - All log n
 */
package DataStructures;

import java.util.Random;

public class SkipLists {
	Node head;

	SkipLists() {
		Node start = new Node(limits.NEGATIVE_INFINITY.getNumVal());
		Node end = new Node(limits.POSITIVE_INFINITY.getNumVal());
		start.setAfter(end);
		end.setBefore(start);
		head = start;
	}	//End of constructor
	
	/*
	 * This method returns pointer to the largest node in skip list 
	 * with its key <= the required key value
	 */
	public Node lowerBound(int val) {
		Node p = head;
		while(null != p.getBelow()) {
			p = p.getBelow();
			while(p.getAfter().getKey() <= val)
				p=p.getAfter();
		}
		return p;
	}	//End of lowerBound() method
	
	/*
	 * This method returns true if an element is found in the list and false otherwise
	 */
	public boolean find(int val) {
		Node p = lowerBound(val);
		return (p.getKey()==val);
	}	//End of find() method

	/*
	 * This method inserts a node into the skip list
	 * Skip lists insert node in a sorted order. 
	 * Thus, we use lower bound to get the position where the new node has to be inserted.
	 */
	public void insert(int val) {
		Node p = lowerBound(val);
		//We need not insert this value if it already exists
		if (p.getKey()!=val) {
			Node q = insertAfternAbove(p, null, val);
			Random rnd = new Random();
			/*
			 * Using random boolean variable for coin tossing.
			 * True = heads; false = tails
			 */
			while(rnd.nextBoolean()) {
				while(null == p.getAbove())
					p=p.getBefore();
				p=p.getAbove();
				q=insertAfternAbove(p, q, val);
			}
		}
	}	//End of insert() method
	
	/*
	 * Creates links with the neighboring nodes to insert the new node in to list
	 */
	public Node insertAfternAbove(Node hrzntl, Node vrtcl, int val) {
		Node n = new Node(val);
		n.setBefore(hrzntl);
		n.setAfter(hrzntl.getAfter());
		n.setBelow(vrtcl);
		
		hrzntl.setAfter(n);
		n.getAfter().setBefore(n);
		if (null != vrtcl)
			vrtcl.setAbove(n);
		return n;
	}	//End of insertAfternAbove() method
	
	/*
	 * This method marks a node to delete from skip list, if it exists
	 */
	public void erase(int val) {
		Node p = lowerBound(val);
		if (p.getKey()==val) {
			while (null != p.getAbove()) {
			Node q=p;
			p=p.getAbove();
			delete(q);
			}
			delete(p);
		}
	}	//End of erase
	
	/*
	 * This method actually deletes the node by updating the links
	 */
	public void delete(Node d) {
		d.getBefore().setAfter(d.getAfter());
		d.getAfter().setBefore(d.getBefore());
		d.getBelow().setAbove(d.getAbove());
		d.getAbove().setBelow(d.getBelow());
	}
	
	/*
	 * This enum defines negative infinity and maximum infinity
	 */
	private enum limits {
		NEGATIVE_INFINITY(Integer.MIN_VALUE), POSITIVE_INFINITY(
				Integer.MAX_VALUE);
		private int numVal;

		limits(int numVal) {
			this.numVal = numVal;
		}

		public int getNumVal() {
			return numVal;
		}
	} // End on enum limits

	/*
	 * Defining the structure of a node in a skip list Each node stores a key
	 * and points to 4 other nodes: 1 before it, 1 after it, 1 above it and 1
	 * below it
	 */
	private class Node {
		int key; // Actual data that is being stored
		Node before = null;
		Node after = null;
		Node above = null;
		Node below = null;

		Node(int key) {
			this.key = key;
		}

		//Getter and setter methods.
		public void setBefore(Node before) {
			this.before = before;
		}

		public void setAfter(Node after) {
			this.after = after;
		}

		public void setAbove(Node above) {
			this.above = above;
		}

		public void setBelow(Node below) {
			this.below = below;
		}

		public int getKey() {
			return key;
		}

		public Node getBefore() {
			return before;
		}

		public Node getAfter() {
			return after;
		}

		public Node getAbove() {
			return above;
		}

		public Node getBelow() {
			return below;
		}
	}
}
