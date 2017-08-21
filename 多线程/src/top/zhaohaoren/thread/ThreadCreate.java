/*    
 * ThreadCreate.java Create on 2017-8-19
 * @Description:   创建线程的方式
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
		///:01  开启线程
		Thread t1 = new MyThread();
		//t1.run() 这是在主线程中跑一个方法
		t1.start();
		//匿名方式
		new Thread(){
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("Anony Thead is running...");
				}
			};
		}.start();
		
		///:02 开启线程
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
		
		//让main主线程也进行输出
		for(int i=0;i<1000;i++){
			System.out.println("MainThread is running...");
		}
	}
}

//: 继承Thread
class MyThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			System.out.println("Thead is running...");
		}
	}
}

//: 实现Runnable
class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
			System.out.println("Runnable is running...");
		}
	}
	
}