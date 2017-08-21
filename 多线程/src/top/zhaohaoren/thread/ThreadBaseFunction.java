/*    
 * ThreadBaseFunction.java Create on 2017-8-19
 * @Description:   线程基本函数
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

public class ThreadBaseFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread("线程1") { // 构造方法设置线程名
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					try {
						Thread.sleep(1000); // 休眠一段时间
					} catch (InterruptedException e) { //中断异常
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (i > 5) {
						// setName方式设置线程名字
						this.setName("线程1-1");
					}
					System.out.println(this.getName() + "thread1");
				}
			}
		}.start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				// this.getName() Runnable没有getName方法获取线程的名字，因为他不是一个线程对象，获取方法见下
				for (int i = 1; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 通过Thread.currentThread()获取当前代码的线程对象的引用！
					System.out.println(Thread.currentThread().getName()
							+ "thread1");
				}
			}
		}).start();

	}

}
