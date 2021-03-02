package springcore.Assignment2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy
public class AOP {

    @AfterReturning(pointcut = "execution(String getLaptopName())", returning = "laptopName")
    public void afterReturningAdvice(String laptopName){
    }
    

    @AfterThrowing(pointcut = "execution (public void setLaptopId(int))", throwing= "error")
    public void afterThrowingAdvice() {
        System.out.println("Exception is thrown. Course obtained before throwing exception");
    }


    @After("usingCustomPointCut()")
    public static void afterAdvice() {
        System.out.println("Using After execute pointcut annotation");
    }

    @Pointcut("execution (public void setLaptopName(String))")
    public void usingCustomPointCut() {
    	System.out.println("This is a custom pointcut");

    }

    @Around("execution (String getBrand())")
    public Object aroundAdvice(ProceedingJoinPoint pt) {
    	
        Object brandName;
        try{
        	
        	brandName = pt.proceed();
            System.out.println("The brand provided by the getBrand function which provides the random brand from the brand array: " + brandName);
            
        }
        catch (Throwable e) {
        	
            e.printStackTrace();
            
        }
        
        brandName = "Dell";
        System.out.println("Around Advice has changed/overriden the  brand name. The new Brand Name is: " + brandName);
        
        return brandName;
        
    }
    
    @Pointcut("within(springcore.Assignment2.Laptop)")
    public void withinpointcut() {
        System.out.println("Within pointcut will be applied to all methods and constructors of the Class Laptop");
    }

}