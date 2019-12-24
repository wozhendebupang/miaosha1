package com.zjy.vo;

import com.zjy.pojo.Goods;

import java.util.Date;

public class GoodsVo extends Goods {

    private Integer  stock_count;
    private Date start_time;
    private Date end_time;
    private double miaosha_price;

    public double getMiaosha_price() {
        return miaosha_price;
    }

    public void setMiaosha_price(double miaosha_price) {
        this.miaosha_price = miaosha_price;
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
