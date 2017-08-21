/*    
 * ThreadJoin.java Create on 2017-8-19
 * @Description:   �����߳�join
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 * ����ǰ�߳���ͣ���ȴ�ִ���߳�ִ�н����󣬵�ǰ�̼߳���ִ�У�
 */
public class ThreadJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����ڲ��࣬ʹ�������ڵķ����ľֲ�������ʱ����Ҫʹ��final����
		final Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("�����߳�1");
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					if (i == 2) {
						// t1���в�ӣ���i=2ʱ��ֻ�е�t1ȫ��ִ������ܼ���ִ��t2
						try {
//							t1.join();
							t1.join(1); //t1���10ms��10ms�������̻߳ص�ԭ������״̬
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("�����߳�2" +
							"");
				}
			}
		};
		
		t1.start();
		t2.start();

	}

}
