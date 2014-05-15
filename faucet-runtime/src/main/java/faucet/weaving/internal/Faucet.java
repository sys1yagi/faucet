package faucet.weaving.internal;

import com.sys1yagi.android.leakchecker.LeakChecker;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


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

        Object target = joinPoint.getTarget();

        if (args == null) {
            return result;
        }
        for (Object arg : args) {
            if (arg == null) {
                continue;
            }

            //primitive type
            if ((arg instanceof String)
                    || (arg instanceof Integer)
                    || (arg instanceof Boolean)
                    || (arg instanceof Byte)
                    || (arg instanceof Character)
                    || (arg instanceof Long)
                    || (arg instanceof Double)
                    || (arg instanceof Short)
                    || (arg instanceof Float)
                    ) {
                Log.d("Faucet", "ignore type=" + arg.getClass().getName() + " toString=" + args);
                continue;
            }

            //static field
            if (target == null) {
                Log.d("Faucet",
                        "target is null=" + arg.getClass().getName() + " toString=" + args);
                continue;
            }

            try {
                Class clazz = target.getClass();
                Field field = clazz.getDeclaredField(joinPoint.getSignature().getName());
                if (field != null) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        Log.d("Faucet",
                                "ignore static=" + arg.getClass().getName() + " toString=" + args);
                        continue;
                    }
                }
            } catch (NoSuchFieldException e) {
                //ok.
                Log.d("Faucet",
                        "no such field=" + joinPoint.getSignature().getName()
                                + " target=" + target.getClass().getName()
                );
            }
            LeakChecker.addLeakChecker(arg);
        }
        return result;
    }

    @Around("onDestroy()")
    public Object dump(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        LeakChecker.dump();
        return result;
    }
}
