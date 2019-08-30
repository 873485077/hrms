package org.java.service.impl;

import org.java.dao.UserMapper;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/14 23 38
 * @Description: 描述信息
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public Map login(String username) {
        List<Map> list = mapper.login(username);
        if (list.isEmpty()){
            return null;//用户名不存在
        }else {
            return list.get(0);
        }

    }

    @Override
    public boolean checkName(String name) {
        boolean check = mapper.checkName(name);

        return check;
    }
}
