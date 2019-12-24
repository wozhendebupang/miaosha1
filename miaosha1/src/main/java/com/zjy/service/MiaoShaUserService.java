package com.zjy.service;

import com.alibaba.druid.util.StringUtils;
import com.zjy.dao.MiaoShaUserDao;
import com.zjy.exception.GlobalException;
import com.zjy.pojo.MiaoShaUser;
import com.zjy.redis.MiaoShaUserKey;
import com.zjy.redis.RedisService;
import com.zjy.result.CodeMsg;
import com.zjy.util.MD5Util;
import com.zjy.util.UUIDUtil;
import com.zjy.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class MiaoShaUserService {

    @Autowired
    MiaoShaUserDao miaoShaUserDao;


    public static final String COOKI_NAME_TOKEN = "token";
    @Autowired
    RedisService redisService;
    public MiaoShaUser getById(long id){
        return miaoShaUserDao.getById(id);
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo){
        if(loginVo==null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }

        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();

        MiaoShaUser user = getById(Long.parseLong(mobile));
        if(user==null){
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }

        
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();

        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if(!calcPass.equals(dbPass)){

            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        redisService.set(MiaoShaUserKey.TOKEN, token, user);
//        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
//        cookie.setMaxAge(MiaoShaUserKey.TOKEN.expireSeconds());
//        cookie.setPath("/");
//        response.addCookie(cookie);
        addCookie(response, token, user);
        return true;

    }

    public MiaoShaUser getByToken(HttpServletResponse response, String token){

        if(StringUtils.isEmpty(token)){
            return null;
        }
        MiaoShaUser miaoShaUser = redisService.get(MiaoShaUserKey.TOKEN, token, MiaoShaUser.class);
        if(miaoShaUser!=null){
            addCookie(response, token, miaoShaUser);
        }
        return miaoShaUser;
    }

    public void addCookie(HttpServletResponse response,  String token, MiaoShaUser user){

        redisService.set(MiaoShaUserKey.TOKEN, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoShaUserKey.TOKEN.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
