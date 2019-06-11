//package bbs.xqdxc.filter;
//
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.Date;
//
////@Component (可以通过site.xqdxc.config.WebConfig 进行配置)
//public class TimeFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("time filter start");
//        long start = new Date().getTime();
//        chain.doFilter(request, response);
//        System.out.println("Time cost " + (new Date().getTime() - start));
//        System.out.println("time filter end");
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("time filter init");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("time filter destroy");
//    }
//}
