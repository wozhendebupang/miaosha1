package com.zjy.redis;

public class UserKey extends BasePrefix {

    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey  getById = new UserKey("id");
    public static UserKey  getByName = new UserKey("name");

    @Override
    public int expireSeconds() {
        return 0;
    }
}
