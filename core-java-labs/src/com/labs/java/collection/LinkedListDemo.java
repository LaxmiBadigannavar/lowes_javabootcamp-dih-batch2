package com.labs.java.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<Integer> linkedlist=new LinkedList<>();
		linkedlist.add(100);
		linkedlist.add(200);
		linkedlist.add(300);
		System.out.println("Linked List:");
		for(Integer item:linkedlist) {
			System.out.print(item+" ");
		}
		
		System.out.println();
		System.out.println("After deleting: ");
		linkedlist.remove(1);
		for(Integer item:linkedlist) {
			System.out.println(item+" ");
		}
		System.out.println();
		System.out.println("After updating:");
		linkedlist.set(1, 60);
		for(Object item:linkedlist) {
			System.out.println(item+" ");
		}
		
		System.out.println("Using  iterator");
		Iterator<Integer> iterator = linkedlist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		

	}

}
