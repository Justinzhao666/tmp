/*    
 * ThreadDeadLock.java Create on 2017-8-19
 * @Description:   死锁
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 * 形成条件
 * 两个线程互相持有对方想要的资源，但是又不愿意放弃自身的资源，从而相互等待！
 * 
 * 一般是因为同步代码块嵌套导致的死锁问题！！！ ---为了避免该问题就最好不要使用同步块嵌套！
 * 
 * 哲学家进餐问题
 */
public class ThreadDeadLock {

	private static String res1 = "资源1";
	private static String res2 = "资源2";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread() {
			public void run() {
				while (true) {
					synchronized (res1) {
						System.out.println(getName() + " 获取了res1，请求res2");
						synchronized (res2) {
							System.out.println(getName() + " 获取了res2，请求res1");
						}
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					synchronized (res2) {
						System.out.println(getName() + " 获取了res2，请求res1");
						synchronized (res1) {
							System.out.println(getName() + " 获取了res1，请求res2");
						}
					}
				}
			};
		}.start();

	}

}
