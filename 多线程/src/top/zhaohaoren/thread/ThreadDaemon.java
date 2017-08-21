/*    
 * ThreadDaemon.java Create on 2017-8-19
 * @Description:   守护线程
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

/*
 * 守护线程在其他线程执行完就自我了结了，当然会有一定的缓冲！
 */
public class ThreadDaemon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<2;i++){
					System.out.println("我是线程1");
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					System.out.println("我是线程2");
				}
			}
		};
		//设置t2为守护线程
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
	}

}
