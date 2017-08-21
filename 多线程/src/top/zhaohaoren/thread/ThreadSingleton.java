/*    
 * ThreadSingleton.java Create on 2017-8-20
 * @Description:   线程中的单例模式
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

/*
 * 饿汉式： 空间换时间
 * 懒汉式： 时间换空间
 * 
 * 多线程就使用饿汉式！ 懒汉式就要去做同步！
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
//		s = null; 让这个单例对象不可以修改
		SingletonFinal s4 = SingletonFinal.single;
		if(s3 == s4){
			System.out.println("true");
		}
	}

}

//: 饿汉式 单例
/*
 * 线程安全的：
 * 内部持有一个自身对象，获取对象返回该对象！
 * 先把内存给占住了！
 */
class SingletonHungry{
	
	private static SingletonHungry single = new SingletonHungry();
	
	private SingletonHungry(){
		
	}
	
	public static SingletonHungry getSingleton(){
		return SingletonHungry.single;
	}	
}

//: 懒汉式 单例
/*
 * 线程不安全：
 * 一种单例延迟加载模式，内部不会先创建对象，只有当你真的要获取的时候才会去创建对象！
 * 不预先占内存！
 */
class SingletonLazy{
	private static SingletonLazy single;
	
	private SingletonLazy(){
		
	}
	
	public static SingletonLazy getSingleton(){
		
		if (single == null){
			// 当某个线程到这里的时候，被CPU给切走，另一个线程就会也新创建一个对象，再切回来的时候就会创建两个对象！
			single = new SingletonLazy();
		}
		return SingletonLazy.single;
	}	
}


//: 另一种方案
class SingletonFinal{
	
	//SingletonFinal.single直接获取
	public static final SingletonFinal single = new SingletonFinal();
	
	private SingletonFinal(){ 
		
	}
}