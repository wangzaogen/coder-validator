package cn.coder.validator.aop;

import cn.coder.validator.validate.ValidateParamsProcess;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author coder.wang
 * @description 参数验证切面
 */
@Aspect
@Component
@Slf4j
public class ValidateParamAspect {

    @Pointcut(value = "@annotation(cn.coder.validator.annotation.ValidateObjectParam)")
    public void validateParamForObjectPointAut() {

    }

    @Pointcut(value = "@annotation(cn.coder.validator.annotation.ValidateMethodParam)")
    public void validateMethodParamPointAut() {

    }

    @Before(value = "validateParamForObjectPointAut()")
    public void validateParamForObject(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        if (params.length == 0) {
            return;
        }
        log.info("validateMethodParam: {}", joinPoint);
        for (Object obj : params) {
            ValidateParamsProcess.validate(obj);
        }
    }

    @Before(value = "validateMethodParamPointAut()")
    public void validateParam(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        if (params.length == 0) {
            return;
        }
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        log.info("validateMethodParam, methodName={}, {}",joinPoint.getSignature().getName(), joinPoint);
        ValidateParamsProcess.validateMethod(joinPoint.getTarget(), method ,params);
    }

}
