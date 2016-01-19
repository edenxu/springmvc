package com.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mvc.pojo.UserInfo;

@Component
public interface ITestDAO {
	/**
	 * 添加一条新的用户记录
	 * 
	 * @param ui
	 *            用户对象信息
	 * @return 操作结果
	 */
	public int add(UserInfo ui);

	/**
	 * 根据用户代码查询用户信息
	 * 
	 * @param userCode
	 *            用户代码
	 * @return 用户信息对象
	 */
	public UserInfo queryByUserCode(String userCode);

	/**
	 * 查询所有用户信息
	 * 
	 * @return 用户信息对象集合
	 */
	public List<UserInfo> getAllUserInfo();
}
