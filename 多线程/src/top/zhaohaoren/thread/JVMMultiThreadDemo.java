/*     
 * JVMMultiThreadDemo.java Create on 2017-8-19
 * @Description:   JVM�Ƕ��̵߳�
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;


/*
 * JVM�Ƕ��̵߳� ����һ��javaӦ����ʵ���ǿ�����һ��java��������̣�Ȼ����������д�Ĵ��붼�ڸ��������ִ�У�
 * main������ʵ����JVM�����߳�
 * */
public class JVMMultiThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ����1000000 ����������һ��ͻ������������ջ�����
		 */
		for (int i = 0; i < 1000000; i++) {
			new Demo();
		}

		for (int i = 0; i < 10000; i++) {
			System.out.println(i + "main�������߳�");
		}
	}

}
class Demo {

	// ��������ǰ��ִ�иú���
	@Override
	public void finalize() {
		System.out.println("�ұ�������������");
	}
}

/*
 *output: 
 *�ұ�������������
 *�ұ�������������
 *�ұ�������������
 *202main�������߳�
 *�ұ�������������
 *203main�������߳�
 *�ұ�������������
 *�ұ�������������
 * */
