/*    
 * ThreadSafe_SellTickets.java Create on 2017-8-19
 * @Description:   TODO
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */
package top.zhaohaoren.thread;

public class ThreadSafe_SellTickets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// : Thread ��ʽ
		SellTickets t1 = new SellTickets();
		SellTickets t2 = new SellTickets();
		SellTickets t3 = new SellTickets();
		SellTickets t4 = new SellTickets();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		�ظ�����ͬһ���̶߳����ǷǷ���
//		t1.start();
//		t1.start();
//		t1.start();

		// : Runnable ��ʽ
		SellTickets2 st = new SellTickets2();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();

	}

}

class SellTickets extends Thread {
	private static int tickets = 100;

	@Override
	public void run() {
		while (true) {
			// ���ڼ̳�Thread���ͬ���������뱣֤Ψһ��һ���߳���ʵ����һ�����󣬲�����ʹ����Ǿ�̬��Ա������������ 
			synchronized (SellTickets.class) { //Ҳ����ʹ�þ�̬��Ա������Ϊ��
				if (tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(1); // ���߳�˯���£���ǿЧ��
					// �� t1 ����ticket=1 ˯�ߣ� t2 ����ticket=1 ˯�ߣ� t3 ����ticket=1 ˯�ߣ�
					// t3 ����ticket=1 ˯��
					// t1 ���� -- �� t2 ���˴�ʱtickets=0 ���ǻ���--���������ƣ�
					// ���Ծ����ڱ��߳�ͨ����֤��CPU�л�������߳�ȥ����--��
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() + " has sell tickets: "
						+ tickets--);
			}
		}
	}
}

class SellTickets2 implements Runnable {
	private int tickets = 100; //����Ҫ��̬�� ��һ��Runnable���� ���е�Thread����ͬ�������Runnable����

	@Override
	public void run() {
		while (true) {
			synchronized (SellTickets.class) { //����ʹ��this
				if (tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(1); 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println( Thread.currentThread().getName() + " has sell tickets: "
						+ tickets--);
			}
		}
	}
}