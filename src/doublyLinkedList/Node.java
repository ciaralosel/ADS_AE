package doublyLinkedList;

public class Node{
	private int data;
	private Node prev;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	public Node(int data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public void setNextNode(Node next) {
		this.next = next;
	}
	
	public void setPrevNode(Node prev) {
		this.prev = prev;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return next;
	}
	
	public Node getPrevNode() {
		return prev;
	}
	
	public int getData() {
		return data;
	}
	

}
