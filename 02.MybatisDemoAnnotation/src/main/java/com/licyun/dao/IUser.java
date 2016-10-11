package com.licyun.dao;

import com.licyun.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/11.
 */
public interface IUser {
    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);
}