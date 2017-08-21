/*    
 * ThreadNotifyAll.java Create on 2017-8-20
 * @Description:   �������߶���߳�֮���ͨ��
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.threadcommuicate;

/*
 * �����������߳�����ִ�У�
 * 
 * ����������߳�֮�䣬�����˿϶�������һ��������������ʱ�����������һ��������ִ���������̣߳���ô���ܵ��������߳�ȫ���ȴ���
 * ��ʱ�����ҪnotifyAll()
 * bad example��
 * CPU��ȥִ����t2��t3����t2��t3תΪwait
 * Ȼ����ȥ t1ִ�����ˣ�t1��flagΪt2��ִ�е�״̬���뻽��t2
 * ����������ѵ�ȴ��t3��t3ת��wait�����if�жϾ������t3תt1��
 * ��ʱ��CPU��תȥt1��t1תwait
 * ��������������wait��
 * 
 */
public class ThreadNotifyAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Printer2 p = new Printer2();

		new Thread("�߳�1") {
			public void run() {
				while (true) {
					try {
						p.printA();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
		new Thread("�߳�2") {
			public void run() {
				try {
					while (true) {
						p.printB();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
		new Thread("�߳�3") {
			public void run() {
				try {
					while (true) {
						p.printC();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();

	}
}

class Printer2 {
	private int flag = 1;

	public void printA() throws InterruptedException {
		synchronized (this) {
			while (flag != 1) {
//				���������while���Ż�ѭ���ж�
//				��Ϊ���Ѻ�����wait�����ִ�У����ǲ�������ʽ��ָ���ĸ��̱߳����ѣ�
//				������Ҫ�ٴ���֤�Ƿ�����ִ������!
				this.wait();
			}
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
			System.out.println("");
			flag = 2;
			this.notifyAll();
		}
	}

	public void printB() throws InterruptedException {
		synchronized (this) {
			while (flag != 2) {
				this.wait();
			}
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.println("");
			flag = 3;
			this.notifyAll();
		}
	}

	public void printC() throws InterruptedException {
		synchronized (this) {
			while (flag != 3) {
				this.wait();
			}
			System.out.print("C");
			System.out.print("C");
			System.out.print("C");
			System.out.print("C");
			System.out.print("C");
			System.out.println("");
			flag = 1;
			this.notifyAll();
		}
	}
}