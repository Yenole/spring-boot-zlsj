package com.qiyun.dao;

import com.qiyun.model.Role;
import com.qiyun.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Yenole on 2017/1/9.
 */
@Mapper
public interface IUserDao {

    @Insert("INSERT INTO `user` (`user`,pass,flags,regtime,lasttime,lastip) VALUES (#{u.user},#{u.pass},0,#{u.regtime},#{u.lasttime},#{u.lastip})")
    @SelectKey(before = false, statement = "select max(id) as id from user", keyProperty = "u.id", resultType = Integer.class)
    int create(@Param("u") User user);

    @Select("SELECT COUNT(id) FROM `user` WHERE `user`=#{u}")
    int checkUser(@Param("u") String user);


    @Select("SELECT * FROM `user` WHERE `user`=#{u} AND pass=#{p}")
    User once(@Param("u") String user, @Param("p") String pass);


    @Update("UPDATE `user` SET lasttime=#{u.lasttime},lastip=#{u.lastip},numlogin=#{u.numlogin}")
    int updateIpAndLoginTime(@Param("u") User user);


    @Select("SELECT a.mid as id, a.`level`, b.`key` as server FROM roles a, `server` b WHERE a.serverid = b.id AND a.userid = #{u.id}")
    List<Role> list(@Param("u") User user);

    @Select("SELECT COUNT(id) FROM `roles` WHERE `serverid` = #{sid} AND `userid` = #{u.id}")
    int checkRole(@Param("sid") long sid, @Param("u") User user);

    @Update("UPDATE roles SET level=#{level} WHERE userid=#{u.id} AND serverid=#{sid}")
    int uRoleLevel(@Param("u") User user, @Param("sid") long sid, @Param("level") int level);

    @Insert("INSERT INTO .`roles` (`userid`, `level`, `serverid`, `mid`) VALUES (#{u.id},0,#{sid},#{mid})")
    int newRole(@Param("u") User user, @Param("sid") long sid, @Param("mid") int mid);
}
