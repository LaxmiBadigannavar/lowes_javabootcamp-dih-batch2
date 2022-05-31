package com.labs.java.concurrency;

public class ThreadEx02 implements Runnable {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());
		DemoThread01 r1 = new DemoThread01();
		Thread t1 = new Thread(r1);
		t1.start();

		Thread t2 = new Thread(new DemoThread01());
		t2.setName("t2");
		t2.start();

		Thread t3 = new Thread(new ThreadEx02());
		t3.setName("t3");
		t3.start();

		Thread t4 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "  " + i);
				}
			}
		});
		t4.setName("t4");
		t4.start();
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}

}
