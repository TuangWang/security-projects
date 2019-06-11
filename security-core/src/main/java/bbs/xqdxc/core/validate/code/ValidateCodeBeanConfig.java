package bbs.xqdxc.core.validate.code;


import bbs.xqdxc.core.validate.code.image.ImageCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import bbs.xqdxc.core.properties.SecurityProperties;
import bbs.xqdxc.core.validate.code.sms.DefaultSmsCodeSender;
import bbs.xqdxc.core.validate.code.sms.SmsCodeSender;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 如果Spring容器中有名称为imageCodeGenerator的Bean，将不会初始化下面的Bean了
     * */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }


    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
