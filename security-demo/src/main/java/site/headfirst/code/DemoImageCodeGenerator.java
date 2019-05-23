package site.headfirst.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import site.headfirst.core.validate.code.ImageCode;
import site.headfirst.core.validate.code.ValidateCodeGenerator;


/**
 * 为了演示
 * 以增量的方式去实现变化。老的代码不用动
 *
 * */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode creatImageCode(ServletWebRequest request) {
        // 更高级图形申请器代码
        return null;
    }
}
