package com.qiyun.service.impl;

import com.qiyun.dao.IServerDao;
import com.qiyun.dao.IUserDao;
import com.qiyun.model.Message;
import com.qiyun.model.Role;
import com.qiyun.model.User;
import com.qiyun.service.IServerService;
import com.qiyun.service.IUserService;
import com.qiyun.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Yenole on 2017/1/9.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Autowired
    IServerDao serverDao;

    @Override
    public User login(String username, String pass, String lastip) {
        User user = userDao.once(username, pass);
        if (null != user) {
            user.setLastip(lastip);
            user.setLasttime(new Date());
            user.setNumlogin(user.getNumlogin() + 1);
            userDao.updateIpAndLoginTime(user);
        }
        return user;
    }

    @Override
    public boolean hasUser(String user) {
        return userDao.checkUser(user) > 0;
    }

    @Override
    public Message regist(String username, String pass, String lastip) {
        if (userDao.checkUser(username) == 0) {
            User user = Utils.obtainUser(username, pass, lastip);
            userDao.create(user);
            return new Message(true);
        }
        return new Message(false, "用户名重复!");
    }


    @Override
    public HashMap<String, Role> getUserRoles(User user) {
        Iterator<Role> it = userDao.list(user).iterator();
        HashMap<String, Role> ret = new HashMap<String, Role>();
        while (it.hasNext()) {
            Role role = it.next();
            ret.put(role.getServer(), role);
        }
        return ret;
    }

    public Message updateRoleInfo(String user, String pass, String sid, int level) {
        User user1 = userDao.once(user, pass);
        if (null != user1) {
            long serverId = serverDao.getServerId(sid);
            if (serverId != 0 && userDao.uRoleLevel(user1, serverId, level) > 0) {
                return new Message(true);
            }
        }
        return new Message(false);
    }

    @Override
    public Message newRole(String user, String pass, int mid) {
        User user1 = userDao.once(user, pass);
        if (null != user1) {
            long serverId = serverDao.getServerId(user1.getLastserver());
            if (userDao.checkRole(serverId, user1) == 0 && serverId != 0 && userDao.newRole(user1, serverId, mid) > 0) {
                return new Message(true);
            }
        }
        return new Message(false);
    }
}
