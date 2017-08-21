/*    
 * ThreadNotify.java Create on 2017-8-20
 * @Description:   �����߳�֮���ͨ��
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.threadcommuicate;

/*
 * ���߳��ǽ��������л���ִ�У������������߳̽�����ִ�и���ô���أ�
 * ͨ���ȴ�/���Ѽ����־λ��ʵ���̻߳���ͨ����˭ȥִ�У�
 * t1 ִ�����������Լ�Ϊ�����������ѵ�condition��Ȼ������һ���̣߳�
 * 
 * ע�⣺
 * notify��������wait���̣߳��߳̽���wait����������ִ�У�
 */
public class ThreadNotify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Printer printer = new Printer();
		new Thread(){
			public void run() {
				while(true){
					try {
						printer.printA();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			};
		}.start();
		
		new Thread(){
			public void run() {
				while(true){
					try {
						printer.printB();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();

	}

}


class Printer{
	private int flag =1;
	
	public void printA() throws InterruptedException{
		synchronized (this) {
			if(flag !=1){
				this.wait(); // this������������������е��̵߳�ִ��״̬
			}
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
//			ȷʵ���ƻ�ͬ�������ĵ������С�
//			��ʵͬ�������Ҳ��һ���̼߳��ͨ�Ż��ƣ�����ͨ�ţ����ǵĿ��Ƶȼ���ƽ�е�
//			if(flag !=1){
//				this.wait();
//			}
			System.out.print("A");
			System.out.print("A");
			System.out.println("");
			flag =2;
			this.notify(); // notify���������һ���̣߳���ǰ�̱߳�������ѵģ�����ֻ�ܻ�������һ���߳�printB
		}
	}
	
	public void printB() throws InterruptedException{
		synchronized (this) {
			if(flag !=2){
				this.wait(); /// ��������������ˣ�������notify��ʱ��ֻ�����wait()����ִ�У�������
			}
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.print("B");
			System.out.println("");
			flag = 1;
			this.notify();
		}
	}
}
