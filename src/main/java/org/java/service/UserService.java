package org.java.service;

import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/14 23 37
 * @Description: 描述信息
 */


public interface UserService {

    public Map login(String username);


    public boolean checkName(String name);
}
