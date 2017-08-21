/*    
 * ThreadDeadLock.java Create on 2017-8-19
 * @Description:   ����
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

/*
 * �γ�����
 * �����̻߳�����жԷ���Ҫ����Դ�������ֲ�Ը������������Դ���Ӷ��໥�ȴ���
 * 
 * һ������Ϊͬ�������Ƕ�׵��µ��������⣡���� ---Ϊ�˱�����������ò�Ҫʹ��ͬ����Ƕ�ף�
 * 
 * ��ѧ�ҽ�������
 */
public class ThreadDeadLock {

	private static String res1 = "��Դ1";
	private static String res2 = "��Դ2";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread() {
			public void run() {
				while (true) {
					synchronized (res1) {
						System.out.println(getName() + " ��ȡ��res1������res2");
						synchronized (res2) {
							System.out.println(getName() + " ��ȡ��res2������res1");
						}
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					synchronized (res2) {
						System.out.println(getName() + " ��ȡ��res2������res1");
						synchronized (res1) {
							System.out.println(getName() + " ��ȡ��res1������res2");
						}
					}
				}
			};
		}.start();

	}

}
