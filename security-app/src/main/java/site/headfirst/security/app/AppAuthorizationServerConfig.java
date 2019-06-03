package site.headfirst.security.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


/**
 * Demo 应用成为认证服务器
 * */
@Configuration
@EnableAuthorizationServer
public class AppAuthorizationServerConfig {
}
