package com.zjy.dao;

import com.zjy.pojo.MiaoShaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MiaoShaUserDao {

    @Select("select * from miaosha_user where id=#{id}")
    public MiaoShaUser getById(@Param("id")long id);

}
