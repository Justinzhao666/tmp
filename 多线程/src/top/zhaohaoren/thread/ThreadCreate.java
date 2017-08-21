/*    
 * ThreadCreate.java Create on 2017-8-19
 * @Description:   �����̵߳ķ�ʽ
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

public class ThreadCreate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		///:01  �����߳�
		Thread t1 = new MyThread();
		//t1.run() ���������߳�����һ������
		t1.start();
		//������ʽ
		new Thread(){
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("Anony Thead is running...");
				}
			};
		}.start();
		
		///:02 �����߳�
		MyRunnable myRunnable = new MyRunnable();
		Thread t2 = new Thread(myRunnable);
		t2.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("Anony Runnable is running...");
				}
			}
		}).start();
		
		//��main���߳�Ҳ�������
		for(int i=0;i<1000;i++){
			System.out.println("MainThread is running...");
		}
	}
}

//: �̳�Thread
class MyThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			System.out.println("Thead is running...");
		}
	}
}

//: ʵ��Runnable
class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			System.out.println("Runnable is running...");
		}
	}
	
}