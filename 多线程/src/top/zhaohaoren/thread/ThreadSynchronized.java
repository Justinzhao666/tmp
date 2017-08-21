/*    
 * ThreadSynchronized.java Create on 2017-8-19
 * @Description:   多线程同步问题
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

/*
 * synchronized
 * 1、同步代码块
 * 2、同步方法
 * 
 * 所谓同步就是 多线程并发的时候，希望某一段代码在执行的时候CPU不会切换到其他线程工作！
 */

public class ThreadSynchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Printer p = new Printer();
		
		new Thread(){
			@Override
			public void run() {
				for(int i = 1;i<100;i++){
					p.printA();
				}
			};
		}.start();
		new Thread(){
			@Override
			public void run() {
				for(int i = 1;i<100;i++){
					p.printB();
				}
			};
		}.start();
		

	}

}

class Printer{
	Object b = new Object(); //任意一个对象都可以作为锁
	
	//:1.1 同步非静态方法，锁为this对象--非静态的同步方法
	public synchronized void printA(){
		System.out.print("青");
		System.out.print("龙");
		System.out.print("白");
		System.out.print("虎");
		System.out.println("");
	}
	
	public synchronized void printB(){
		System.out.print("朱");
		System.out.print("雀");
		System.out.print("玄");
		System.out.print("武");
		System.out.println("");
	}
	//:1.2 同步静态方法，锁为字节码对象
	public static synchronized void printSA(){
		System.out.print("青");
		System.out.print("龙");
		System.out.print("白");
		System.out.print("虎");
		System.out.println("");
	}
	public static synchronized void printSB(){
		synchronized(Printer.class){
			System.out.print("朱");
			System.out.print("雀");
			System.out.print("玄");
			System.out.print("武");
			System.out.println("");
		}
	}
	
	//:2 同步代码块，锁为某个对象
	public synchronized void printAA(){
		synchronized (b) {
			System.out.print("青");
			System.out.print("龙");
			System.out.print("白");
			System.out.print("虎");
			System.out.println("");
		}

	}
	
	public synchronized void printBB(){
		synchronized (b) {
			System.out.print("朱");
			System.out.print("雀");
			System.out.print("玄");
			System.out.print("武");
			System.out.println("");
		}
	}
	
}
