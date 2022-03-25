package doublyLinkedList;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public DoublyLinkedList() {
		this.size = 0;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void setHead(Node node) {
		this.head = node;
	}
	
	public boolean isElement(int d) {
		Node currentNode = this.head;
		while(currentNode != null) {
			if (currentNode.getData() == d) {
				return true;
			}
			currentNode = currentNode.getNextNode();
		}
		return false;
	}
	
	public boolean isSetEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getSetSize() {
		return this.size;
	}
	
	public boolean add(int x) {
		if (!isElement(x)) {
			Node newNode = new Node(x);
			if ((head == null) && (tail == null)) {
				head = newNode;
				tail = newNode;
			} else {
				tail.setNextNode(newNode);
				newNode.setPrevNode(tail);
				tail = newNode;
			}
			this.size = this.size + 1;
			return true;
		}
		return false;
	}
	
	public boolean remove(int x) {
		Node currentNode = this.head;
		while(currentNode != null) {
			if (currentNode.getData() == x) {
				if (currentNode == head) {
					head = currentNode.getNextNode();
					currentNode.getNextNode().setPrevNode(null);
				}else if (currentNode == tail) {
					tail = currentNode.getPrevNode();
					currentNode.getPrevNode().setNextNode(null);
				} else {
					currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
					currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
				}
				this.size = this.size - 1;
				return true;
			}
		}
		return false;
	}
	
	public DoublyLinkedList union(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node currentList1Node = list1.head;
		Node currentList2Node = list2.head;
		DoublyLinkedList result = new DoublyLinkedList();
		while (currentList1Node != null) {
			result.add(currentList1Node.getData());
			currentList1Node = currentList1Node.getNextNode();
		}
		while (currentList2Node != null) {
			result.add(currentList2Node.getData());
			currentList2Node = currentList2Node.getNextNode();
		}
		return result;
	}
	
	public DoublyLinkedList intersection(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node currentList1Node = list1.head;
		DoublyLinkedList result = new DoublyLinkedList();
		while (currentList1Node != null) {
			if (list2.isElement(currentList1Node.getData())){
				result.add(currentList1Node.getData());
			}
			currentList1Node = currentList1Node.getNextNode();
		}
		return result;
	}
	
	public DoublyLinkedList difference(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node currentList1Node = list1.head;
		DoublyLinkedList result = new DoublyLinkedList();
		while(currentList1Node != null) {
			if (!list2.isElement(currentList1Node.getData())) {
				result.add(currentList1Node.getData());
			}
			currentList1Node = currentList1Node.getNextNode();
		}
		return result;
	}
	
	public boolean subset(DoublyLinkedList list1, DoublyLinkedList list2) {
		Node currentList1Node = list1.head;
		boolean isSubset = true;
		while(currentList1Node != null) {
			if (!list2.isElement(currentList1Node.getData())) {
				isSubset = false;
			}
			currentList1Node = currentList1Node.getNextNode();
		}
		return isSubset;
	}
	
	public void printInOrder() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}

}
