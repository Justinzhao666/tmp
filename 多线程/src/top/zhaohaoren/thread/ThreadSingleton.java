/*    
 * ThreadSingleton.java Create on 2017-8-20
 * @Description:   �߳��еĵ���ģʽ
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

/*
 * ����ʽ�� �ռ任ʱ��
 * ����ʽ�� ʱ�任�ռ�
 * 
 * ���߳̾�ʹ�ö���ʽ�� ����ʽ��Ҫȥ��ͬ����
 */
public class ThreadSingleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonHungry s1 = SingletonHungry.getSingleton();
		SingletonHungry s2 = SingletonHungry.getSingleton();
		
		if(s1 == s2){
			System.out.println("true");
		}
		
		SingletonFinal s3 = SingletonFinal.single;
//		s = null; ������������󲻿����޸�
		SingletonFinal s4 = SingletonFinal.single;
		if(s3 == s4){
			System.out.println("true");
		}
	}

}

//: ����ʽ ����
/*
 * �̰߳�ȫ�ģ�
 * �ڲ�����һ��������󣬻�ȡ���󷵻ظö���
 * �Ȱ��ڴ��ռס�ˣ�
 */
class SingletonHungry{
	
	private static SingletonHungry single = new SingletonHungry();
	
	private SingletonHungry(){
		
	}
	
	public static SingletonHungry getSingleton(){
		return SingletonHungry.single;
	}	
}

//: ����ʽ ����
/*
 * �̲߳���ȫ��
 * һ�ֵ����ӳټ���ģʽ���ڲ������ȴ�������ֻ�е������Ҫ��ȡ��ʱ��Ż�ȥ��������
 * ��Ԥ��ռ�ڴ棡
 */
class SingletonLazy{
	private static SingletonLazy single;
	
	private SingletonLazy(){
		
	}
	
	public static SingletonLazy getSingleton(){
		
		if (single == null){
			// ��ĳ���̵߳������ʱ�򣬱�CPU�����ߣ���һ���߳̾ͻ�Ҳ�´���һ���������л�����ʱ��ͻᴴ����������
			single = new SingletonLazy();
		}
		return SingletonLazy.single;
	}	
}


//: ��һ�ַ���
class SingletonFinal{
	
	//SingletonFinal.singleֱ�ӻ�ȡ
	public static final SingletonFinal single = new SingletonFinal();
	
	private SingletonFinal(){ 
		
	}
}