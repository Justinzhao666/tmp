/*    
 * ThreadBaseFunction.java Create on 2017-8-19
 * @Description:   �̻߳�������
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

public class ThreadBaseFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread("�߳�1") { // ���췽�������߳���
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					try {
						Thread.sleep(1000); // ����һ��ʱ��
					} catch (InterruptedException e) { //�ж��쳣
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (i > 5) {
						// setName��ʽ�����߳�����
						this.setName("�߳�1-1");
					}
					System.out.println(this.getName() + "thread1");
				}
			}
		}.start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				// this.getName() Runnableû��getName������ȡ�̵߳����֣���Ϊ������һ���̶߳��󣬻�ȡ��������
				for (int i = 1; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// ͨ��Thread.currentThread()��ȡ��ǰ������̶߳�������ã�
					System.out.println(Thread.currentThread().getName()
							+ "thread1");
				}
			}
		}).start();

	}

}
