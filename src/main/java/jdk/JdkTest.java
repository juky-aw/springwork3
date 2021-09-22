package jdk;

public class JdkTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao) jdkProxy.createProxy(userDao);
        proxy.addUser();
        proxy.deleteUser();
    }
}
