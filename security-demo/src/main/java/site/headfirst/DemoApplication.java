package site.headfirst;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getContextClassLoader;

@SpringBootApplication
@EnableWebSecurity
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        getContextClassLoader();
    }
}
