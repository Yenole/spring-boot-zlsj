package com.qiyun.model;

import java.util.Date;

/**
 * Created by Yenole on 2017/1/9.
 */
public class User {
    int id;
    String user;
    String pass;
    int flags;
    Date regtime;
    Date lasttime;
    String lastip;
    String lastserver;
    int numlogin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public String getLastserver() {
        return lastserver;
    }

    public void setLastserver(String lastserver) {
        this.lastserver = lastserver;
    }

    public int getNumlogin() {
        return numlogin;
    }

    public void setNumlogin(int numlogin) {
        this.numlogin = numlogin;
    }
}
