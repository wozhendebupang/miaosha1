package com.zjy.vo;

import com.zjy.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LoginVo {

    @NotNull
    @Length(min=32)
    private String password;

    @NotNull
    @IsMobile
    private String mobile;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
