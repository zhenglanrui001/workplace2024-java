package com.zlr.springbootwebdemo1.demos.controller;

import com.zlr.springbootwebdemo1.demos.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@RestController
public class RequestCotroller {

    //原始方式
    /*@RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        //获取参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println(name + ":" + age);
        return "OK";
    }*/

    //SpringBoot方式
    //参数和需要的参数名称对应（项目开始前规定好）
    //若不同，@RequestParam("name") + 类型 + 非规定参数名
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam("name") String username, Integer age){

        System.out.println(username + ":" + age);
        return "OK";
    }

    //实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

    //复杂实体类
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "OK";
    }


    //hobby=A&hobby=B&hobby=C
    //数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }


    //集合
    //参数需要@RequestParam才能保证后面是集合
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok";

    }

    //日期参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
                                LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";

    }

    //JSON参数 {“ ”：“ ”}
    //@RequestBody 支持解析JSON
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }

    //路径参数 RESTful风格
    //{}包裹动态的值
    //函数里面识别不出{}中内容：引入@PathVariable 类型 变量
    @RequestMapping("/urlParam/name/{name}")
    public String urlParam(@PathVariable String name){
        System.out.println(name);
        return "okk";

    }

    //非return识别响应，本质是@ResponseBody(集成在别的注解里)
    //@Controller：将当前class以controller控制器的方式交给springboot接管
    //@RequestBody：class中的模块识别其中的业务，当做响应体返回前端
    //@RestController:是上面两个的缩写（写上两个就不用写这个）

    //响应 @ResponseBody
    //之前写的OK、ok、okk太不规范，因此设置一个响应模式
    /*
    * {
    * "code" : 1,
    * "msg" : "success",
    * "data" : .....
    * }
    * */

    //不用字符串方式，用实体类（响应体实体类）
    //Result.java


}
