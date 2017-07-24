package com.souvc.scheduling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSampleSchedulingApplicationTests {

	@Autowired
	private  WechatContants wechatContants;

	@Test
	public void contextLoads() {
		System.out.println(wechatContants.getAppid());
		System.out.println(wechatContants.getSecret());
	}

}
