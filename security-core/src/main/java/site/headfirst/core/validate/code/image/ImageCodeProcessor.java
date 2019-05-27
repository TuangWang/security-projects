package site.headfirst.core.validate.code.image;


import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import site.headfirst.core.validate.code.impl.AbstractValidateCodeProcessor;

import javax.imageio.ImageIO;

/**
 * 图片验证码处理器
 *
 * @author wangxiaofeng
 *
 * */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {
    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }

}
