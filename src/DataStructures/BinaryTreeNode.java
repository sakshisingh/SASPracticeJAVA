package DataStructures;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode() {
		data = -1;
		left = null;
		right = null;
	}

	public BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(BinaryTreeNode node) {
		this.left = node;
	}

	public void setRight(BinaryTreeNode node) {
		this.right = node;
	}
}
