/*    
 * ThreadSafe_SellTickets.java Create on 2017-8-19
 * @Description:   TODO
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

public class ThreadSafe_SellTickets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// : Thread 方式
		SellTickets t1 = new SellTickets();
		SellTickets t2 = new SellTickets();
		SellTickets t3 = new SellTickets();
		SellTickets t4 = new SellTickets();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		重复开启同一个线程对象是非法的
//		t1.start();
//		t1.start();
//		t1.start();

		// : Runnable 方式
		SellTickets2 st = new SellTickets2();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();

	}

}

class SellTickets extends Thread {
	private static int tickets = 100;

	@Override
	public void run() {
		while (true) {
			// 对于继承Thread类的同步锁，必须保证唯一，一个线程其实就是一个对象，不可以使用其非静态成员对象来当锁！ 
			synchronized (SellTickets.class) { //也可以使用静态成员对象作为锁
				if (tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(1); // 让线程睡眠下，增强效果
					// ： t1 发现ticket=1 睡眠， t2 发现ticket=1 睡眠， t3 发现ticket=1 睡眠，
					// t3 发现ticket=1 睡眠
					// t1 醒了 -- ， t2 醒了此时tickets=0 但是还是--，依次类推！
					// 所以就怕在本线程通过验证后CPU切换到别的线程去做了--。
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() + " has sell tickets: "
						+ tickets--);
			}
		}
	}
}

class SellTickets2 implements Runnable {
	private int tickets = 100; //不需要静态， 就一个Runnable对象！ 所有的Thread对象共同引用这个Runnable对象

	@Override
	public void run() {
		while (true) {
			synchronized (SellTickets.class) { //可以使用this
				if (tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(1); 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println( Thread.currentThread().getName() + " has sell tickets: "
						+ tickets--);
			}
		}
	}
}