package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList arrlist=new ArrayList();
		arrlist.add(10);
		arrlist.add(20);
		arrlist.add(30);
		for(Object item:arrlist) {
			System.out.print(item+" ");
		}
		System.out.println();
		System.out.println("After deleting: ");
		arrlist.remove(1);
		for(Object item:arrlist) {
			System.out.println(item+" ");
		}
		System.out.println();
		System.out.println("After updating:");
		arrlist.set(1, 60);
		for(Object item:arrlist) {
			System.out.println(item+" ");
		}
		
		//generic interaror
		System.out.println("Using iterator on generid object");
		Iterator iterator = arrlist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		ArrayList<Integer> arrlist1=new ArrayList<>();
		arrlist1.add(10);
		arrlist1.add(20);
		arrlist1.add(30);
		for(Integer item:arrlist1) {
			System.out.print(item+" ");
		}
		System.out.println();
		System.out.println("After deleting: ");
		arrlist1.remove(1);
		for(Integer item:arrlist1) {
			System.out.println(item+" ");
		}
		System.out.println();
		System.out.println("After updating:");
		arrlist1.set(1, 60);
		for(Integer item:arrlist1) {
			System.out.println(item+" ");
		}
		System.out.println("Using listinterator");
		ListIterator<Integer> listiterator = arrlist1.listIterator();
		
		while(listiterator.hasNext()) {
			//System.out.println(listiterator.next());
			//System.out.println(listiterator.next());
			//System.out.println(listiterator.previous());
			//System.out.println(listiterator.previous());
			if(listiterator.hasPrevious()) {
				System.out.println(listiterator.previous());
			}
		}
		
		}
}