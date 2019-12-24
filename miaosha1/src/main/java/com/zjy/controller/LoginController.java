package com.zjy.controller;

import com.zjy.result.CodeMsg;
import com.zjy.result.Result;
import com.zjy.service.MiaoShaUserService;
import com.zjy.util.ValidatorUtil;
import com.zjy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MiaoShaUserService miaoShaUserService;


    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){

        String passInput = loginVo.getPassword();
        String mobile = loginVo.getMobile();

        if(StringUtils.isEmpty(passInput)){
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(!ValidatorUtil.isMobile(mobile)){
            return Result.error(CodeMsg.MOBILE_ERROR);
        }
        //登录
        miaoShaUserService.login(response, loginVo);

        return Result.success(true);

    }


}
