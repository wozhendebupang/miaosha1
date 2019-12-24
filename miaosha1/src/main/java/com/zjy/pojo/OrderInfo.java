package com.zjy.pojo;

import java.util.Date;

public class OrderInfo {
    private Long id;
    private Long user_id;
    private Long goods_id;
    private Long  delivery_addr_id;
    private String goods_name;
    private Integer goods_count;
    private Double goods_price;
    private Integer order_channel;
    private Integer status;
    private Date create_time;
    private Date pay_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Long getDelivery_addr_id() {
        return delivery_addr_id;
    }

    public void setDelivery_addr_id(Long delivery_addr_id) {
        this.delivery_addr_id = delivery_addr_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getOrder_channel() {
        return order_channel;
    }

    public void setOrder_channel(Integer order_channel) {
        this.order_channel = order_channel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }
}
