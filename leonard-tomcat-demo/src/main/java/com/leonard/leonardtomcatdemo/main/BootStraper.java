package com.leonard.leonardtomcatdemo.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * servlet容器启动类
 * 
 * @author Tony
 *
 */
public class BootStraper {

	/** 工作空间 - 也就是war包的发布目录 */
	public static final String work_space =  "D:\\test\\webapp";

	/** 不同项目对应的配置信息 */
	public static final Map<Object, ProjectConfigBean> projectConfigBeans = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		// 1.1 发现项目：解压war 包
		Set<String> projects = ProjectChecker.check(work_space);
		
		// 2. web.xml 发现servlet以及相关配置
		for (String project : projects) {
			ProjectConfigBean projectConfigBean = new ProjectConfigBean(project).loadXml();
			projectConfigBeans.put(project, projectConfigBean);
		}
		
		// 3. 加载servlet，初始化servlet
		for (String project : projects) {
			new ProjectLoader(project).load();
		}
		
		// 4. 启动 BIO 
		WebServerStarter.start();
		
	}

}
