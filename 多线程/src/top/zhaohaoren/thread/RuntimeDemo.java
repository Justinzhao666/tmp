/*    
 * RuntimeDemo.java Create on 2017-8-20
 * @Description:   Runtime类
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

import java.io.IOException;

/*
 * Runtime用于执行系统的命令
 * 是一个单例模式！
 */
public class RuntimeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Runtime run = Runtime.getRuntime();
		run.exec("shutdown -a");

	}

}
