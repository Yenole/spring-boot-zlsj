package com.qiyun.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Yenole on 2017/1/10.
 */
public class Role {
    int id;
    int level;
    String server;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @JsonIgnore
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
