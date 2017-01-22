package com.qiyun.action;

import com.qiyun.model.Role;
import com.qiyun.model.User;
import com.qiyun.service.IServerService;
import com.qiyun.service.IUserService;
import com.qiyun.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Yenole on 2017/1/9.
 */
@RestController
public class ServerAction {

    @Autowired
    IServerService serverService;

    @Autowired
    IUserService userService;

    @RequestMapping("/slist")
    public HashMap<String, Object> sList(HttpServletRequest request) {
        HashMap<String, Object> ret = serverService.list();
        User user = WebUtils.getUser(request);
        ret.put("lastLogin", null != user ? user.getLastserver() : null);
        return ret;
    }

    @RequestMapping("/ulist")
    public HashMap<String, Role> uList(HttpServletRequest request) {
        User user = WebUtils.getUser(request);
        return null != user ? userService.getUserRoles(user) : new HashMap<String, Role>();
    }
}
