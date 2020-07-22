package com.fse.pmo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
@Configuration
@PropertySource({"classpath:${spring.profiles.active}/application.properties"})
public class PmoConfig extends WebMvcConfigurationSupport{

}