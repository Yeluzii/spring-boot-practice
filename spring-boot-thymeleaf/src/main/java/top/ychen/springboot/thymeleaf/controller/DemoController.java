package top.ychen.springboot.thymeleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + " !";
    }
    @GetMapping("/factorial/{number}")
    public String calculateFactorial(@PathVariable int number) {
        return "Factorial of " + number + " is: " + factorial(number);
    }

    // 计算阶乘的递归方法
    private int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    @GetMapping("/divide/{a}/{b}")
    public String divideNumbers(@PathVariable int a, @PathVariable int b) {
        return "Result of " + a + " divided by " + b + " is: " + divide(a, b);
    }

    // 执行除法
    private int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }
}
