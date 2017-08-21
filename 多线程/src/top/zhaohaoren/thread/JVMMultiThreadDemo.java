/*     
 * JVMMultiThreadDemo.java Create on 2017-8-19
 * @Description:   JVM是多线程的
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-19 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;


/*
 * JVM是多线程的 开启一个java应用其实就是开启了一个java虚拟机进程，然后我们所编写的代码都在该虚拟机中执行！
 * main函数其实就是JVM的主线程
 * */
public class JVMMultiThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 创建1000000 个匿名对象一般就会启动垃圾回收机制了
		 */
		for (int i = 0; i < 1000000; i++) {
			new Demo();
		}

		for (int i = 0; i < 10000; i++) {
			System.out.println(i + "main函数主线程");
		}
	}

}
class Demo {

	// 垃圾回收前会执行该函数
	@Override
	public void finalize() {
		System.out.println("我被垃圾回收啦！");
	}
}

/*
 *output: 
 *我被垃圾回收啦！
 *我被垃圾回收啦！
 *我被垃圾回收啦！
 *202main函数主线程
 *我被垃圾回收啦！
 *203main函数主线程
 *我被垃圾回收啦！
 *我被垃圾回收啦！
 * */
