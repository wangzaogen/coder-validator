package cn.coder.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"cn.coder.validator"})
@SpringBootApplication
public class ValidateApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ValidateApplication.class, args);
	}
}
