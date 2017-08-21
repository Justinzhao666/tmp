/*    
 * ThreadPoolDemo.java Create on 2017-8-20
 * @Description:   线程池
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.threadcommuicate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * 系统新开一个线程是很耗资源的
 * 线程池就是管理一批线程，你需要使用的时候给你分配一个线程，使用完毕后返回给线程池，线程池中的线程一直都是活的状态。
 * 
 * 其实线程就是一个对象Thread，我们使用线程只是希望将run任务用一个Thread对象驱动起来
 */
public class ThreadPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 获取一个固定的可以存放2个线程的线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
//		pool.submit(new MyRunnable()); 放了三个也只执行两个
		
		pool.shutdown(); // 关闭线程池

	}

}
