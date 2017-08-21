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
 * �����д����̷߳�ʽ��
 * �̳߳��м���callable�������߳�ִ������з���ֵ��
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
		
		// pool submit һ��Callable���󷵻�һ��Future ����
		Future<Integer> f1 =  pool.submit(new MyCallable(10));
		
		// Future����ͨ��get������ȡֵ
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