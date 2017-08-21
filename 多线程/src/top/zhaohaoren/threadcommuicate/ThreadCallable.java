/*    
 * ThreadCallable.java Create on 2017-8-20
 * @Description:   TODO
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



/*
 * 第三中创建线程方式：
 * 线程池中加入callable方法，线程执行完可有返回值！
 */
public class ThreadCallable {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService  pool = Executors.newFixedThreadPool(2);
		
		// pool submit 一个Callable对象返回一个Future 对象
		Future<Integer> f1 =  pool.submit(new MyCallable(10));
		
		// Future对象通过get方法获取值
		System.out.println(f1.get());

	}

}

class MyCallable implements Callable<Integer> {
	private int num;

	public MyCallable(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return num + 10;
	}
}