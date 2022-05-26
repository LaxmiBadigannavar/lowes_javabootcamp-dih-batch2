package com.labs.java.concurrency;

import java.util.concurrent.Callable;

/*
 * 
 * By implenting Callable Interface
 */
public class DemoThread03 implements Callable{
	public Object call() throws Exception{
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
		return  "Thread Executi0n completed";
	}
}
