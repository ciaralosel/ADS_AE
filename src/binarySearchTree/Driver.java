package binarySearchTree;

import doublyLinkedList.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Driver {
	public static BinarySearchTree t1 = new BinarySearchTree();
	public static BinarySearchTree t2 = new BinarySearchTree();
	public static BinarySearchTree t3 = new BinarySearchTree();
	
	public static DoublyLinkedList l1 = new DoublyLinkedList();
	public static DoublyLinkedList l2 = new DoublyLinkedList();
	public static DoublyLinkedList l3 = new DoublyLinkedList();
	
	public static void populateBSTTest() {
		t1.add(1);
		t1.add(2);
		t1.add(3);
		t1.add(11);
		t1.add(12);
		t1.add(13);
		t2.add(3);
		t2.add(2);
		t2.add(1);
		t2.add(13);
		t2.add(24);
		t1.printInOrder();
		System.out.println("- " + t1.getSetSize() + "\n");
		t2.printInOrder();
		System.out.println("- " + t2.getSetSize() + "\n");
	}
	
	public static void populateDLLTest() {
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(11);
		l1.add(12);
		l1.add(13);
		l2.add(3);
		l2.add(2);
		l2.add(1);
		l2.add(13);
		l2.add(24);
		l1.printInOrder();
		System.out.println("- " + l1.getSetSize() + "\n");
		l2.printInOrder();
		System.out.println("- " + l2.getSetSize() + "\n");
	}
	
	private static void deleteBSTTest() {
		t2.remove(1);
		t2.remove(2);
		t2.remove(3);
		t2.printInOrder();
		System.out.print("- " + t2.getSetSize() + "\n");
	}
	
	private static void deleteDLLTest() {
		l2.remove(1);
		l2.remove(2);
		l2.remove(3);
		l2.printInOrder();
		System.out.print("- " + l2.getSetSize() + "\n");
	}
	
	private static void isEmptyBSTTest() {
		System.out.println("is empty? " + t1.isSetEmpty() + "n");
	}
	
	private static void unionBSTTest() {
		t3 = new BinarySearchTree();
		t3 = t3.union(t1, t2);
		t3.printInOrder();
		System.out.print("- " + t3.getSetSize() + "\n");
	}
	
	private static void unionDLLTest() {
		l3 = new DoublyLinkedList();
		l3 = l3.union(l1, l2);
		l3.printInOrder();
		System.out.print("- " + l3.getSetSize() + "\n");
	}
	
	private static void intersectionBSTTest() {
		t3 = new BinarySearchTree();
		t3 = t3.intersection(t1, t2);
		t3.printInOrder();
		System.out.print("- " + t3.getSetSize() + "\n");
	}
	
	private static void intersectionDLLTest() {
		l3 = new DoublyLinkedList();
		l3 = l3.intersection(l1, l2);
		l3.printInOrder();
		System.out.print("- " + l3.getSetSize() + "\n");
	}
	
	private static void differenceBSTTest() {
		t3 = new BinarySearchTree();
		t3 = t3.difference(t1, t2);
		t3.printInOrder();
		System.out.print("- " + t3.getSetSize() + "\n");
	}
	
	private static void differenceDLLTest() {
		l3 = new DoublyLinkedList();
		l3 = l3.difference(l1, l2);
		l3.printInOrder();
		System.out.print("- " + l3.getSetSize() + "\n");
	}
	
	private static void subsetBSTTest() {
		System.out.print("Is t2 a subset of t1? "+ t2.subset(t2, t2) + "\n");
	}
	
	public static void empiricalStudy() {
		try {
		File file = new File("C:\\Users\\ciara\\eclipse-workspace\\ADSAE2\\int20k.txt");
		Scanner sc = new Scanner(file);
		DoublyLinkedList list = new DoublyLinkedList();
		BinarySearchTree tree = new BinarySearchTree();
		while (sc.hasNextLine()) {
			int x = Integer.parseInt(sc.nextLine());
			list.add(x);
			tree.add(x);
		}
		Random rand = new Random();
		int[] randoms = new int[100];
		for (int i=0; i<100; i++) {
			randoms[i] = rand.nextInt(4999);
		}
		double listAverage = 0;
		double treeAverage = 0;
		for (int i=0; i<100; i++) {
			double startTime = System.nanoTime();
			list.isElement(randoms[i]);
			double endTime = System.nanoTime();
			listAverage = listAverage + (endTime - startTime);
			startTime = System.nanoTime();
			tree.isElement(randoms[i]);
			endTime = System.nanoTime();
			treeAverage = treeAverage + (endTime - startTime);
		}
		System.out.println("List set size:");
		System.out.println(list.getSetSize());
		System.out.println("Tree set size:");
		System.out.println(tree.getSetSize());
		System.out.println("Average list time:");
		System.out.println(listAverage / 100);
		System.out.println("Average tree time:");
		System.out.println(treeAverage / 100);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		empiricalStudy();
		//populateBSTTest();
		//intersectionBSTTest();
		//unionBSTTest();
		//differenceBSTTest();
		//deleteBSTTest();
		/*
		populateDLLTest();
		intersectionDLLTest();
		unionDLLTest();
		differenceDLLTest();
		deleteDLLTest();
		*/
	}
}
