package site.headfirst.code;

import org.springframework.web.context.request.ServletWebRequest;
import site.headfirst.core.validate.code.ValidateCode;
import site.headfirst.core.validate.code.image.ImageCode;
import site.headfirst.core.validate.code.ValidateCodeGenerator;


/**
 * 为了演示
 * 以增量的方式去实现变化。老的代码不用动
 *
 * */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        return null;
    }
}
