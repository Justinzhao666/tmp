/*    
 * ThreadYield.java Create on 2017-8-19
 * @Description:   �����߳�
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 * ��ǰ�߳������ó�cpu�����ǲ�һ�����ã�����Ժܴ�ֻ��һ����̬����һ��ִ�У����Բ�Ҫ̫������������������һ���������е�һ����
 * �����˽�
 */
public class ThreadYield {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyThread2().start();
		new MyThread2().start();
	}

}

class MyThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				// ���鵱ǰ�߳� �ó�CPU
				System.out.println("�ó�cpu��");
				Thread.yield();
			}
			System.out.println(this.getName() + "..." + i);
		}
	}
}
