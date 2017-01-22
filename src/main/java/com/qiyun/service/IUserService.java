package com.qiyun.service;

import com.qiyun.model.Message;
import com.qiyun.model.Role;
import com.qiyun.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;

/**
 * Created by Yenole on 2017/1/9.
 */
public interface IUserService {
    User login(String username, String pass, String lastip);

    boolean hasUser(String user);

    Message regist(String username, String pass, String lasip);

    HashMap<String, Role> getUserRoles(User user);

    Message newRole(String user, String pass,int mid);

    Message updateRoleInfo(String user, String pass, String sid, int level);
}
