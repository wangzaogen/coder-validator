package cn.coder.validator.service;

import cn.coder.validator.dto.TestDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface TestService {

    String sayHello(@NotBlank String name);

    String sayHello(TestDTO dto);
}
