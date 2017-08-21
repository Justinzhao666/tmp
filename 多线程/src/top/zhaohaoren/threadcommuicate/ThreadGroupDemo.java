/*    
 * ThreadGroup.java Create on 2017-8-20
 * @Description:   �߳���ĸ���
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

/*
 * �߳���
 * Java��ʹ��ThreadGroup����ʾ�߳��飬�����Զ�һ���߳̽��з������Java�������ֱ�Ӷ��߳�����п��ơ�
 */
public class ThreadGroupDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr,"�߳�1");
		
		// Ĭ���̵߳�����Ϊmain
		java.lang.ThreadGroup tg1 = t1.getThreadGroup();// ��ȡ�̵߳��߳���
		System.out.println(tg1.getName()); 
		
		ThreadGroup tg =  new ThreadGroup("�µ��߳���");
		// ��t2 t3 �����߳���tg��
		Thread t2 = new Thread(tg,mr,"�߳�2");
		Thread t3 = new Thread(tg,mr,"�߳�3");
		System.out.println(t2.getThreadGroup().getName()); 
		System.out.println(t3.getThreadGroup().getName());
		tg.setDaemon(true);// �����߳���Ӷ������������������̣߳����������̣߳�
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
