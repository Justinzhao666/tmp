/*    
 * ThreadSynchronized.java Create on 2017-8-19
 * @Description:   ���߳�ͬ������
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

/*
 * synchronized
 * 1��ͬ�������
 * 2��ͬ������
 * 
 * ��νͬ������ ���̲߳�����ʱ��ϣ��ĳһ�δ�����ִ�е�ʱ��CPU�����л��������̹߳�����
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
	Object b = new Object(); //����һ�����󶼿�����Ϊ��
	
	//:1.1 ͬ���Ǿ�̬��������Ϊthis����--�Ǿ�̬��ͬ������
	public synchronized void printA(){
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.println("");
	}
	
	public synchronized void printB(){
		System.out.print("��");
		System.out.print("ȸ");
		System.out.print("��");
		System.out.print("��");
		System.out.println("");
	}
	//:1.2 ͬ����̬��������Ϊ�ֽ������
	public static synchronized void printSA(){
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.println("");
	}
	public static synchronized void printSB(){
		synchronized(Printer.class){
			System.out.print("��");
			System.out.print("ȸ");
			System.out.print("��");
			System.out.print("��");
			System.out.println("");
		}
	}
	
	//:2 ͬ������飬��Ϊĳ������
	public synchronized void printAA(){
		synchronized (b) {
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.println("");
		}

	}
	
	public synchronized void printBB(){
		synchronized (b) {
			System.out.print("��");
			System.out.print("ȸ");
			System.out.print("��");
			System.out.print("��");
			System.out.println("");
		}
	}
	
}
