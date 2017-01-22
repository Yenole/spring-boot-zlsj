package com.qiyun.utils;

import com.qiyun.model.User;

import java.util.Date;

/**
 * Created by Yenole on 2017/1/9.
 */
public class Utils {
    public static User obtainUser(String username, String pass, String lastip) {
        User user = new User();
        user.setUser(username);
        user.setPass(pass);
        user.setLastip(lastip);
        user.setRegtime(new Date());
        user.setLasttime(new Date());
        return user;
    }
}
