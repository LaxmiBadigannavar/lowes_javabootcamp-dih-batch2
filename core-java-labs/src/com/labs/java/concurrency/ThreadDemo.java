package com.labs.java.concurrency;

public class ThreadDemo {

	public static void main(String[] args) {
		System.out.println("Hello Java");
		Thread.currentThread().setName("defult");;
		Thread.currentThread().setPriority(10);
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState().name());
		System.out.println(Thread.currentThread().isDaemon());
	}

}
