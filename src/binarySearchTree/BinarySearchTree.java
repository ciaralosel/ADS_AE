package binarySearchTree;

import doublyLinkedList.DoublyLinkedList;

public class BinarySearchTree {
	private Node root;
	private int size;
	
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}
	
	public boolean isElement(int d) {
		return isElementRecursive(d, this.root);
	}
	
	private boolean isElementRecursive(int d, Node node) {
		if (node == null) {
			return false;
		}
		if(node.getKey() == d) {
			return true;
		}
		if (isElementRecursive(d, node.getLeftNode())) {
				return true;
		}
		return isElementRecursive(d, node.getRightNode());
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
	
	public void add(int x) {
		if (!isElement(x)) {
			this.root = addRecursive(x, root);
			this.size = this.size + 1;
		}
	}
	
	private Node addRecursive(int x, Node currentNode) {
		if (currentNode == null) {
			return new Node(x);
		} else if (x < currentNode.getKey()) {
			currentNode.setLeftNode(addRecursive(x, currentNode.getLeftNode()));
		} else if (x > currentNode.getKey()) {
			currentNode.setRightNode(addRecursive(x, currentNode.getRightNode()));
		} else {
			return currentNode;
		}
		return currentNode;
	}
	
	private int minValue(Node node) {
		int min = node.getKey();
		while(node.getLeftNode() != null) {
			min = node.getLeftNode().getKey();
			node = node.getLeftNode();
		}
		return min;
	}
	
	public void remove(int x) {
		this.root = removeRecursive(x, this.root);
		this.size = this.size - 1;
	}
	
	private Node removeRecursive(int x, Node currentNode) {
		if (currentNode == null) {
			return currentNode;
		} else if (x < currentNode.getKey()) {
			currentNode.setLeftNode(removeRecursive(x, currentNode.getLeftNode()));
		} else if (x > currentNode.getKey()) {
			currentNode.setRightNode(removeRecursive(x, currentNode.getRightNode()));
		} else {
			if (currentNode.getLeftNode() == null) {
				return currentNode.getRightNode();
			} else if (currentNode.getRightNode() == null) {
				return currentNode.getLeftNode();
			}
			currentNode.setKey(minValue(currentNode.getRightNode()));
			currentNode.setRightNode(removeRecursive(currentNode.getKey(), currentNode.getRightNode()));
		}
		return currentNode;
	}
	
	public BinarySearchTree naiveUnion(BinarySearchTree tree1, BinarySearchTree tree2) {
		BinarySearchTree union = tree1;
		naiveUnionRecursive(union, tree2.root);
		return union;
	}
	
	private void naiveUnionRecursive(BinarySearchTree union, Node node) {
		if (node == null) {
			return;
		}
		naiveUnionRecursive(union, node.getLeftNode());
		naiveUnionRecursive(union, node.getRightNode());
		if (!union.isElement(node.getKey())) {
			union.add(node.getKey());
		}
	}
	
	public BinarySearchTree union(BinarySearchTree tree1, BinarySearchTree tree2) {
		DoublyLinkedList list1 = new DoublyLinkedList();
		DoublyLinkedList list2 = new DoublyLinkedList();
		DoublyLinkedList unionList = new DoublyLinkedList();
		treeToList(tree1.root, list1);
		treeToList(tree1.root, list1);
		treeToList(tree2.root, list2);
		unionList = unionList.union(list1, list2);
		BinarySearchTree unionTree = new BinarySearchTree();
		listToTree(unionList.getHead(), unionTree);
		return unionTree;
	}
	
	private void listToTree(doublyLinkedList.Node currentNode, BinarySearchTree tree) {
		while (currentNode != null) {
			tree.add(currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}
	
	private void treeToList(binarySearchTree.Node node, DoublyLinkedList list) {
		if (node == null) {
			return;
		}
		treeToList(node.getLeftNode(), list);
		list.add(node.getKey());
		treeToList(node.getRightNode(), list);
	}
	
	
	public BinarySearchTree intersection(BinarySearchTree tree1, BinarySearchTree tree2) {
		BinarySearchTree intrsctn = new BinarySearchTree();
		intersectionRecursive(tree1, tree2.root, intrsctn);
		intersectionRecursive(tree2, tree1.root, intrsctn);
		return intrsctn;
	}
	
	private void intersectionRecursive(BinarySearchTree tree, Node node, BinarySearchTree intrsctn) {
		if (node == null) {
			return;
		}
		intersectionRecursive(tree, node.getLeftNode(), intrsctn);
		intersectionRecursive(tree, node.getRightNode(), intrsctn);
		if ((tree.isElement(node.getKey())) && (!intrsctn.isElement(node.getKey()))) {
			intrsctn.add(node.getKey());
		}
	}
	
	public BinarySearchTree difference(BinarySearchTree tree1, BinarySearchTree tree2) {
		BinarySearchTree difference = new BinarySearchTree();
		differenceRecursive(tree2, tree1.root, difference);
		return difference;
	}
	
	private void differenceRecursive(BinarySearchTree tree, Node node, BinarySearchTree difference) {
		if (node == null) {
			return;
		}
		differenceRecursive(tree, node.getLeftNode(), difference);
		differenceRecursive(tree, node.getRightNode(), difference);
		if (!tree.isElement(node.getKey())) {
			difference.add(node.getKey());
		}
	}
	
	public boolean subset(BinarySearchTree tree1, BinarySearchTree tree2) {
		return subsetRecursive(tree1.root, tree2, true);
	}
	
	private boolean subsetRecursive(Node node, BinarySearchTree tree, boolean breakRecursion) {
		if (node == null) {
			return true;
		}
		if (!tree.isElement(node.getKey())) {
			return false;
		}
		if (!subsetRecursive(node.getLeftNode(), tree, true)) {
			return false;
		}
		if (!subsetRecursive(node.getRightNode(), tree, true)) {
			return false;
		}
		if (breakRecursion) {
			return false;
		} else {
			return true;
		}
	}
	
	public void printInOrder() {
		printInOrderRecursive(root);
	}
	
	void printInOrderRecursive(Node root) {
		if (root != null) {
			printInOrderRecursive(root.getLeftNode());
			System.out.println(root.getKey()+" ");
			printInOrderRecursive(root.getRightNode());
		}
	}

}
