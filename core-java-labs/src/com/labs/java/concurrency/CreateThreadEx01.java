package com.labs.java.concurrency;

public class CreateThreadEx01 {

	public static void main(String[] args) throws InterruptedException  {
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		DemoThread t1= new DemoThread();
		t1.setName("t1");
		t1.start();
		t1.join();
		
		DemoThread t2= new DemoThread();
		t2.setName("t2");
		t2.start();
		t2.join();
		
		DemoThread t3= new DemoThread();
		t3.setName("t3");
		t3.start();
		t3.join();
	}

}
