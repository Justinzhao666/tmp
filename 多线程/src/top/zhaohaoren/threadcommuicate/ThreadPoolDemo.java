/*    
 * ThreadPoolDemo.java Create on 2017-8-20
 * @Description:   �̳߳�
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.threadcommuicate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * ϵͳ�¿�һ���߳��Ǻܺ���Դ��
 * �̳߳ؾ��ǹ���һ���̣߳�����Ҫʹ�õ�ʱ��������һ���̣߳�ʹ����Ϻ󷵻ظ��̳߳أ��̳߳��е��߳�һֱ���ǻ��״̬��
 * 
 * ��ʵ�߳̾���һ������Thread������ʹ���߳�ֻ��ϣ����run������һ��Thread������������
 */
public class ThreadPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��ȡһ���̶��Ŀ��Դ��2���̵߳��̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
//		pool.submit(new MyRunnable()); ��������Ҳִֻ������
		
		pool.shutdown(); // �ر��̳߳�

	}

}
