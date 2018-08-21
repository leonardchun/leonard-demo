package com.leonard.bigdata;

import com.leonard.bigdata.config.SystemProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BigDataApplicationTests {

	@Autowired
	private SystemProperties systemProperties;
	@Test
	public void contextLoads() {
		System.out.println(systemProperties.getName());
	}

}
