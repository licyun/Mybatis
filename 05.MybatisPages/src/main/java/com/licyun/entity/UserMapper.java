package com.licyun.entity;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.licyun.util.Page;

public interface UserMapper {
	
	@Select("SELECT u.*,o.* FROM `user` u, `order` o WHERE u.id=o.user_id AND u.id=#{id}")
	public List<Order> getUserOrders(int id);
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	public User getUserById(int id);
	
	@Select("SELECT u.*,o.* FROM `user` u, `order` o WHERE u.id=o.user_id AND u.id=#{userid} LIMIT #{page.currentResult}, #{page.showCount}")
	public List<Order> getOrderListPage(@Param("page") Page page, @Param("userid") int userid);
}
