package aopanotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect  {
    @Pointcut("execution(* aopanotation.*.*(..))")
    private void myPointCut() {

    }
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.print( "前置通知:模拟执行权限检查. .");
        System.out.print(" 目标类是 "+joinPoint.getTarget()) ;
        System.out.println(",被植入的增强处理的目标方法为："+joinPoint.getSignature().getName());
    }
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print( "后置通知:模拟日志记录. .");
        System.out.println(",被植入的增强处理的目标方法为："+joinPoint.getSignature().getName());
    }
    @Around("myPointCut()")
    public Object myAfterReturning(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.print( "环绕开始：执行目标方法之前，模拟开始事务");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标方法后，模拟结束事务");
        return proceed;
    }
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知："+"出错了"+e.getMessage());
    }
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("最终通知，模拟方法结束后的释放资源...");
    }
}
