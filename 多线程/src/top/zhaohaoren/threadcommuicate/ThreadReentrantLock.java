/*    
 * ThreadReentrantLock.java Create on 2017-8-20
 * @Description:   JDK1.5的新特性互斥锁
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ReentrantLock
 * 一个可重入的互斥锁 Lock，它具有与使用 synchronized 方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，但功能更强大。 
 * 
 * 前面的notify等不能显式的指定唤醒哪一个线程，ReentrantLock提供了一套机制可以实现唤醒指定线程！
 */
public class ThreadReentrantLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Printer3 p = new Printer3();
		new Thread("线程1") {
			public void run() {
				while (true) {
					try {
						p.printA();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
		new Thread("线程2") {
			public void run() {
				try {
					while (true) {
						p.printB();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
		new Thread("线程3") {
			public void run() {
				try {
					while (true) {
						p.printC();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();

	}

}

class Printer3 {
	// 定义锁
	private ReentrantLock r = new ReentrantLock();
	//	Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用
	//  为每个对象提供多个等待 set（wait-set）。
	//  其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用！ *
	private Condition c1 = r.newCondition(); 
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();

	private int flag = 1;

	public void printA() throws InterruptedException {
		r.lock(); //替代synchronized 加锁和解锁
		if (flag != 1) {
			c1.await(); // c1 监视器让该线程阻塞，然后等待c1.signal()发出信号来唤醒！
		}
		System.out.print("A");
		System.out.print("A");
		System.out.print("A");
		System.out.print("A");
		System.out.print("A");
		System.out.println("");
		flag = 2;
		c2.signal(); 	//指定唤醒c2线程 
		r.unlock();
	}

	public void printB() throws InterruptedException {
		r.lock();
		if (flag != 2) {
			c2.await();
		}
		System.out.print("B");
		System.out.print("B");
		System.out.print("B");
		System.out.print("B");
		System.out.print("B");
		System.out.println("");
		flag = 3;
		c3.signal();
		r.unlock();
	}

	public void printC() throws InterruptedException {
		r.lock();
		if (flag != 3) {
			c3.await();
		}
		System.out.print("C");
		System.out.print("C");
		System.out.print("C");
		System.out.print("C");
		System.out.print("C");
		System.out.println("");
		flag = 1;
		c1.signal();
		r.unlock();
	}
}