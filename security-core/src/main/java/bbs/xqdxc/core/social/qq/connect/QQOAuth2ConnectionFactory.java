package bbs.xqdxc.core.social.qq.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import bbs.xqdxc.core.social.qq.api.QQ;

public class QQOAuth2ConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQOAuth2ConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }

}
