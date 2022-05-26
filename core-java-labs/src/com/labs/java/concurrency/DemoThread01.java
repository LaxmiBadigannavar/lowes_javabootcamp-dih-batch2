package com.labs.java.concurrency;
/*
 * create new thread by implementing Runnable interface
 */
public class DemoThread01 implements Runnable {
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
	}

}
