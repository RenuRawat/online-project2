package com.collaborate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan("com.collaborate")
public class WebResolver extends WebMvcConfigurerAdapter {

	
	@Bean
	public ViewResolver getViewResolver()
	
		{
			InternalResourceViewResolver internalResolver = new InternalResourceViewResolver();
			internalResolver.setPrefix("/WEB_INF/");
			internalResolver.setSuffix(".jsp");
			System.out.println("ViewResolver is Created");
			return internalResolver;
		}
			
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}
	
	
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
      configurer.enable();
}
	
	/*
	@Bean
	public DataSource getOracleDataSource() 
	{
		DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();	
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("system");
		driverManagerDataSource.setPassword("11");		
		System.out.println("Data Souce Created");		
		return driverManagerDataSource ;
		
	}*/
	
	
}
