package bbs.xqdxc.core.properties;

public class BrowserProperties {

    private String loginPage = "/signIn.html";

    // 登录后的处理方式，默认返回JSON（非跳转）
    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 60 * 60 * 24;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
