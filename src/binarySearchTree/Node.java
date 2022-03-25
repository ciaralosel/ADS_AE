package binarySearchTree;

public class Node {
	private int key;
	private Node left;
	private Node right;

	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public void setLeftNode(Node left) {
		this.left = left;
	}
	
	public void setRightNode(Node right) {
		this.right = right;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public Node getLeftNode() {
		return left;
	}
	
	public Node getRightNode() {
		return right;
	}
	
	public int getKey() {
		return key;
	}
	
}
