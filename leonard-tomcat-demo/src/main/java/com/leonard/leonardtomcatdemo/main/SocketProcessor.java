package com.leonard.leonardtomcatdemo.main;

import java.io.IOException;
import java.net.Socket;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 专门处理socket请求的 */
public class SocketProcessor implements Runnable {
	Socket socket;

	public SocketProcessor(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 接收请求数据
			byte[] requestBody = new byte[1024];
			socket.getInputStream().read(requestBody);
			String requestString = new String(requestBody);
			System.out.println("收到http请求，内容如下：");
			System.out.println(requestString);

			HttpServletRequest request = RequestFactory.createRequest(requestBody);
			HttpServletResponse response = ResponseFactory.createResponse(socket);
			
			// 找到url 对应的 servlet实例
			// 请求的项目
			String projectName = request.getContextPath().split("/")[1];
			ProjectConfigBean projectConfigBean = BootStraper.projectConfigBeans.get(projectName);
			if(projectConfigBean == null) {
				System.out.println("没有这个项目:" + request.getRequestURI());
				return;
			}
			String servletPath = request.getServletPath();
			String servletName = projectConfigBean.servletMapping.get(servletPath);
			
			if(servletName == null) {
				System.out.println("404....");
				response.getOutputStream().write("404...".getBytes());
				return;
			}
			
			Servlet servlet = projectConfigBean.servletInstances.get(servletName);
			// 调用servlet的service方法
			servlet.service(request, response);
			
		} catch (Exception e) {
			
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
