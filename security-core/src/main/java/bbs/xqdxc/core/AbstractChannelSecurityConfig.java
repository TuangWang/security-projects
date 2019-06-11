//package bbs.xqdxc.core;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import SecurityConstants;
//
//@Configuration
//public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    protected AuthenticationSuccessHandler authenticationSuccessHandler;
////
////    @Autowired
////    protected AuthenticationFailureHandler authenticationFailureHandler;
////
////    public void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
////        http.formLogin()
////                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
////                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
////                .successHandler(authenticationSuccessHandler)
////                .failureHandler(authenticationFailureHandler);
////    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//}
