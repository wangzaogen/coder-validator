package cn.coder.validator.validate;

import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author coder.wang
 * @description 验证参数
 */
public class ValidateParamsProcess {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private static final Validator validator = factory.getValidator();

    private static final ExecutableValidator executableValidator = validator.forExecutables();


    /**
     * 对象参数验证
     * @param o 验证对象
     */
    public static void validate(Object o){
        Set<ConstraintViolation<Object>> set = validator.validate(o);
        checkViolations(set);
    }

    /**
     * 方法参数验证
     * @param o 方法当前对象
     * @param methodName 方法名称
     * @param values 方法参数值集合
     * @throws NoSuchMethodException
     */
    public static void validateMethod(Object o, String methodName, Object ... values) throws NoSuchMethodException {
        Method method = null;
        try {
            Class<?>[] parameterTypes = new Class[values.length];
            for (int i = 0 ; i<values.length; i++) {
                parameterTypes[i] = values[i].getClass();
            }
            method = o.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e){
            throw e;
        }
        validateMethod(o, method, values);
    }

    /**
     * 方法参数验证
     * @param o 方法当前对象
     * @param method 方法
     * @param values 方法参数值集合
     */
    public static void validateMethod(Object o, Method method, Object ... values) {
        Set<ConstraintViolation<Object>> violations = executableValidator.validateParameters(
                o, method, values);
        checkViolations(violations);
    }

    private static void checkViolations(Set<ConstraintViolation<Object>> violations) {
        StringBuilder errorMsg = new StringBuilder();
        for (ConstraintViolation<Object> constraintViolation : violations) {
            errorMsg.append(constraintViolation.getPropertyPath()).append(":").append(constraintViolation.getMessage()).append("\n");
        }
        if (StrUtil.isNotBlank(errorMsg)) {
            throw new IllegalArgumentException(errorMsg.toString());
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TestMethod method = new TestMethod();
//        validateMethod(method, "getMessage", "hello","");
        validate(method);
    }
}
