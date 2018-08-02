package com.leonard.leonardtomcatdemo.main;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 类加载工具
 * <p>
 * 每个项目都单独的去加载它们相关的类和第三方jar包
 * </p>
 * 
 * @author Tony
 *
 */
public class ProjectLoader {
	private String project;
	private URLClassLoader loader;

	@SuppressWarnings("resource")
	public ProjectLoader(String project) throws Exception {
		this.setProject(project);
		// jvm 类加载器
		// class文件和第三方jar包的存储路径
		ArrayList<URL> urls = new ArrayList<>();
		// lib
		File libs = new File(BootStraper.work_space + "\\" + getProject() + "\\WEB-INF\\lib");
		if (libs.exists()) {
			// 遍历lib包目录，添加到URL中
			for (String lib : libs.list()) {
				urls.add(new URL("file:" + BootStraper.work_space + "\\" + getProject()
						+ "\\WEB-INF\\lib\\" + lib));
			}
		}

		// classes
		urls.add(new URL(
				"file:" + BootStraper.work_space + "\\" + getProject() + "\\WEB-INF\\classes\\"));

		loader = new URLClassLoader(urls.toArray(new URL[] {}));
	}

	/**
	 * 加载并初始化servlet
	 * 
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public ProjectLoader load() throws Exception {
		// 设置后续类加载所有用的类加载器为刚刚创建的那个，后面初始化servlet需要用到的
		Thread.currentThread().setContextClassLoader(this.loader);
		// 获取项目下配置的所有servlet
		ProjectConfigBean configBean = (ProjectConfigBean) BootStraper.projectConfigBeans
				.get(project);
		Set<Entry<String, Object>> servlets = configBean.servlets.entrySet();
		for (Entry<String, Object> entry : servlets) {
			// 类加载
			String servletName = entry.getKey().toString();
			String servletClassName = entry.getValue().toString();
			// 加载servlet
			Class<?> clazz = loader.loadClass(servletClassName);
			// 实例化
			Servlet servlet = (Servlet) clazz.newInstance();
			// 保存起来
			configBean.servletInstances.put(servletName, servlet);
			// 初始化 
			servlet.init(new ServletConfig() {

				@Override
				public String getServletName() {
					return null;
				}
				
				@Override
				public ServletContext getServletContext() {
					return null;
				}
				
				@Override
				public Enumeration<String> getInitParameterNames() {
					return null;
				}
				
				@Override
				public String getInitParameter(String name) {
					return null;
				}
			});
			
		}

		return this;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
}
