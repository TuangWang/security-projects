package bbs.xqdxc.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="bbs.xqdxc")
public class SecurityProperties {

    /**
     *  web 浏览器配置
     */
    private BrowserProperties web = new BrowserProperties();

    /**
     * 图形验证码配置项
     * ValidateCodeProperties code: bbs.xqdxc.code.image 来进行相关配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getWeb() {
        return web;
    }

    public void setWeb(BrowserProperties web) {
        this.web = web;
    }

    /**
     * Social 配置
     * */
    public SocialProperties social = new SocialProperties();

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    /**
     * OAuth2 配置
     * */

    private OAuth2Properties oauth2 = new OAuth2Properties();

    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }
}
