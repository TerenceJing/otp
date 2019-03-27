package controller.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect   //定义一个切面
@Component
public class HttpAspect {
    @Pointcut("execution(* controller.*Controller.*(..))")
    public void pointCut() {
    }

    @AfterReturning("pointCut()")
    public void doAround() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        System.out.println("请求经过切面了");
        System.out.println("请求方法："+request.getMethod());

        HttpServletResponse response = sra.getResponse();
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        System.out.println("响应经过切面了");
    }
}
