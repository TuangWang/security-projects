package bbs.xqdxc.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * AbstractOAuth2ApiBinding 提供两个属性
 *  获取的令牌
 *  private final String accessToken;
 *
 *  父类提供，用户发送请求获取信息
 * 	private RestTemplate restTemplate;
 *
 * */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    /**
     * 通过accessToken 获取用户的OpenId
     * 资源服务方（QQ, Weixin）不可能将用户的账号给服务提供方.
     * openId + 第三方服务商的appId 唯一确定用户的QQ号或者微信号
     * @link "http://wiki.connect.qq.com/get_user_info"
     * */
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * https://graph.qq.com/user/get_user_info?
     * access_token=*************&
     * oauth_consumer_key=12345&
     * openid=****************
     *
     * 第一个参数access_token由父类进行处理
     * 第二个参数 oauth_consumer_key 为应用在资源方(QQ, Weixin)申请的AppId
     * 第三个参数
     * */
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * TokenStrategy.ACCESS_TOKEN_PARAMETER
     * 请求策略。参考父类 AUTHORIZATION_HEADER 放在请求头里
     * ACCESS_TOKEN_PARAMETER 放在URL里。
     * 此处，根据QQ文档，采用放在URL里的策略
     * */
    public QQImpl(String access_token, String appId) {
        super(access_token, TokenStrategy.ACCESS_TOKEN_PARAMETER);

        this.appId = appId;
        String url = String.format(URL_GET_OPENID, access_token);
        // 获取用户的openId
        String result = getRestTemplate().getForObject(url, String.class);
        this.openId = StringUtils.substringBetween(result, "\"openid\":", "}");
    }

    @Override
    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);

        try {
            QQUserInfo userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
