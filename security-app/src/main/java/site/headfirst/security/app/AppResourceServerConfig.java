package site.headfirst.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import site.headfirst.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import site.headfirst.core.properties.SecurityConstants;
import site.headfirst.core.properties.SecurityProperties;
import site.headfirst.core.validate.code.ValidateCodeSecurityConfig;
import site.headfirst.security.app.authentication.AppAuthenticationFailureHandler;
import site.headfirst.security.app.authentication.AppAuthenticationSuccessHandler;


/**
 * Demo 应用成为资源服务器
 * */
@Configuration
@EnableResourceServer
public class AppResourceServerConfig extends ResourceServerConfigurerAdapter  {

    @Autowired
    SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    protected AppAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    protected AppAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);

        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers(
                        // 表单登录
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        // 手机验证码登录
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        // 图片及手机验证码请求
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*"
                ).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
