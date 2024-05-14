package com.zlr.springbootwebdemo1.demos.controller;

import com.zlr.springbootwebdemo1.demos.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Result HelloController(){
        return Result.success("Hello SpringBoot");
    }

}
