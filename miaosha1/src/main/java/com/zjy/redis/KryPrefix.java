package com.zjy.redis;

/**
 * 想实现一个redis的key是先拼接上一个模块的名字，因此使用模型开发模式，先定义一个接口，再用一个抽象类实现该接口，
 * 再使用类继承该抽象类
 * 本接口即为定义的接口类
 */
public interface KryPrefix {

    public int expireSeconds();
    public String getPrefix();

}
