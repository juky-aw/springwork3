package aopanotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestAnnotationAspectj {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("applicationContent2.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(classPathResource.getPath());
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
    }
}
