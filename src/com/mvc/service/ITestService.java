package com.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.pojo.UserInfo;

@Service
public interface ITestService {
	
	/**
	 * ��user_info������������
	 */
	public List<UserInfo> testTransaction();

}
