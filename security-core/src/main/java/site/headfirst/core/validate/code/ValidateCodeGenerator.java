package site.headfirst.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ImageCode creatImageCode(ServletWebRequest request);
}
