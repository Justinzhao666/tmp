/*    
 * RuntimeDemo.java Create on 2017-8-20
 * @Description:   Runtime��
 *
 * @author zhaohaoren     
 * @version 1.0 
 * Copyright (c) 2017-8-20 by zhaohaoren      
 */ 
package top.zhaohaoren.thread;

import java.io.IOException;

/*
 * Runtime����ִ��ϵͳ������
 * ��һ������ģʽ��
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
