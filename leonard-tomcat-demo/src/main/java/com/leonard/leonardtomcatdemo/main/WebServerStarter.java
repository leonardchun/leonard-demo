package com.leonard.leonardtomcatdemo.main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 启动socket-server，监听9999 */
public class WebServerStarter {

	// 处理请求的线程池
	public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(25, 50, 60,
			TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

	public static void start() throws Exception {
		ServerSocket serverSocket = null;
		try {
			// bind 监听端口
			serverSocket = new ServerSocket(9999);
			System.out.println("启动服务：9999");

			while (true) {
				Socket socket = serverSocket.accept();
				// 多线程，线程池
				threadPoolExecutor.execute(new SocketProcessor(socket));
			}

		} catch (Exception exception) {

		}
	}
}
