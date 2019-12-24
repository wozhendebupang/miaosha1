package com.zjy.redis;

public abstract class BasePrefix implements KryPrefix{

    public int expireSeconds;

    public String prefix;

    public BasePrefix(String prefix){
        this(0, prefix);
    }
    public BasePrefix(int expireSeconds, String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }


    public int getExpireSeconds(){

        return 0;
    }

    public String  getPrefix(){
        String a = getClass().getSimpleName();
        return a+":"+prefix;
    }

}
