package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/14 23 17
 * @Description: 描述信息
 */

@Mapper
public interface UserMapper  {
    /**登录
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public List<Map> login(@Param("username") String username);

    //注册，根据用户名，判断用户名是否存在
    public boolean checkName(String name);



}
