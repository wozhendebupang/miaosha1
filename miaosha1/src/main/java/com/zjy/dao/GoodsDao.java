package com.zjy.dao;

import com.zjy.pojo.Goods;
import com.zjy.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {

//    @Select("select g.*,mg.stock_count,mg.start_time,mg.end_time,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id=g.id")
//    public List<GoodsVo> listGoodsVo();

    @Select("select * from goods where id=#{id}")
    public Goods listGoods(@Param("id")long id );
}
