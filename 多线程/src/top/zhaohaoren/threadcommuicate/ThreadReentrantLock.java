/*    
 * ThreadReentrantLock.java Create on 2017-8-20
 * @Description:   JDK1.5�������Ի�����
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
 * һ��������Ļ����� Lock����������ʹ�� synchronized ��������������ʵ���ʽ����������ͬ��һЩ������Ϊ�����壬�����ܸ�ǿ�� 
 * 
 * ǰ���notify�Ȳ�����ʽ��ָ��������һ���̣߳�ReentrantLock�ṩ��һ�׻��ƿ���ʵ�ֻ���ָ���̣߳�
 */
public class ThreadReentrantLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Printer3 p = new Printer3();
		new Thread("�߳�1") {
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
		new Thread("�߳�2") {
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
		new Thread("�߳�3") {
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
	// ������
	private ReentrantLock r = new ReentrantLock();
	//	Condition �� Object ������������wait��notify �� notifyAll���ֽ�ɽ�Ȼ��ͬ�Ķ����Ա�ͨ������Щ���������� Lock ʵ�����ʹ��
	//  Ϊÿ�������ṩ����ȴ� set��wait-set����
	//  ���У�Lock ����� synchronized ����������ʹ�ã�Condition ����� Object ������������ʹ�ã� *
	private Condition c1 = r.newCondition(); 
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();

	private int flag = 1;

	public void printA() throws InterruptedException {
		r.lock(); //���synchronized �����ͽ���
		if (flag != 1) {
			c1.await(); // c1 �������ø��߳�������Ȼ��ȴ�c1.signal()�����ź������ѣ�
		}
		System.out.print("A");
		System.out.print("A");
		System.out.print("A");
		System.out.print("A");
		System.out.print("A");
		System.out.println("");
		flag = 2;
		c2.signal(); 	//ָ������c2�߳� 
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