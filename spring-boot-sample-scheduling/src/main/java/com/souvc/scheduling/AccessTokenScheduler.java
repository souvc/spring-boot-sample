package com.souvc.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AccessTokenScheduler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private  WechatContants wechatContants;

	/**
	 * 测试从本地变量中取值
	 */
	@Scheduled(cron="0/10 * *  * * ? ")   //测试每5秒执行一次
	public void getlocalhostAccessToken() {
		logger.info("into  getlocalhostAccessToken");
		logger.info("getAccess_token:"+AccessTokenUtil.accessToken.getAccess_token());
		logger.info("getExpires_in:"+AccessTokenUtil.accessToken.getExpires_in());
	}


	/**
	 * 定时从微信服务器上面获取token值
	 */
	//@Scheduled(fixedRate=20000) ////测试每20秒执行一次
	@Scheduled(cron="0/5 * *  * * ? ")   //测试每5秒执行一次
	//@Scheduled(cron="0/7000 * *  * * ? ")   //每7000秒执行一次
	//@Scheduled(cron = "0 0 */2 * * ?")  //俩小时执行一次
	public void getAccessToken() {
		logger.info("into  getAccessToken");
		RestTemplate restTemplate =new RestTemplate();
		String  tokenUrl=WechatApiUrlConstants.token.replace("APPID",wechatContants.getAppid()).replace("APPSECRET",wechatContants.getSecret());
		AccessTokenUtil.accessToken=restTemplate.getForObject(tokenUrl,AccessToken.class);
		logger.info("access_token:"+AccessTokenUtil.accessToken.getAccess_token());
		logger.info("expires_in:"+AccessTokenUtil.accessToken.getExpires_in());
	}  
}