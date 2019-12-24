package com.zjy.redis;

public class MiaoShaUserKey extends BasePrefix{
    public static final int TOKEN_EXPIRE = 3600*24*2;

    private MiaoShaUserKey(int expireSeconds, String prefix){

        super(expireSeconds, prefix);
    }


    public static MiaoShaUserKey TOKEN = new MiaoShaUserKey(TOKEN_EXPIRE, "tk");

    @Override
    public int expireSeconds() {
        return TOKEN_EXPIRE;
    }
}
