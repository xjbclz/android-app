
package com.ruwant.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class AOPAspect {

    private String TAG = "AOPAspect";

//    private static final String POINT_METHOD = "execution(* com.example.aop.*.onCreate(..))";

    private static final String POINT_METHOD = "execution(* com.example.aop.*.*(..))";

    //private static final String POINT_METHOD = "execution(* on*(..))";

//    private static final String POINT_BEFORE_METHOD = "execution(* com.example.aop.MainActivity.initVariables(..))";
//
//    private static final String POINT_AFTER_METHOD = "execution(* com.example.aop.MainActivity.initViews(..))";

    @Pointcut(POINT_METHOD)
    public void methodAnnotated(){}

//    @Pointcut(POINT_BEFORE_METHOD)
//    public void methodCallAnnotated(){}
//
//    @Pointcut(POINT_AFTER_METHOD)
//    public void methodAnootatedWith(){}

    @Around("methodAnnotated()")
    public Object aroundWeaverPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        String className;
        String methodName;

        //获取目标方法所属的类名
        className = joinPoint.getThis().getClass().getName();

        //获取目标方法名称
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        methodName = methodSignature.getName();

        //初始化计时器
        final AOPTimer aopTimer = new AOPTimer();
        //开始监听
        aopTimer.start();
        //调用目标方法
        Object result = joinPoint.proceed();
        //监听结束
        aopTimer.stop();

        String msg =  buildLogMessage(className, methodName, aopTimer.getTotalTime());
        Log.v(TAG,msg);

//      return result;

        //替换原方法的返回值
        if (methodName.equalsIgnoreCase("getName")) {
            return "aop";
        }
        else {
            return result;
        }
    }

//    @Before("methodCallAnnotated()")
//    public void beforeCall(JoinPoint joinPoint){
//        Log.v(TAG, "beforeCall" + joinPoint.toShortString());
//    }
//
//    @After("methodAnootatedWith()")
//    public void afterCall(JoinPoint joinPoint) throws Throwable{
//        Log.v(TAG, "afterCall" + joinPoint.toShortString());
//    }

    private String buildLogMessage(String className, String methodName, double methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append(className + "\n");
        message.append(methodName);
        message.append("-->");
        message.append("[");
        message.append(methodDuration);
        message.append("ms]\n");

        return message.toString();
    }
}
