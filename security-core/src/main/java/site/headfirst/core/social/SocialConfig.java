package site.headfirst.core.social;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * 操作用户数据库的表
     * @notice 到类 JdbcUsersConnectionRepository 的目录下，拷贝
     * JdbcUsersConnectionRepository.sql。 去数据库执行下，创建对应的表
     * */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository jdbcUsersConnectionRepository =
                new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());

        // 这里可以进行表设置，比如添加表头
        // jdbcUsersConnectionRepository.setTablePrefix("hf");
        return jdbcUsersConnectionRepository;
    }

    @Bean
    public SpringSocialConfigurer socialSecurityConfig(){
        return new SpringSocialConfigurer();
    }

}


/**
 * RANK is a reserved word starting with MYSQL 8.0.2 (the version you upgraded to).
 * That's the reason why you get the error.
 *
 * To solve it is simple as adding backticks ` around RANK.
 *
 * You can find more details here While trying to read mysql error messages you should always look at
 * what is immediately before the point where the message starts from
 *
 * primary key (userId, providerId, providerUserId));
 * 业务系统 社交系统 用户关联Id
 *
 *
 * ----------------Start of SQL---------------
 * create table UserConnection (userId varchar(255) not null,
 * 	providerId varchar(255) not null,
 * 	providerUserId varchar(255),
 * 	`rank` int not null,
 * 	displayName varchar(255),
 * 	profileUrl varchar(512),
 * 	imageUrl varchar(512),
 * 	accessToken varchar(512) not null,
 * 	secret varchar(512),
 * 	refreshToken varchar(512),
 * 	expireTime bigint,
 * 	primary key (userId, providerId, providerUserId));
 * create unique index UserConnectionRank on UserConnection(userId, providerId, rank);
 * ----------------end of SQL---------------
 * */