/*    
 * ThreadGroup.java Create on 2017-8-20
 * @Description:   线程组的概念
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

/*
 * 线程组
 * Java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理，Java允许程序直接对线程组进行控制。
 */
public class ThreadGroupDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr,"线程1");
		
		// 默认线程的组名为main
		java.lang.ThreadGroup tg1 = t1.getThreadGroup();// 获取线程的线程组
		System.out.println(tg1.getName()); 
		
		ThreadGroup tg =  new ThreadGroup("新的线程组");
		// 将t2 t3 放入线程组tg中
		Thread t2 = new Thread(tg,mr,"线程2");
		Thread t3 = new Thread(tg,mr,"线程3");
		System.out.println(t2.getThreadGroup().getName()); 
		System.out.println(t3.getThreadGroup().getName());
		tg.setDaemon(true);// 操作线程组从而操作所有组内所有线程（批量处理线程）
	}

}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}
	}
}
