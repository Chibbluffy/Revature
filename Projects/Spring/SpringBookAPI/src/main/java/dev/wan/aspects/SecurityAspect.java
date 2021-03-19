package dev.wan.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Component
@Aspect
public class SecurityAspect {

    // @Around is the most powerful advice you can give
    // takes in the method being called
    // edit/view the parameters athat were sent to that method and even
    // change them before the method is called
    // you can also edit the return
    @Around("authorizeJP")
    public Object authenticate(ProceedingJoinPoint pjp) throws Throwable { // pjp is the method call being passed in
        // These 2 lines of code will give us access to the HTTP request sent to a controller
        // as well as edit any sort of response
        // these are low level objects in Spring that you as a programmer do not interact with often
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String auth = request.getHeader("Authorization");
        System.out.println(auth);
        System.out.println(pjp.getSignature().toString()); // prints the method called, return type and parameter types

        if (auth != null && auth.equals("pa$$word")){
            Object obj = pjp.proceed(); // this will execute the method you intercepted
            return obj;
        }
        else{ // in case wrong header, will not execute method
            response.sendError(401);
            return null;
        }
    }

    @Pointcut("@annotation(dev.wan.aspects.Authorized")
    private void authorizeJP(){}



}
