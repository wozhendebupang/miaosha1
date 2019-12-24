package com.zjy.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;// = new RedisConfigFactory().jedisPoolFactory();

    /**
     * 在将key的值放入缓存前，先使用本方法，识别value的类型，并转换为string类型再放入缓存中
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToString(T value){
        if(value==null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz==int.class || clazz==Integer.class){
            return ""+value;
        }else if(clazz==long.class || clazz==Long.class){
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }

    }


    /**
     * 从缓存中获取的key的值，首先是string类型的，因此提供本方法，根据传入的类型，自动将string的值转换为对应的目标类型
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T stringToBean(String str, Class<T> clazz){
        if(str==null || str.length()<=0 || clazz==null){
            return null;
        }
        if(clazz==int.class || clazz==Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz==String.class){
            return (T)str;
        }else if(clazz==long.class || clazz==Long.class){
            return (T)Long.valueOf(str);
        }else{
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    /**
     * 获取缓存中的key的值
     * @param keyPrefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KryPrefix keyPrefix, String key, Class<T> clazz){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix()+key;
            String str = jedis.get(realKey);
            T t = stringToBean(str, clazz);
            return t;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    /**
     * 将key和value放入缓存中
     * @param keyPrefix     拼接key，前面加的模块的名称
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KryPrefix keyPrefix, String key, T value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            String realKey = keyPrefix.getPrefix()+key;
            int seconds = keyPrefix.expireSeconds();
            if(seconds<=0) {
                jedis.set(realKey, str);
            }else{
                jedis.setex(realKey,seconds, str);
            }
            return true;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    /**
     * 判断这个key是否存在
     * @param keyPrefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KryPrefix keyPrefix, String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix()+key;
            return jedis.exists(realKey);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    /**
     * 该方法会将key的 值+1
     * @param keyPrefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long incr(KryPrefix keyPrefix, String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix()+key;
            return jedis.incr(realKey);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    /**
     * 该方法会将key的值减1
     * @param keyPrefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decr(KryPrefix keyPrefix, String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix()+key;
            return jedis.decr(realKey);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }



}
