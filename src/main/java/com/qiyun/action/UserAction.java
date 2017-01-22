package com.qiyun.action;

import com.alibaba.druid.util.StringUtils;
import com.qiyun.model.Message;
import com.qiyun.model.User;
import com.qiyun.service.IUserService;
import com.qiyun.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yenole on 2017/1/9.
 */
@RestController
public class UserAction {
    @Autowired
    IUserService userService;


    @RequestMapping("/login")
    public Message login(String user, String pass, HttpServletRequest request) {
        User user1 = userService.login(user, pass, WebUtils.getIP(request));
        if (null != user1) {
            WebUtils.setUser(request, user1);
            return new Message(true);
        }
        return new Message(false, userService.hasUser(user) ? 1 : 0, null);
    }

    @RequestMapping("/regist")
    public Object regist(String user, String pass, HttpServletRequest request) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(pass))
            return new Message(false, "用户名或密码不能为空");
        return userService.regist(user, pass, WebUtils.getIP(request));
    }

    @RequestMapping("/newRole")
    public Message createRole(String user, String pass,  int mid) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(pass))
            return new Message(false, "用户名或密码不能为空");
        return userService.newRole(user, pass, mid);
    }

    @RequestMapping("/updateRole")
    public Message updateRole(String user, String pass, String sid, int level) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(pass))
            return new Message(false, "用户名或密码不能为空");
        return userService.updateRoleInfo(user, pass, sid, level);
    }
}
