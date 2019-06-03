package site.headfirst.web.controller;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import site.headfirst.core.properties.SecurityProperties;
import site.headfirst.core.support.SimpleResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class WebSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 上一个网络请求的URL。当前URL为被跳转到的路径
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 当需要访问授权的资源、跳转到此路径
     * */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if(null != savedRequest) {
            String target = savedRequest.getRedirectUrl();
            logger.info("target url is " + target);

            if(StringUtils.endsWithIgnoreCase(target, ".html")){
                try {
                    logger.info(securityProperties.getWeb().getLoginPage());
                    redirectStrategy.sendRedirect(request, response, securityProperties.getWeb().getLoginPage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new SimpleResponse("Authentication is required, please login in first");
    }
}
