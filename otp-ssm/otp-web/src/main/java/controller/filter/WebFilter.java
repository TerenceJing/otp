package controller.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig var1) throws ServletException{}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 将ServletResponse转换为HttpServletResponse
        System.out.println("===========经过过滤器了============");
        HttpServletRequest httpReq=(HttpServletRequest) req;
        System.out.println("方法："+httpReq.getMethod());
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        // 如果不是80端口,需要将端口加上,如果是集群,则用Nginx的地址,同理不是80端口要加上端口
        String []  allowDomain= {"http://www.baidu.com","http://127.0.0.1:8080","http://127.0.0.1:8081","http://localhost:8081"};
        Set allowedOrigins= new HashSet(Arrays.asList(allowDomain));
        String originHeader=((HttpServletRequest) req).getHeader("Origin");
        if (allowedOrigins.contains(originHeader)){
            httpResponse.setHeader("Cache-Control", "no-cache");
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE，PUT");
            httpResponse.setHeader("Access-Control-Allow-Methods", "*");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
            // 如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Expose-Headers", "*");
        }
        chain.doFilter(req, res);
    }
    @Override
    public void destroy(){}
}
