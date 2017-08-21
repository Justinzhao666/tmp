/*    
 * ThreadPriority.java Create on 2017-8-19
 * @Description:   线程优先级
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 *  线程优先级 1~10 不能超出这个范围
 *  数字越大，优先级越高
 *  
 *  这种设置优先级对于线程的执行结果，表现也不是很明显
 */
public class ThreadPriority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("我是线程t1" + getName());
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("我是线程t2" + getName());
				}
			}
		};

//		t1.setPriority(1);
//		t2.setPriority(10);
		t1.setPriority(Thread.MAX_PRIORITY); //最大10
		t2.setPriority(Thread.MIN_PRIORITY); //最小1
		t1.start();
		t2.start();
	}

}
