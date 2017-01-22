package com.qiyun.dao;

import com.qiyun.model.Server;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Yenole on 2017/1/9.
 */
@Mapper
public interface IServerDao {
    @Select("select * from server")
    List<Server> list();

    @Select("select `key` from server where state=0")
    List<String> newList();


    @Select("SELECT id FROM `server` WHERE `key`=#{sid}")
    long getServerId(@Param("sid") String sid);
}
