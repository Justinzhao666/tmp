/*    
 * ThreadNotify.java Create on 2017-8-20
 * @Description:   两个线程之间的通信
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.threadcommuicate;

/*
 * 多线程是进行任意切换的执行，但是我想让线程交替着执行该怎么办呢？
 * 通过等待/唤醒加入标志位来实现线程互相通信让谁去执行！
 * t1 执行完了设置自己为阻塞其他唤醒的condition，然后唤醒另一个线程！
 * 
 * 注意：
 * notify唤醒其他wait的线程，线程将在wait处继续往下执行！
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
				this.wait(); // this这个锁来控制它被持有的线程的执行状态
			}
			System.out.print("A");
			System.out.print("A");
			System.out.print("A");
//			确实会破坏同步代码块的单个运行。
//			其实同步代码快也是一种线程间的通信机制！都是通信，他们的控制等级是平行的
//			if(flag !=1){
//				this.wait();
//			}
			System.out.print("A");
			System.out.print("A");
			System.out.println("");
			flag =2;
			this.notify(); // notify是随机唤醒一个线程，当前线程本身就是醒的，所以只能唤醒另外一个线程printB
		}
	}
	
	public void printB() throws InterruptedException{
		synchronized (this) {
			if(flag !=2){
				this.wait(); /// 如果在这里阻塞了，当其他notify它时候，只会接着wait()继续执行！！！！
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
