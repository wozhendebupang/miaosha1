package com.zjy.controller;

import com.zjy.pojo.User;
import com.zjy.redis.RedisService;
import com.zjy.redis.UserKey;
import com.zjy.result.CodeMsg;
import com.zjy.result.Result;

import com.zjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello spring world!";
    }
    /**
     * 作为一个controller，他的方法总共又分两大类
     * 1、rest api的json输出
     * 2、页面
     *
     */
    /**
     * 如果是硬编码的写法，正确结果为
     * @RequestMapping("/hello")
     *     @ResponseBody
     *     String hello(){
     *         return new Result(0, "success", "hello, json result");
     *     }
     *     还需要定义错误的各种code
     *     @RequestMapping("/helloError")
     *     @ResponseBody
     *     String helloError(){
     *         return new Result(500101, "error msg");
     *         return new Result(500102, "error msg");
     *     }
     *     为了避免这种硬编码的形式，因此改为下面
     * @return
     */
    /**
     * 访问的地址为http://localhost:8080/demo/hello和http://localhost:8080/demo/helloError
     * 其中demo是类加的@RequestMapping("/demo")，htllo和helloError是方法中加的    @RequestMapping("/hello")和    @RequestMapping("/helloError")
     * 根据访问地址的不同，展示不同的结果
     * @return
     */
    @RequestMapping("/helloSuccess")
    @ResponseBody
    public Result<String> hello(){
        return Result.success("hello json result");
    }
    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }


    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "zjy");
        return "hello";
    }


    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(){
        User user = userService.getByid(1);
        return Result.success(user);
    }
//    @RequestMapping("/redis/get")
//    @ResponseBody
//    public Result<Long> redisGet(){
//        Long v1 = redisService.get("key1", Long.class);
//        return Result.success(v1);
//    }
//
//    @RequestMapping("/redis/set")
//    @ResponseBody
//    public Result<String> redisSet(){
//        Boolean v2 = redisService.set("key2", "hhh");
//        String str = redisService.get("keys2", String.class);
//        return Result.success(str);
//    }


    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<String> redisKey(){
        Boolean v2 = redisService.set(UserKey.getById, "key2", "hhh");
        String str = redisService.get(UserKey.getById,"key2", String.class);
        return Result.success(str);
    }
}
