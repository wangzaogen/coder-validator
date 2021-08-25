package cn.coder.validator.controller;

import cn.coder.validator.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping(value = "/paramTest")
    public String index() {
        String name = "";
        return testService.sayHello(name);
    }
}
