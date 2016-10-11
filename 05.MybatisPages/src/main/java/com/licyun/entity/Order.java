package com.licyun.entity;

import java.io.Serializable;

public class Order implements Serializable{
	/**
	 *  `order_id` INT(10) 
	 *    `user_id` INT(10)
	 *    `order_no` VARCHAR(16) 
	 *    `money` FLOAT(10,2)
	 */
	private int order_id;
	private int user_id;
	private String order_no;
	private float money;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
}
