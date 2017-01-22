package com.qiyun.service.impl;

import com.qiyun.dao.IServerDao;
import com.qiyun.model.Server;
import com.qiyun.service.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yenole on 2017/1/9.
 */
@Service
public class ServerSeviceImpl implements IServerService {
    @Autowired
    IServerDao serverDao;

    @Override
    public HashMap<String, Object> list() {
        HashMap<String, Object> ret = new HashMap<String, Object>();
        HashMap<String, Object> listMap = new HashMap<String, Object>();
        ret.put("list", listMap);
        Iterator<Server> it = serverDao.list().iterator();
        while (it.hasNext()) {
            Server server = it.next();
            listMap.put(server.getKey(), server);
        }
        ret.put("newList",serverDao.newList());
        return ret;
    }
}
