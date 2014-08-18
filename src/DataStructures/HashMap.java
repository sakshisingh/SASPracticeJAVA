/**
 * 
 */
package DataStructures;

/**
 * @author Sakshi
 * 
 */
public class HashMap {

	/*
	 * Single entry in a hash map has key value pair. To store this pair we
	 * create private inner class - Entry.
	 */
	private class Entry {
		String key;
		int value;
		Entry next;

		@SuppressWarnings({ "unused", "null" })
		Entry() {
			this.key = null;
			this.value = (Integer) null;
			this.next = null;
		}

		Entry(String key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		String getKey() {
			return this.key;
		}

		void setKey(String key) {
			this.key = key;
		}

		int getValue() {
			return this.value;
		}

		void setValue(int value) {
			this.value = value;
		}

		@SuppressWarnings("unused")
		Entry getNext() {
			return this.next;
		}

		void setNext(Entry next) {
			this.next = next;
		}

		public String toString() {
			return "Key: [" + this.key + "] Data: [" + this.value + "]";
		}

	} // End of inner class Entry

	private final int tableSize = 20;

	Entry[] hashTable;

	// Default constructor
	public HashMap() {
		hashTable = new Entry[tableSize];
		for (int i = 0; i < tableSize; i++)
			hashTable[i] = null;
	} // End of Default constructor

	// contains method returns true if key already exists in the table
	public boolean contains(String key) {
		int index = getIndex(key);
		// Traverse the linked list starting at the index position returned
		Entry head = hashTable[index];
		while (head != null) {
			if (head.getKey().equals(key))
				return true;
			head = head.next;
		}
		return false;
	} // End of method contains(String)

	// Method to put an entry into hash table
	public void put(String key, int value) {
		if (!contains(key)) {
			int index = getIndex(key);
			// Traverse the linked list starting at the index position returned
			Entry head = hashTable[index];
			if (head.equals(null)) {
				head.setKey(key);
				head.setValue(value);
			} else {
				Entry newNode = new Entry(key, value);
				newNode.setNext(head);
				head = newNode;
			}
		}
	} // End of method put(String, int)

	// get method returns value corresponding to the key
	@SuppressWarnings("null")
	public int get(String key) {
		int index = getIndex(key);

		// Traverse the linked list starting at the index position returned
		Entry head = hashTable[index];
		while (head != null) {
			if (head.getKey().equals(key))
				return head.getValue();
			head = head.next;
		}

		return (Integer) null;
	} // End of method get(String)

	// To calculate the index convert and add ASCII value of each character in
	// the string
	// Take mod tableSize of this value to get index
	private int getIndex(String key) {
		int index = 0;
		char[] input = key.toLowerCase().toCharArray();
		for (char ch : input) {
			int ascii = (int) ch;
			index += ascii;
		}
		return index % tableSize;
	} // End of private method getIndex(String)
}
