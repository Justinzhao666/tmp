/*    
 * ThreadNotifyAll.java Create on 2017-8-20
 * @Description:   三个或者多个线程之间的通信
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

/*
 * 我想让三个线程依次执行：
 * 
 * 相对于两个线程之间，唤醒了肯定会是另一个。但是三个的时候，如果唤醒了一个不满足执行条件的线程，那么可能导致三个线程全部等待！
 * 这时候就需要notifyAll()
 * bad example：
 * CPU先去执行了t2和t3，将t2，t3转为wait
 * 然后切去 t1执行完了，t1置flag为t2该执行的状态，想唤醒t2
 * 但是随机唤醒的却是t3，t3转入wait（如果if判断就是输出t3转t1）
 * 这时候CPU又转去t1，t1转wait
 * 这下子三个都是wait了
 * 
 */
public class ThreadNotifyAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Printer2 p = new Printer2();

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

class Printer2 {
	private int flag = 1;

	public void printA() throws InterruptedException {
		synchronized (this) {
			while (flag != 1) {
//				这里必须是while，才会循环判断
//				因为唤醒后会接着wait下面的执行，我们并不能显式的指定哪个线程被唤醒！
//				所以需要再次验证是否满足执行条件!
				this.wait();
			}
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
			System.out.println("");
			flag = 2;
			this.notifyAll();
		}
	}

	public void printB() throws InterruptedException {
		synchronized (this) {
			while (flag != 2) {
				this.wait();
			}
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.println("");
			flag = 3;
			this.notifyAll();
		}
	}

	public void printC() throws InterruptedException {
		synchronized (this) {
			while (flag != 3) {
				this.wait();
			}
			System.out.print("C");
			System.out.print("C");
			System.out.print("C");
			System.out.print("C");
			System.out.print("C");
			System.out.println("");
			flag = 1;
			this.notifyAll();
		}
	}
}