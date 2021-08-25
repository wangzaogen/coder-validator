package cn.coder.validator.validate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author gavin.wang
 * @date 2021/8/25 16:35
 * @description TODO
 */
public class TestMethod {

    @NotNull(message = "name is not null!")
    private String name;
    private String address;

    public TestMethod() {
    }

    public TestMethod(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getMessage(@NotBlank String name, @NotBlank String address){
        return name+" hello!";
    }
}
