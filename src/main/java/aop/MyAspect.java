package aop;




import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        check_Permissions();
        Object proceed = methodInvocation.proceed();
        log();
        return proceed;
    }
    public void check_Permissions(){
        System.out.println("模拟检查权限");
    }
    public void log(){
        System.out.println("模拟记录日志");
    }
}
