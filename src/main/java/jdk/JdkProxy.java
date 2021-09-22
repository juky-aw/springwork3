package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private UserDao userDao;
    public Object createProxy(UserDao userDao){
        this.userDao=userDao;
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        Class[] interfaces = userDao.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permissions();
        Object invoke = method.invoke(userDao, args);
        myAspect.log();
        return invoke;
    }
}
