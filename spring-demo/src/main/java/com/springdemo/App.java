package com.springdemo;


/*import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;*/

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) throws IOException {

		// 方式一：读取bean
		/*XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		Login myTestBean = (Login) xmlBeanFactory.getBean("loginImpl");
		myTestBean.loginCheck("1111","2222");*/

		// 方式二：读取bean ApplicationContext在读取配置文件的时候，配置文件中的bean就会被自动实例化
		/*ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("D:\\workspaceSpringSource\\spring-master\\spring-framework\\spring-demo\\src\\main\\resources\\applicationContext.xml");
		Login login = (Login)classPathXmlApplicationContext.getBean(LoginImpl.class);
		login.loginCheck("root","123321");*/

		/*
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		LoginImpl loginImpl = factory.getBean("loginImpl",LoginImpl.class);
		System.out.println("loginImpl对象已经初始化完成");
		System.out.println(loginImpl.loginCheck("1111","2222"));
		*/

		// 方式三：beanFactory在启动的时候，不会创建bean的实例，而是在getBean()的时候才会创建bean实例
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions( new ClassPathResource("applicationContext.xml"));
		LoginImpl loginImpl = beanFactory.getBean("loginImpl", LoginImpl.class);
		loginImpl.loginCheck("1111","2222");

	}

}
