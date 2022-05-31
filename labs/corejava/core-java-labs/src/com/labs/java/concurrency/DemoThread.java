package com.labs.java.concurrency;

public class DemoThread extends Thread{
	public void run() {
		
		for(int i=0;i<100;i++) {
			System.out.println("Thread Name:"+Thread.currentThread().getName()+"  "+i);
		}
	}
}
