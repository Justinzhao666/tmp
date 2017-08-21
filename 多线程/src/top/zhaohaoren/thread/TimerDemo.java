/*    
 * TimerDemo.java Create on 2017-8-20
 * @Description:   Java的定时器
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */
package top.zhaohaoren.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Timer类
 * schedule(TimerTask对象，Date时间，间隔时间)
 * 在制定的时间去做TimerTask制定的任务！TimerTask是一个对象，实现Runnable接口，只要实现其run方法就是设置其任务了。
 * Date触发时间
 * 间隔时间： 过多少秒再执行一次该事件
 */
public class TimerDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t = new Timer();

		t.schedule(new MyTimerTask(), new Date(114, 9, 15, 10, 54, 20), 3000);

		while (true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class MyTimerTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("起床背英语单词");
	}

}