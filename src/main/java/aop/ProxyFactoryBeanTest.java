package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("applicationContent.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPathResource.getPath());
        UserDao userDaoProxy = (UserDao) applicationContext.getBean("userDaoProxy");
        userDaoProxy.addUser();
        userDaoProxy.deleteUser();
    }
}
