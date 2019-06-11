package bbs.xqdxc.core.social.qq.connect;

import bbs.xqdxc.core.social.qq.api.QQ;
import bbs.xqdxc.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * ServiceProvider构建需要获取
 * 1. OAuth2Operations (OAuth2Template 为其一实现)
 * 2. Api 获取用户信息
 * */

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    /**
     * Create a new {@link OAuth2ServiceProvider}.
     *
     * @param oauth2Operations the OAuth2Operations template for conducting the OAuth 2 flow with the provider.
     *
     * 初始化provider 需要创建OAuth2Template，通过其构造函数提供四个参数
     * - appId 应用id
     * - appSecret 应用密码
     * - URL_AUTHORIZE 授权页
     * - URL_ACCESS_TOKEN  获取Token的URL
     */
    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    }

    /**
     * 用于获取用户信息的Api
     * */
    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
