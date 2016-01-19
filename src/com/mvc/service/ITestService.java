package com.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.pojo.UserInfo;

@Service
public interface ITestService {
	
	/**
	 * 对user_info表进行事务测试
	 */
	public List<UserInfo> testTransaction();

}
