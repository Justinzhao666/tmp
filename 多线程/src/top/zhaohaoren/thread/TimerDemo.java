/*    
 * TimerDemo.java Create on 2017-8-20
 * @Description:   Java�Ķ�ʱ��
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
 * Timer��
 * schedule(TimerTask����Dateʱ�䣬���ʱ��)
 * ���ƶ���ʱ��ȥ��TimerTask�ƶ�������TimerTask��һ������ʵ��Runnable�ӿڣ�ֻҪʵ����run�������������������ˡ�
 * Date����ʱ��
 * ���ʱ�䣺 ����������ִ��һ�θ��¼�
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
		System.out.println("�𴲱�Ӣ�ﵥ��");
	}

}