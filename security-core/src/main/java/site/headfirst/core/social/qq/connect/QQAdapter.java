package site.headfirst.core.social.qq.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import site.headfirst.core.social.qq.api.QQ;
import site.headfirst.core.social.qq.api.QQUserInfo;

/**
 * 用于构建connectionFactory
 *
 *
 * */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试服务是否可用。 这里默认QQ一直可用，返回TRUE
     * */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    /**
     * social 数据和资源方数据适配
     * */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();

        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        // 个人主页
        values.setProfileUrl(null);
        values.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {
        // do nothing

    }
}
