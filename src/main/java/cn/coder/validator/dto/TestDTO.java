package cn.coder.validator.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TestDTO {

    @NotBlank
    private String name;

    @NotNull
    private Integer age;
}
