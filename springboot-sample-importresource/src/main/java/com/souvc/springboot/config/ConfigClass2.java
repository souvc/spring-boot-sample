package com.souvc.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}
 * file路径： locations = {"file:d:/test/application-bean1.xml"};
 */
@Configuration
@ImportResource(locations={"file:d://application-bean1.xml"})
public class ConfigClass2 {

}
