//package site.headfirst.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import site.headfirst.service.HelloService;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
//
//    // 可以置入Spring容器里的bean进行校验
//    @Autowired
//    HelloService helloService;
//
//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
//
//        return false;
//    }
//
//    @Override
//    public void initialize(MyConstraint constraintAnnotation) {
//        System.out.println("my validation init");
//    }
//}
