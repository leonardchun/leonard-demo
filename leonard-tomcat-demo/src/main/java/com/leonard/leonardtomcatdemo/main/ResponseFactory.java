package com.leonard.leonardtomcatdemo.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class ResponseFactory {
	/**
	 * 封装socket对象，并从中信息，构建出response对象
	 * 
	 * @param socket
	 * @return
	 */
	public static HttpServletResponse createResponse(Socket socket) {
		// 匿名实现
		return new HttpServletResponse() {

			@Override
			public void setLocale(Locale loc) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setContentType(String type) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setContentLengthLong(long len) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setContentLength(int len) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setCharacterEncoding(String charset) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setBufferSize(int size) {
				// TODO Auto-generated method stub

			}

			@Override
			public void resetBuffer() {
				// TODO Auto-generated method stub

			}

			@Override
			public void reset() {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isCommitted() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public PrintWriter getWriter() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ServletOutputStream getOutputStream() throws IOException {
				return new ServletOutputStream() {

					@Override
					public void write(int b) throws IOException {
						// 实际用的就是那个socket连接对象
						socket.getOutputStream().write(b);
					}

					@Override
					public void write(byte[] b) throws IOException {
						// 仅仅返回 200
						StringBuffer buffer = new StringBuffer();
						buffer.append("HTTP/1.1 200 OK").append("\r\n");
						buffer.append("Content-Length: ").append(b.length).append(" \r\n");
						socket.getOutputStream().write(buffer.toString().getBytes());
						socket.getOutputStream().write("\r\n".getBytes());
						socket.getOutputStream().write(b);
					}

					@Override
					public void write(byte[] b, int off, int len) throws IOException {
						StringBuffer buffer = new StringBuffer();
						buffer.append("HTTP/1.1 200 OK").append("\r\n");
						buffer.append("Content-Length: ").append(b.length).append(" \r\n");
						socket.getOutputStream().write(buffer.toString().getBytes());
						socket.getOutputStream().write("\r\n".getBytes());
						socket.getOutputStream().write(b);
					}

					@Override
					public void flush() throws IOException {
						socket.getOutputStream().flush();
					}

					@Override
					public boolean isReady() {
						return false;
					}

					@Override
					public void setWriteListener(WriteListener writeListener) {
					}
				};
			}

			@Override
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getBufferSize() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void flushBuffer() throws IOException {
				// TODO Auto-generated method stub

			}

			@Override
			public void setStatus(int sc, String sm) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setStatus(int sc) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setIntHeader(String name, int value) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setHeader(String name, String value) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setDateHeader(String name, long date) {
				// TODO Auto-generated method stub

			}

			@Override
			public void sendRedirect(String location) throws IOException {
				// TODO Auto-generated method stub

			}

			@Override
			public void sendError(int sc, String msg) throws IOException {
				// TODO Auto-generated method stub

			}

			@Override
			public void sendError(int sc) throws IOException {
				// TODO Auto-generated method stub

			}

			@Override
			public int getStatus() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Collection<String> getHeaders(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<String> getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getHeader(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String encodeUrl(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String encodeURL(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String encodeRedirectUrl(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String encodeRedirectURL(String url) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean containsHeader(String name) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void addIntHeader(String name, int value) {
				// TODO Auto-generated method stub

			}

			@Override
			public void addHeader(String name, String value) {
				// TODO Auto-generated method stub

			}

			@Override
			public void addDateHeader(String name, long date) {
				// TODO Auto-generated method stub

			}

			@Override
			public void addCookie(Cookie cookie) {
				// TODO Auto-generated method stub

			}
		};
	}
}
