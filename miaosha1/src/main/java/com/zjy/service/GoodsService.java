package com.zjy.service;

import com.zjy.dao.GoodsDao;
import com.zjy.pojo.Goods;
import com.zjy.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;


//    public List<GoodsVo> listGoodsVo(){
//        List<GoodsVo> list = goodsDao.listGoodsVo();
//        for(GoodsVo gv : list){
//            System.out.println(gv.getGoods_name()+ "service");
//        }
//        return goodsDao.listGoodsVo();
//    }
    public Goods listGoods(){
        Goods goods = goodsDao.listGoods(1);

            System.out.println(goods.getGoods_name()+ "service");

        return goodsDao.listGoods(1);
    }

}
