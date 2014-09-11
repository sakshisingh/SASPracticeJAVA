package DataStructures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	protected BinaryTreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	// Method to insert a node in BST
	public void insert(BinaryTreeNode node, int data) {
		// Check if it is an empty tree.
		// In this case, Create a new node and assign it as root.
		if (root == null)
			root = new BinaryTreeNode(data);
		else {
			// Else, check if data is less than root go to left subtree,
			// greater than root go to right subtree.
			if (data <= node.getData()) {
				// If left child is empty, insert new node here,
				if (node.getLeft() == null)
					node.setLeft(new BinaryTreeNode(data));
				// else go further down left subtree
				else
					insert(node.getLeft(), data);
			} else {
				// If right child is empty, insert new node here,
				if (node.getRight() == null)
					node.setRight(new BinaryTreeNode(data));
				else
					// else go further down right subtree
					insert(node.getRight(), data);
			}
		}
	}

	// Search a node in tree
	public BinaryTreeNode search(BinaryTreeNode node, int key) {
		// In case of empty tree root node will be null
		// If key found, return the node
		if (node == null || node.getData() == key)
			return node;
		else {
			// if key<node.data, search in left subtree.
			if (key < node.getData())
				return search(node.getLeft(), key);
			else
				// if key>node.data, search in right subtree.
				return search(node.getRight(), key);
		}
	}

	// In-order traversal of a BST
	// left-->root-->right (yields sorted order)
	public void inorderTraversal(BinaryTreeNode node) {
		// Traverse the left subtree if it exists
		if (node.getLeft() != null)
			inorderTraversal(node.getLeft());
		// Print node
		System.out.print(node.getData() + "-->");
		// Traverse the right subtree
		if (node.getRight() != null)
			inorderTraversal(node.getRight());
	}

	// Pre-order traversal of a BST: root-->left-->right
	public void preorderTraversal(BinaryTreeNode node) {
		// Print node
		System.out.print(node.getData() + "-->");
		// Traverse the left subtree if it exists
		if (node.getLeft() != null)
			preorderTraversal(node.getLeft());
		// Traverse the right subtree
		if (node.getRight() != null)
			preorderTraversal(node.getRight());
	}

	// Post-order traversal of a BST: left-->right-->root
	public void postorderTraversal(BinaryTreeNode node) {

		// Traverse the left subtree if it exists
		if (node.getLeft() != null)
			postorderTraversal(node.getLeft());
		// Traverse the right subtree
		if (node.getRight() != null)
			postorderTraversal(node.getRight());
		// Print node
		System.out.print(node.getData() + "-->");
	}

	// Delete a node with no children, Simply delete
	// Delete a node with one child, assign its child to parent
	// Delete a node with two child --> Figure out
	public void delete(BinaryTreeNode node, int key) {
		ArrayList<Integer> sorted = new ArrayList<>();
		int max;
		if (root == null)
			System.out.println("Empty Tree...");
		else {
			if (key < node.getData()) {
				if (node.getLeft() == null)
					System.out.println("Key not found...");
				else {
					BinaryTreeNode child = node.getLeft();
					// Mark child for deletion if key found.
					if (child.getData() == key) {
						// If node has no further children, delete its reference
						// from parent.
						if (child.getLeft() == null && child.getRight() == null)
							node.setLeft(null);
						else {
							// If only left child exists, assign that to the
							// parent
							if (child.getLeft() != null
									&& child.getRight() == null)
								node.setLeft(child.getLeft());
							// If only right child exists, assign that to the
							// parent
							if (child.getLeft() == null
									&& child.getRight() != null)
								node.setLeft(child.getRight());
							if (child.getLeft() != null
									&& child.getRight() != null) {
								// Find the maximum value in left subtree.
								max(child.getLeft(), sorted);
								max = sorted.get(sorted.size() - 1);
								// Delete the node with that value
								delete(node, max);
								// Replace the current key value with the found
								// max
								// value
								child.setData(max);
							}
						}
					} else
						delete(child, key);
				}
			} else if (key > node.getData()) {
				if (node.getRight() == null)
					System.out.println("Key not found...");
				else {
					BinaryTreeNode child = node.getRight();
					if (child.getData() == key) {
						// If node has no further children, delete its reference
						// from parent.
						if (child.getLeft() == null && child.getRight() == null)
							node.setRight(null);
						else {
							// If only left child exists, assign that to the
							// parent
							if (child.getLeft() != null
									&& child.getRight() == null)
								node.setRight(child.getLeft());
							// If only right child exists, assign that to the
							// parent
							if (child.getLeft() == null
									&& child.getRight() != null)
								node.setRight(child.getRight());
							if (child.getLeft() != null
									&& child.getRight() != null) {
								// Find the maximum value in left subtree.
								max(child.getLeft(), sorted);
								max = sorted.get(sorted.size() - 1);
								// Delete the node with that value
								delete(node, max);
								// Replace the current key value with the found
								// max
								// value
								child.setData(max);
							}
						}
					} else
						delete(child, key);
				}
			}
		}
	}

	// In-order traversal of a BST
	// left-->root-->right (yields sorted order)
	public void max(BinaryTreeNode node, ArrayList<Integer> sorted) {
		// Traverse the left subtree if it exists
		if (node.getLeft() != null)
			max(node.getLeft(), sorted);
		// Print node
		sorted.add(node.getData());
		// Traverse the right subtree
		if (node.getRight() != null)
			max(node.getRight(), sorted);
	}

	// Post-order traversal of a BST
	// left-->root-->right (yields sorted order)
	public void post(BinaryTreeNode node, ArrayList<Integer> sorted) {
		// Traverse the left subtree if it exists
		if (node.getLeft() != null)
			post(node.getLeft(), sorted);
		// Traverse the right subtree
		if (node.getRight() != null)
			post(node.getRight(), sorted);
		// Print node
		sorted.add(node.getData());
	}

	// Return the lowest common ancestor node of two given nodes
	public int lca(int d1, int d2) {
		int ancData = -1;
		int maxPos = -1;
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		ArrayList<Integer> postorder = new ArrayList<Integer>();
		post(root, postorder);
		max(root, inorder);
		int d1PosInorder = inorder.indexOf(d1);
		int d2PosInorder = inorder.indexOf(d2);
		// If either of the nodes (d1, d2) does not exist, return -1
		if (d1PosInorder == -1 || d2PosInorder == -1)
			return -1;
		List<Integer> inorderAnc = inorder.subList(d1PosInorder, d2PosInorder);
		for (Integer i : inorderAnc) {
			int postPos = postorder.indexOf(i);
			if (postPos > maxPos) {
				ancData = i;
				maxPos = postPos;
			}
		}
		return ancData;
	}

	public float median() {
		ArrayList<Integer> inorder = new ArrayList<>();
		max(root, inorder);
		int size = inorder.size();
		if (size % 2 == 1)
			return inorder.get(size / 2);
		else
			return ((float) (inorder.get(size / 2 - 1) + inorder.get(size / 2))) / 2;
	}

	private int getHeight(BinaryTreeNode node) {
		if (node.equals(null))
			return 0;
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}

	private int checkHeight(BinaryTreeNode node) {
		if (node == null)
			return 0;

		int leftHeight = checkHeight(node.getLeft());
		if (leftHeight == -1)
			return -1;

		int rightHeight = checkHeight(node.getRight());
		if (rightHeight == -1)
			return -1;

		int heightDiff = Math.abs(leftHeight - rightHeight);
		if (heightDiff > 1)
			return -1; // Not balanced
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean isBalanced(BinaryTreeNode node) {
		if (checkHeight(node) == -1)
			return false;
		else
			return true;
	}

	//Create a minimum height binary tree from a sorted array
	public BinaryTreeNode createMinHeightTree(int[] arr, int start, int end) {
		if (start>end)
			return null;
		int mid = (start + end)/2;
		BinaryTreeNode node = new BinaryTreeNode(arr[mid]);
		node.setLeft(createMinHeightTree(arr, start, mid-1));
		node.setRight(createMinHeightTree(arr, mid+1, end));
		return node;
	}
	
	public BinaryTreeNode createMinHeightTree(int[] arr) {
		return createMinHeightTree(arr, 0, arr.length-1);
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(bst.root, 14);
		bst.insert(bst.root, 6);
		bst.insert(bst.root, 12);
		bst.insert(bst.root, 24);
		bst.insert(bst.root, 33);
		bst.insert(bst.root, 15);
		bst.insert(bst.root, 7);
		bst.insert(bst.root, 3);

		System.out.println();
		System.out.println("Preorder: ");
		bst.preorderTraversal(bst.root);
		System.out.println("-----------");

		System.out.println();
		System.out.println("Inorder: ");
		bst.inorderTraversal(bst.root);
		System.out.println("-----------");

		System.out.println();
		System.out.println("Postorder: ");
		bst.postorderTraversal(bst.root);
		System.out.println("-----------");

		System.out.println();
		System.out.println("Balanced?: " + bst.isBalanced(bst.root));
		System.out.println("-----------");

		System.out.println();
		int lca = bst.lca(8, 33);
		if (lca == -1)
			System.out
					.println("No Lowest Common Ancestor found between 8 and 33");
		else
			System.out.println("Lowest Common Ancestor of 8 and 33: " + lca);
		System.out.println("-----------");

		System.out.println();
		System.out.println("Median: " + bst.median());
		System.out.println("-----------");

		bst.delete(bst.root, 15);
		bst.inorderTraversal(bst.root);
		System.out.println();

		bst.delete(bst.root, 1);
		bst.inorderTraversal(bst.root);
		System.out.println();

		bst.delete(bst.root, 12);
		bst.inorderTraversal(bst.root);
		System.out.println();

		System.out.println();
		System.out.println("Median: " + bst.median());
		System.out.println("-----------");
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		BinarySearchTree minBST = new BinarySearchTree();
		minBST.root = minBST.createMinHeightTree(arr);
		System.out.println();
		System.out.println("Preorder: ");
		minBST.preorderTraversal(minBST.root);
		System.out.println("-----------");

		System.out.println();
		System.out.println("Inorder: ");
		minBST.inorderTraversal(minBST.root);
		System.out.println("-----------");

		System.out.println();
		System.out.println("Postorder: ");
		minBST.postorderTraversal(minBST.root);
		System.out.println("-----------");
	}

}
