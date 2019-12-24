package com.zjy.controller;

import com.zjy.pojo.Goods;
import com.zjy.pojo.MiaoShaUser;
import com.zjy.redis.RedisService;
import com.zjy.service.GoodsService;
import com.zjy.service.MiaoShaUserService;
import com.zjy.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    MiaoShaUserService miaoShaUserService;
    @Autowired
    RedisService redisService;
    @Autowired
    GoodsService goodsService;
    /**
     * 商品列表页
     * @param model
     * @return
     */
    @RequestMapping("/to_list")
    public String toList( Model model, MiaoShaUser user){
        Goods goodsList = goodsService.listGoods();

            System.out.println(goodsList.getGoods_name());

        System.out.println(user.getNickname());
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }







}
