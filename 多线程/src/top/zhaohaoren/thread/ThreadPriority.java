/*    
 * ThreadPriority.java Create on 2017-8-19
 * @Description:   �߳����ȼ�
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 *  �߳����ȼ� 1~10 ���ܳ��������Χ
 *  ����Խ�����ȼ�Խ��
 *  
 *  �����������ȼ������̵߳�ִ�н��������Ҳ���Ǻ�����
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
					System.out.println("�����߳�t1" + getName());
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("�����߳�t2" + getName());
				}
			}
		};

//		t1.setPriority(1);
//		t2.setPriority(10);
		t1.setPriority(Thread.MAX_PRIORITY); //���10
		t2.setPriority(Thread.MIN_PRIORITY); //��С1
		t1.start();
		t2.start();
	}

}
