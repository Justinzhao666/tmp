/*    
 * ThreadYield.java Create on 2017-8-19
 * @Description:   礼让线程
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 * 当前线程主动让出cpu，但是不一定会让，随机性很大，只是一个表态并不一定执行！所以不要太依赖这个东西，结果不一定和想象中的一样！
 * 仅作了解
 */
public class ThreadYield {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread2().start();
		new MyThread2().start();
	}

}

class MyThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				// 建议当前线程 让出CPU
				System.out.println("让出cpu了");
				Thread.yield();
			}
			System.out.println(this.getName() + "..." + i);
		}
	}
}
