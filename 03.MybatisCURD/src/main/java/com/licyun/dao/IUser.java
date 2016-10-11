package com.licyun.dao;

import com.licyun.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by 李呈云
 * Description:
 * 2016/10/11.
 */
public interface IUser {
    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);

    @Insert("insert into user values(#{id},#{name},#{dept},#{website},#{phone})")
    public void insertUser(User user);

    @Update("update user set name=#{name},dept=#{dept},phone=#{phone},website=#{website} where id = #{id}")
    public void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public void deleteUser(int userId);

    @Select("select * from user;")
    public List<User> getUserList();
}