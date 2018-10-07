package SpringDemo;


import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		/**
		 * 用XmlBeanFactory这个方式获得bean,现在已经不用这个方式了
		 */

		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
		MyTestBean myTestBean = (MyTestBean) xmlBeanFactory.getBean("myTestBean");
		myTestBean.setName("张三");
		System.out.println(myTestBean + "---" + myTestBean.getName());
		/*ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		ClassPathResource classPathResource = new ClassPathResource("spring-config.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) classPathResource);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		MyTestBean myTestBean = (MyTestBean)defaultListableBeanFactory.getBean("myTestBean");
		System.out.println(myTestBean + "---" + myTestBean.getName());*/

	}
}
