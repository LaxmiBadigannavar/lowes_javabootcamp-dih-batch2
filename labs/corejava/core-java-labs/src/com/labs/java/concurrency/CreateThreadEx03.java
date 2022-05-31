package com.labs.java.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateThreadEx03 implements Callable<String>{

	public static void main(String[] args) throws InterruptedException,ExecutionException	{
		//#approach 1
		DemoThread03 c1= new DemoThread03();
		//creats five threads
		//ExecutorService exs=Executors.newFixedThreadPool(5);
		ExecutorService exs=Executors.newCachedThreadPool();

		Future<String> f1=exs.submit(c1);
		System.out.println(f1.get());
		
		
		Future<String> f2=exs.submit(new DemoThread03());
		System.out.println(f2.get());
		
		Future<String> f3=exs.submit(new CreateThreadEx03());
		System.out.println(f3.get());
		
		Future<String> f4=exs.submit(new Callable<String>() {
				public String call() throws Exception{
				for(int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getName()+"  "+i);
				}
				return  "Thread Executi0n completed";
				}
		});
		System.out.println(f4.get());
		
	}
	public String call() throws Exception{
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"  "+i);
		}
		return  "Thread Executi0n completed";
	}

}
