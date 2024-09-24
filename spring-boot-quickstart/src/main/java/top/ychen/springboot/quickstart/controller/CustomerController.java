package top.ychen.springboot.quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ychen.springboot.quickstart.enums.RequestType;
import top.ychen.springboot.quickstart.service.CustomerService;

@RestController
@RequestMapping("/requests")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @GetMapping("/{type}")
    public String handleRequest(@PathVariable RequestType type) {
        return customerService.handleRequest(type);
    }
}
