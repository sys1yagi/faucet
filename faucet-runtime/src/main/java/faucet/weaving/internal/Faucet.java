package faucet.weaving.internal;

import com.sys1yagi.android.leakchecker.LeakChecker;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import android.util.Log;


@Aspect
public class Faucet {

    @Pointcut("set ( * *.* )")
    public void method() {
        Log.d("Faucet", "method!!");
    }

    @Pointcut("execution(* *.onDestroy())")
    public void onDestroy() {
    }

    @Around("method()")
    public Object addLeakCheckAndExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        Object[] args = joinPoint.getArgs();

        Log.d("Faucet", "-----------------------------");
        Log.d("Faucet", "target=" + joinPoint.getTarget());
        if (args != null) {
            for (Object arg : args) {
                if (!(arg instanceof String)) {
                    LeakChecker.addLeakChecker(arg);
                } else {
                    Log.d("Faucet", "ignore check:" + arg);
                }
            }
        }
        Log.d("Faucet", "-----------------------------");

        return result;
    }

    @Around("onDestroy()")
    public Object dump(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        LeakChecker.dump();
        return result;
    }
}
