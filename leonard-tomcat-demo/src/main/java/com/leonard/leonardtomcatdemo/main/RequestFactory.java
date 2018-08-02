package com.leonard.leonardtomcatdemo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

/**
 * request 工厂
 * 
 * @author Tony
 *
 */
public class RequestFactory {
	/**
	 * 构建出request对象
	 * 
	 * @param socket
	 * @return
	 */
	public static HttpServletRequest createRequest(byte[] requestBody) {
		//
		return new HttpServletRequest() {

			@Override
			public AsyncContext startAsync(ServletRequest servletRequest,
					ServletResponse servletResponse) throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public AsyncContext startAsync() throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
				// TODO Auto-generated method stub

			}

			@Override
			public void setAttribute(String name, Object o) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removeAttribute(String name) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isSecure() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isAsyncSupported() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isAsyncStarted() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getServerPort() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getServerName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getScheme() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public RequestDispatcher getRequestDispatcher(String path) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getRemotePort() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getRemoteHost() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRemoteAddr() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRealPath(String path) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public BufferedReader getReader() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getProtocol() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String[] getParameterValues(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Map<String, String[]> getParameterMap() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getParameter(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<Locale> getLocales() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getLocalPort() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getLocalName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLocalAddr() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ServletInputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public DispatcherType getDispatcherType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getContentLengthLong() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getContentLength() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getAttribute(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public AsyncContext getAsyncContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void logout() throws ServletException {
				// TODO Auto-generated method stub

			}

			@Override
			public void login(String username, String password) throws ServletException {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isUserInRole(String role) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdValid() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromUrl() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromURL() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isRequestedSessionIdFromCookie() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Principal getUserPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public HttpSession getSession(boolean create) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public HttpSession getSession() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getServletPath() {
				// TODO 获取请求路径
				// 简单点就是文本解析，每一行都是一部分数据
				// http请求路径和请求方法method就是在第一行，所以我们做个简单的处理就能拿到路径
				String requestString = new String(requestBody);
				String uri = requestString.split("\r\n")[0].split(" ")[1];

				String project = uri.split("/")[1];

				String servletPath = uri.replace("/" + project, "");
				return servletPath;
			}

			@Override
			public String getRequestedSessionId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public StringBuffer getRequestURL() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRequestURI() {
				// TODO 获取请求路径
				// 简单点就是文本解析，每一行都是一部分数据
				// 请求路径和请求方法method就是在第一行，所以我们做个简单的处理就能拿到路径
				String requestString = new String(requestBody);
				String uri = requestString.split("\r\n")[0].split(" ")[1];
				return uri;
			}

			@Override
			public String getRemoteUser() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getQueryString() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPathTranslated() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPathInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Collection<Part> getParts() throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Part getPart(String name) throws IOException, ServletException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getMethod() {
				// TODO 获取请求方法
				// 简单点就是文本解析，每一行都是一部分数据
				// 请求路径和请求方法method就是在第一行，所以我们做个简单的处理就能拿到路径
				String requestString = new String(requestBody);
				String method = requestString.split("\r\n")[0].split(" ")[0];
				return method;
			}

			@Override
			public int getIntHeader(String name) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Enumeration<String> getHeaders(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getHeader(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getDateHeader(String name) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Cookie[] getCookies() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getContextPath() {
				// TODO 获取请求项目上下文信息
				// 根据路径来分析，第一个斜杠处就是对应我们的项目

				String requestString = new String(requestBody);
				String uri = requestString.split("\r\n")[0].split(" ")[1];

				String project = uri.split("/")[1];
				return "/" + project;
			}

			@Override
			public String getAuthType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String changeSessionId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean authenticate(HttpServletResponse response)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
