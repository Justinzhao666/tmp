/*    
 * ThreadDaemon.java Create on 2017-8-19
 * @Description:   �ػ��߳�
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

/*
 * �ػ��߳��������߳�ִ����������˽��ˣ���Ȼ����һ���Ļ��壡
 */
public class ThreadDaemon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<2;i++){
					System.out.println("�����߳�1");
				}
			}
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					System.out.println("�����߳�2");
				}
			}
		};
		//����t2Ϊ�ػ��߳�
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
	}

}
