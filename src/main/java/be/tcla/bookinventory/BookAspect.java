package be.tcla.bookinventory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {

    @Before("execution(* be.tcla.bookinventory.service.BookServiceImpl.findAll())")
    public void loggingAdvice(JoinPoint jp){
        System.out.println("Loggin advice: Before execution of " + jp.getSignature().getName() + " method");
    }

    @Before("execution(* *.find*(..))")
    public void loggingAdvice2(JoinPoint jp){
        System.out.println("Loggin advice2: Before execution of " + jp.toLongString() + " method");
    }

    @After("within(be.tcla.bookinventory.service..*)")
    public void logginAdvice3(){
        System.out.println("Something happened in Servica package");
    }



}
