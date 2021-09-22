package cglib;

public class CglibTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao)cglibProxy.createProxy(userDao);
        proxy.addUser();
        proxy.deleteUser();
    }
}
