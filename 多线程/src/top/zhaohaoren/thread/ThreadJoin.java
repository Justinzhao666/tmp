/*    
 * ThreadJoin.java Create on 2017-8-19
 * @Description:   加入线程join
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 * 将当前线程暂停，等待执行线程执行结束后，当前线程继续执行！
 */
public class ThreadJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 匿名内部类，使用它所在的方法的局部变量的时候需要使用final修饰
		final Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("我是线程1");
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					if (i == 2) {
						// t1进行插队！当i=2时，只有等t1全部执行完才能继续执行t2
						try {
//							t1.join();
							t1.join(1); //t1插队10ms，10ms后两个线程回到原来竞争状态
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("我是线程2" +
							"");
				}
			}
		};
		
		t1.start();
		t2.start();

	}

}
