package bbs.xqdxc.config;


//import bbs.xqdxc.filter.TimeFilter;
//import bbs.xqdxc.interceptor.TimeInterceptor;


//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    TimeInterceptor timeInterceptor;
//
//
//    // 相当于配置 web.xml里的filter标签
//    @Bean
//    public FilterRegistrationBean timeFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        TimeFilter filter = new TimeFilter();
//        registrationBean.setFilter(filter);
//
//        List<String> urls = new ArrayList<>();
//        urls.add("/*");
//        registrationBean.setUrlPatterns(urls);
//        return registrationBean;
//    }
//
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("signIn.html")
//                .addResourceLocations("classpath:/resources/");
//
//        registry.addResourceHandler("demo-signIn.html")
//                .addResourceLocations("classpath:/resources/");
//
//        registry.addResourceHandler("signSms.html")
//                .addResourceLocations("classpath:/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//}
