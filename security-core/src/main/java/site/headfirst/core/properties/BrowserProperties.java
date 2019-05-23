package site.headfirst.core.properties;

import static site.headfirst.core.properties.LoginType.JSON;

public class BrowserProperties {
    private String loginPage = "/signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    // 登录后的处理方式，默认返回JSON（非跳转）
    private LoginType loginType = JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
