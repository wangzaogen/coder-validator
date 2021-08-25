package cn.coder.validator.service.impl;

import cn.coder.validator.annotation.ValidateMethodParam;
import cn.coder.validator.dto.TestDTO;
import cn.coder.validator.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    @ValidateMethodParam
    public String sayHello(String name) {
        return name + "say hello!";
    }

    @Override
    public String sayHello(TestDTO dto) {
        return dto.getName() + "say , I'm "+dto.getAge() + "years old";
    }
}
